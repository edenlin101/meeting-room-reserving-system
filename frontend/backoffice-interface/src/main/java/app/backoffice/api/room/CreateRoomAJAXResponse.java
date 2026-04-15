package app.backoffice.api.room;
import core.framework.api.validate.NotNull;
import core.framework.api.json.Property;

public class CreateRoomAJAXResponse {
    @NotNull
    @Property(name = "id")
    public Long id;
}