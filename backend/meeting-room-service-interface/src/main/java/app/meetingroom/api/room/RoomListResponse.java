package app.meetingroom.api.room;

import core.framework.api.json.Property;

import java.util.List;

public class RoomListResponse {
    @Property(name = "items")
    public List<RoomView> items;
}