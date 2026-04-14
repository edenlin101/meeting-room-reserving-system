package app.meetingroom.api.dto;

import core.framework.api.web.service.QueryParam;

public class SearchRoomsRequest {
    @QueryParam(name = "company_id")
    public Long companyId;
}