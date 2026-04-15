package app.booking.api.reservation;
import app.booking.api.reservation.ReservationView;
import core.framework.api.json.Property;
import core.framework.api.validate.NotNull;
import java.util.List;

public class BOSearchReservationResponse {
    @NotNull @Property(name = "reservations") public List<ReservationView> reservations;
}