package app.backoffice.api.room;
import core.framework.api.validate.NotNull;
import core.framework.api.web.service.QueryParam;

public class ListRoomAJAXRequest {
    @NotNull
    @QueryParam(name = "company_id")
    public Long companyId;
}