package app.website.api.reservation;
import core.framework.api.validate.NotNull;
import core.framework.api.json.Property;

public class ReserveRoomAJAXResponse {
    @NotNull
    @Property(name = "id") public Long id;
}