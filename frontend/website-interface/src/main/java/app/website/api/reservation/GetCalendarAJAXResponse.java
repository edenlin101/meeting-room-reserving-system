package app.website.api.reservation;
import core.framework.api.json.Property;
import core.framework.api.validate.NotNull;
import java.util.List;

public class GetCalendarAJAXResponse {
    @NotNull
    @Property(name = "reservations")
    public List<ReservationAJAXView> reservations;
}