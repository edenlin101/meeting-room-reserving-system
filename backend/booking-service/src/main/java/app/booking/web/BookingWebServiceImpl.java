package app.booking.web;
import app.booking.api.BookingWebService;
import app.booking.api.reservation.CancelReservationRequest;
import app.booking.api.reservation.CancelReservationResponse;
import app.booking.api.reservation.GetCalendarRequest;
import app.booking.api.reservation.GetCalendarResponse;
import app.booking.api.reservation.ReservationView;
import app.booking.api.reservation.ReserveRoomRequest;
import app.booking.api.reservation.ReserveRoomResponse;
import app.booking.domain.Reservation;
import app.booking.service.BookingService;
import core.framework.inject.Inject;
import java.util.stream.Collectors;
import java.util.List;

public class BookingWebServiceImpl implements BookingWebService {
    @Inject BookingService bookingService;

    @Override
    public GetCalendarResponse calendar(GetCalendarRequest request) {
        List<Reservation> reservations = bookingService.getReservations(request.roomId, request.date);
        GetCalendarResponse response = new GetCalendarResponse();
        response.reservations = reservations.stream().map(this::view).collect(Collectors.toList());
        return response;
    }

    @Override
    public ReserveRoomResponse reserve(ReserveRoomRequest request) {
        Reservation reservation = bookingService.reserve(request.roomId, request.userId, request.startTime, request.endTime);
        ReserveRoomResponse response = new ReserveRoomResponse();
        response.id = reservation.id;
        return response;
    }

    @Override
    public CancelReservationResponse cancel(CancelReservationRequest request) {
        bookingService.cancel(request.id, request.userId);
        return new CancelReservationResponse();
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