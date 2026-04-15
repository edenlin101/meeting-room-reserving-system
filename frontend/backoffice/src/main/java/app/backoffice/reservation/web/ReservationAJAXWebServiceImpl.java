package app.backoffice.reservation.web;
import app.booking.api.BOBookingWebService;
import app.booking.api.bo.reservation.BOSearchReservationRequest;
import app.booking.api.bo.reservation.BOSearchReservationResponse;
import app.backoffice.reservation.api.ReservationAJAXWebService;
import app.backoffice.reservation.api.reservation.ReservationAJAXView;
import app.backoffice.reservation.api.reservation.SearchReservationAJAXRequest;
import app.backoffice.reservation.api.reservation.SearchReservationAJAXResponse;
import core.framework.inject.Inject;
import java.util.stream.Collectors;
public class ReservationAJAXWebServiceImpl implements ReservationAJAXWebService {
    @Inject BOBookingWebService boBookingWebService;

    @Override
    public SearchReservationAJAXResponse search(SearchReservationAJAXRequest request) {
        BOSearchReservationRequest boRequest = new BOSearchReservationRequest();
        boRequest.companyId = request.companyId;
        boRequest.roomId = request.roomId;
        BOSearchReservationResponse boResponse = boBookingWebService.list(boRequest);
        SearchReservationAJAXResponse ajaxResponse = new SearchReservationAJAXResponse();
        ajaxResponse.reservations = boResponse.reservations.stream().map(res -> {
            ReservationAJAXView view = new ReservationAJAXView();
            view.id = res.id;
            view.roomId = res.roomId;
            view.userId = res.userId;
            view.startTime = res.startTime;
            view.endTime = res.endTime;
            view.status = res.status;
            return view;
        }).collect(Collectors.toList());
        return ajaxResponse;
    }
}