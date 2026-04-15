package app.meetingroom.api.user;
import core.framework.api.validate.NotNull;

import core.framework.api.web.service.QueryParam;

public class SearchUsersRequest {
    @NotNull
    @QueryParam(name = "company_id")
    public Long companyId;
}