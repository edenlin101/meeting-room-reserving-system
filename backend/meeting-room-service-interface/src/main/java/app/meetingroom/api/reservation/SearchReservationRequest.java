package app.meetingroom.api.reservation;

import core.framework.api.web.service.QueryParam;

public class SearchReservationRequest {
    @QueryParam(name = "date")
    public String date;
}