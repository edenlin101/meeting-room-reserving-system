package app.meetingroom.api.reservation;
import core.framework.api.validate.NotNull;

import core.framework.api.web.service.QueryParam;

public class SearchReservationRequest {
    @NotNull
    @QueryParam(name = "date")
    public String date;
}