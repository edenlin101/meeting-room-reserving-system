package app.booking.api.bo.reservation;
import core.framework.api.web.service.QueryParam;
public class BOSearchReservationRequest {
    @QueryParam(name = "company_id") public Long companyId;
    @QueryParam(name = "room_id") public Long roomId;
}