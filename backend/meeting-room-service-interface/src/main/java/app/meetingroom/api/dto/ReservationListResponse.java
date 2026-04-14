package app.meetingroom.api.dto;

import core.framework.api.json.Property;

import java.util.List;

public class ReservationListResponse {
    @Property(name = "items")
    public List<ReservationView> items;
}