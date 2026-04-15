package app.meetingroom.api.room;
import core.framework.api.validate.NotNull;

import core.framework.api.json.Property;

import java.util.List;

public class RoomListResponse {
    @NotNull
    @Property(name = "items")
    public List<RoomView> items;
}