package app.backoffice.api.reservation;
import core.framework.api.validate.NotNull;
import core.framework.api.web.service.QueryParam;

public class SearchReservationAJAXRequest {
    @NotNull
    @QueryParam(name = "company_id")
    public Long companyId;

    @NotNull
    @QueryParam(name = "room_id")
    public Long roomId;
}