package app.booking.api.reservation;
import core.framework.api.validate.NotNull;
import core.framework.api.json.Property;

public class ReserveRoomResponse {
    @NotNull
    @Property(name = "id") public Long id;
}