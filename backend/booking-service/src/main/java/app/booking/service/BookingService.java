package app.booking.service;
import app.booking.domain.Reservation;
import app.booking.domain.ReservationStatus;
import core.framework.db.Repository;
import core.framework.inject.Inject;
import core.framework.web.exception.ConflictException;
import core.framework.web.exception.NotFoundException;
import java.time.ZonedDateTime;
import java.util.List;

public class BookingService {
    @Inject Repository<Reservation> reservationRepository;

    public List<Reservation> getReservations(Long roomId, ZonedDateTime date) {
        ZonedDateTime startOfDay = date.toLocalDate().atStartOfDay(date.getZone());
        ZonedDateTime endOfDay = startOfDay.plusDays(1);
        return reservationRepository.select("room_id = ? AND start_time >= ? AND start_time < ? AND status = ?", 
                                            roomId, startOfDay, endOfDay, ReservationStatus.ACTIVE);
    }

    public Reservation reserve(Long roomId, Long userId, ZonedDateTime startTime, ZonedDateTime endTime) {
        // Check conflicts
        long conflicts = reservationRepository.count("room_id = ? AND status = ? AND start_time < ? AND end_time > ?", 
                                                     roomId, ReservationStatus.ACTIVE, endTime, startTime);
        if (conflicts > 0) {
            throw new ConflictException("Room is already reserved for the given time slot");
        }

        Reservation reservation = new Reservation();
        reservation.roomId = roomId;
        reservation.userId = userId;
        reservation.startTime = startTime;
        reservation.endTime = endTime;
        reservation.status = ReservationStatus.ACTIVE;
        reservation.createdTime = ZonedDateTime.now();
        reservation.id = reservationRepository.insert(reservation).orElseThrow();
        return reservation;
    }

    public void cancel(Long id, Long userId) {
        Reservation reservation = reservationRepository.get(id)
            .orElseThrow(() -> new NotFoundException("reservation not found, id=" + id));
        if (!reservation.userId.equals(userId)) {
            throw new ConflictException("Cannot cancel reservation made by another user");
        }
        reservation.status = ReservationStatus.CANCELLED;
        reservation.updatedTime = ZonedDateTime.now();
        reservationRepository.update(reservation);
    }
}