package app.meetingroom.api.room;
import core.framework.api.validate.NotNull;

import core.framework.api.web.service.QueryParam;

public class SearchRoomsRequest {
    @NotNull
    @QueryParam(name = "company_id")
    public Long companyId;
}