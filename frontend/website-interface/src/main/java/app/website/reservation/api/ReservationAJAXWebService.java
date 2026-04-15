package app.website.reservation.api;
import app.website.reservation.api.reservation.CancelReservationAJAXRequest;
import app.website.reservation.api.reservation.CancelReservationAJAXResponse;
import app.website.reservation.api.reservation.GetCalendarAJAXRequest;
import app.website.reservation.api.reservation.GetCalendarAJAXResponse;
import app.website.reservation.api.reservation.ReserveRoomAJAXRequest;
import app.website.reservation.api.reservation.ReserveRoomAJAXResponse;
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