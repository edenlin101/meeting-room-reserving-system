package app.website.reservation.api.reservation;
import core.framework.api.json.Property;
import core.framework.api.validate.NotNull;
public class CancelReservationAJAXRequest {
    @NotNull
    @Property(name = "id")
    public Long id;
}