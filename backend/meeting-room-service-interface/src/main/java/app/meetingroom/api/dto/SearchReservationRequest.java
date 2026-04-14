package app.meetingroom.api.dto;

import core.framework.api.web.service.QueryParam;

public class SearchReservationRequest {
    @QueryParam(name = "date")
    public String date;
}