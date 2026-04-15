package app.booking.web;
import app.booking.api.BOBookingWebService;
import app.booking.api.reservation.BOSearchReservationRequest;
import app.booking.api.reservation.BOSearchReservationResponse;
import app.booking.api.reservation.ReservationView;
import app.booking.domain.Reservation;
import app.booking.service.BOBookingService;
import core.framework.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class BOBookingWebServiceImpl implements BOBookingWebService {
    @Inject
    BOBookingService boBookingService;

    @Override
    public BOSearchReservationResponse list(BOSearchReservationRequest request) {
        List<Reservation> reservations = boBookingService.search(request.companyId, request.roomId);
        BOSearchReservationResponse response = new BOSearchReservationResponse();
        response.reservations = reservations.stream().map(this::view).collect(Collectors.toList());
        return response;
    }

    private ReservationView view(Reservation reservation) {
        ReservationView view = new ReservationView();
        view.id = reservation.id;
        view.roomId = reservation.roomId;
        view.userId = reservation.userId;
        view.startTime = reservation.startTime;
        view.endTime = reservation.endTime;
        view.status = reservation.status.name();
        return view;
    }
}