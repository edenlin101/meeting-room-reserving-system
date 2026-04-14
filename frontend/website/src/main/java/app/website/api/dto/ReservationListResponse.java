package app.website.api.dto;

import core.framework.api.web.service.Property;

import java.util.List;

public class ReservationListResponse {
    @Property(name = "items")
    public List<ReservationView> items;
}