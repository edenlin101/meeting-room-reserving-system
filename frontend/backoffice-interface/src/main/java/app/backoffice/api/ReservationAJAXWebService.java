package app.backoffice.api;
import app.backoffice.api.reservation.SearchReservationAJAXRequest;
import app.backoffice.api.reservation.SearchReservationAJAXResponse;
import core.framework.api.web.service.GET;
import core.framework.api.web.service.Path;

public interface ReservationAJAXWebService {
    @GET
    @Path("/ajax/reservation/list")
    SearchReservationAJAXResponse search(SearchReservationAJAXRequest request);
}