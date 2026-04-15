package app.backoffice.resource.api.room;
import core.framework.api.web.service.QueryParam;
public class ListRoomAJAXRequest {
    @QueryParam(name = "company_id")
    public Long companyId;
}