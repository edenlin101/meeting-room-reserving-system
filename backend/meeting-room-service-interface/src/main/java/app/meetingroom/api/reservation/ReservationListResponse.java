package app.meetingroom.api.reservation;
import core.framework.api.validate.NotNull;

import core.framework.api.json.Property;

import java.util.List;

public class ReservationListResponse {
    @NotNull
    @Property(name = "items")
    public List<ReservationView> items;
}