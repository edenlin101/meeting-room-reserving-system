package app.resource.api.room;
import core.framework.api.validate.NotNull;
import core.framework.api.json.Property;

public class BOCreateRoomResponse {
    @NotNull
    @Property(name = "id") public Long id;
}