package app.meetingroom.api.reservation;

import core.framework.api.web.service.QueryParam;

public class SearchReservationsRequest {
    @QueryParam(name = "company_id")
    public Long companyId;

    @QueryParam(name = "room_id")
    public Long roomId;
}