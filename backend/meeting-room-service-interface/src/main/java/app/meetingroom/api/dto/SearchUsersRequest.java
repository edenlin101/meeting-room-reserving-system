package app.meetingroom.api.dto;

import core.framework.api.web.service.QueryParam;

public class SearchUsersRequest {
    @QueryParam(name = "company_id")
    public Long companyId;
}