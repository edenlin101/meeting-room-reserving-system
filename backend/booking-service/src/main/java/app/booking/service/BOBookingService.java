package app.booking.service;
import app.booking.domain.Reservation;
import core.framework.db.Repository;
import core.framework.inject.Inject;
import core.framework.db.Query;
import java.util.List;

public class BOBookingService {
    @Inject
    Repository<Reservation> reservationRepository;

    public List<Reservation> search(Long companyId, Long roomId) {
        Query<Reservation> query = reservationRepository.select();
        if (roomId != null) {
            query.where("room_id = ?", roomId);
        }
        // In a real scenario, filtering by company_id might require joining or verifying rooms.
        return query.fetch();
    }
}