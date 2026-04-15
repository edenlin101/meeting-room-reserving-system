package app.booking.api;
import app.booking.api.bo.reservation.BOSearchReservationRequest;
import app.booking.api.bo.reservation.BOSearchReservationResponse;
import core.framework.api.web.service.GET;
import core.framework.api.web.service.Path;
public interface BOBookingWebService {
    @GET @Path("/bo/reservation/list") BOSearchReservationResponse list(BOSearchReservationRequest request);
}