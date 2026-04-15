package app.website.api;
import app.website.api.reservation.CancelReservationAJAXRequest;
import app.website.api.reservation.CancelReservationAJAXResponse;
import app.website.api.reservation.GetCalendarAJAXRequest;
import app.website.api.reservation.GetCalendarAJAXResponse;
import app.website.api.reservation.ReserveRoomAJAXRequest;
import app.website.api.reservation.ReserveRoomAJAXResponse;
import core.framework.api.web.service.GET;
import core.framework.api.web.service.POST;
import core.framework.api.web.service.Path;

public interface ReservationAJAXWebService {
    @GET
    @Path("/ajax/reservation/calendar")
    GetCalendarAJAXResponse calendar(GetCalendarAJAXRequest request);
    @POST
    @Path("/ajax/reservation/reserve")
    ReserveRoomAJAXResponse reserve(ReserveRoomAJAXRequest request);
    @POST
    @Path("/ajax/reservation/cancel")
    CancelReservationAJAXResponse cancel(CancelReservationAJAXRequest request);
}