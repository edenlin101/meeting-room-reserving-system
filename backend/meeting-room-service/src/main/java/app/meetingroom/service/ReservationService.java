package app.meetingroom.service;

import app.meetingroom.api.dto.ReservationRequest;
import app.meetingroom.api.dto.ReservationView;
import app.meetingroom.domain.Reservation;
import app.meetingroom.domain.ReservationStatus;
import core.framework.db.Query;
import core.framework.db.Repository;
import core.framework.inject.Inject;
import core.framework.web.exception.NotFoundException;
import core.framework.web.exception.ConflictException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

public class ReservationService {
    @Inject
    Repository<Reservation> reservationRepository;

    public List<ReservationView> search(Long roomId, String date) {
        LocalDate localDate = LocalDate.parse(date);
        LocalDateTime startOfDay = localDate.atStartOfDay();
        LocalDateTime endOfDay = localDate.atTime(LocalTime.MAX);
        
        List<Reservation> reservations = reservationRepository.select("room_id = ? AND start_time >= ? AND start_time <= ?", roomId, startOfDay, endOfDay);
        return reservations.stream().map(this::view).collect(Collectors.toList());
    }

    public List<ReservationView> searchByRoom(Long roomId) {
        List<Reservation> reservations = reservationRepository.select("room_id = ?", roomId);
        return reservations.stream().map(this::view).collect(Collectors.toList());
    }

    public List<ReservationView> searchAll() {
        Query<Reservation> query = reservationRepository.select();
        List<Reservation> reservations = query.fetch();
        return reservations.stream().map(this::view).collect(Collectors.toList());
    }

    public ReservationView create(Long roomId, ReservationRequest request) {
        long conflicts = reservationRepository.count("room_id = ? AND status = ? AND ((start_time < ? AND end_time > ?) OR (start_time < ? AND end_time > ?))",
                roomId, ReservationStatus.CONFIRMED.name(), request.endTime, request.startTime, request.startTime, request.endTime);
        
        if (conflicts > 0) {
            throw new ConflictException("room is already reserved for the requested time", "CONFLICT");
        }

        Reservation reservation = new Reservation();
        reservation.roomId = roomId;
        reservation.userId = request.userId;
        reservation.startTime = request.startTime;
        reservation.endTime = request.endTime;
        reservation.status = ReservationStatus.CONFIRMED;
        reservation.id = reservationRepository.insert(reservation).orElseThrow();

        return view(reservation);
    }

    public void cancel(Long id) {
        Reservation reservation = reservationRepository.get(id).orElseThrow(() -> new NotFoundException("reservation not found, id=" + id));
        reservation.status = ReservationStatus.CANCELLED;
        reservationRepository.update(reservation);
    }

    public List<Long> getUpcomingReservations() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime oneHourLater = now.plusHours(1);
        List<Reservation> reservations = reservationRepository.select(
            "status = ? AND start_time >= ? AND start_time <= ?",
            ReservationStatus.CONFIRMED.name(), now, oneHourLater);
        return reservations.stream().map(r -> r.id).collect(Collectors.toList());
    }

    private ReservationView view(Reservation reservation) {
        ReservationView view = new ReservationView();
        view.id = reservation.id;
        view.roomId = reservation.roomId;
        view.userId = reservation.userId;
        view.startTime = reservation.startTime;
        view.endTime = reservation.endTime;
        view.status = reservation.status != null ? reservation.status.name() : null;
        return view;
    }
}
