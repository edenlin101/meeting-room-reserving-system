package app.booking.api.reservation;
import core.framework.api.validate.NotNull;
import core.framework.api.web.service.QueryParam;

public class BOSearchReservationRequest {
    @QueryParam(name = "company_id") public Long companyId;
    @NotNull
    @QueryParam(name = "room_id") public Long roomId;
}