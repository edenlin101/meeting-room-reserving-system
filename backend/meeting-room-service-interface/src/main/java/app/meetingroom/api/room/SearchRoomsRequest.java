package app.meetingroom.api.room;

import core.framework.api.web.service.QueryParam;

public class SearchRoomsRequest {
    @QueryParam(name = "company_id")
    public Long companyId;
}