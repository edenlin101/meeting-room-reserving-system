package app.backoffice.reservation.api;
import app.backoffice.reservation.api.reservation.SearchReservationAJAXRequest;
import app.backoffice.reservation.api.reservation.SearchReservationAJAXResponse;
import core.framework.api.web.service.GET;
import core.framework.api.web.service.Path;
public interface ReservationAJAXWebService {
    @GET
    @Path("/ajax/reservation/list")
    SearchReservationAJAXResponse search(SearchReservationAJAXRequest request);
}