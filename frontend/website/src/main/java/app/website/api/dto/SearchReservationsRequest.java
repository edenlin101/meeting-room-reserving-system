package app.website.api.dto;

import core.framework.api.web.service.Property;

public class SearchReservationsRequest {
    @Property(name = "roomId")
    public Long roomId;

    @Property(name = "date")
    public String date;
}