package app.resource.api.bo.room;
import core.framework.api.web.service.QueryParam;
public class BOListRoomRequest {
    @QueryParam(name = "company_id") public Long companyId;
}