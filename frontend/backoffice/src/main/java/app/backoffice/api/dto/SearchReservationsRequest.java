package app.backoffice.api.dto;

import core.framework.api.web.service.Property;

public class SearchReservationsRequest {
    @Property(name = "roomId")
    public Long roomId;

    @Property(name = "companyId")
    public Long companyId;

    @Property(name = "date")
    public String date;
}