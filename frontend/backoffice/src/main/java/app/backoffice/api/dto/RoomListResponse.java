package app.backoffice.api.dto;

import core.framework.api.web.service.Property;

import java.util.List;

public class RoomListResponse {
    @Property(name = "items")
    public List<RoomView> items;
}