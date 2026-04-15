package app.booking.api;
import app.booking.api.reservation.CancelReservationRequest;
import app.booking.api.reservation.CancelReservationResponse;
import app.booking.api.reservation.GetCalendarRequest;
import app.booking.api.reservation.GetCalendarResponse;
import app.booking.api.reservation.ReserveRoomRequest;
import app.booking.api.reservation.ReserveRoomResponse;
import core.framework.api.web.service.GET;
import core.framework.api.web.service.POST;
import core.framework.api.web.service.Path;
public interface BookingWebService {
    @GET @Path("/reservation/calendar") GetCalendarResponse calendar(GetCalendarRequest request);
    @POST @Path("/reservation/reserve") ReserveRoomResponse reserve(ReserveRoomRequest request);
    @POST @Path("/reservation/cancel") CancelReservationResponse cancel(CancelReservationRequest request);
}