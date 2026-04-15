package app.resource.api.room;
import core.framework.api.json.Property;
import java.util.List;
import core.framework.api.validate.NotNull;

public class ListRoomResponse {
    @NotNull @Property(name = "rooms") public List<RoomView> rooms;
}