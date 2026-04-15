package app.website.reservation.web;
import app.booking.api.BookingWebService;
import app.booking.api.reservation.CancelReservationRequest;
import app.booking.api.reservation.GetCalendarRequest;
import app.booking.api.reservation.GetCalendarResponse;
import app.booking.api.reservation.ReserveRoomRequest;
import app.booking.api.reservation.ReserveRoomResponse;
import app.website.reservation.api.ReservationAJAXWebService;
import app.website.reservation.api.reservation.CancelReservationAJAXRequest;
import app.website.reservation.api.reservation.CancelReservationAJAXResponse;
import app.website.reservation.api.reservation.GetCalendarAJAXRequest;
import app.website.reservation.api.reservation.GetCalendarAJAXResponse;
import app.website.reservation.api.reservation.ReservationAJAXView;
import app.website.reservation.api.reservation.ReserveRoomAJAXRequest;
import app.website.reservation.api.reservation.ReserveRoomAJAXResponse;
import core.framework.inject.Inject;
import java.util.stream.Collectors;
public class ReservationAJAXWebServiceImpl implements ReservationAJAXWebService {
    @Inject BookingWebService bookingWebService;
    
    @Override
    public GetCalendarAJAXResponse calendar(GetCalendarAJAXRequest request) {
        GetCalendarRequest calendarRequest = new GetCalendarRequest();
        calendarRequest.roomId = request.roomId;
        calendarRequest.date = request.date;
        
        GetCalendarResponse response = bookingWebService.calendar(calendarRequest);
        GetCalendarAJAXResponse ajaxResponse = new GetCalendarAJAXResponse();
        ajaxResponse.reservations = response.reservations.stream().map(res -> {
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
    
    @Override
    public ReserveRoomAJAXResponse reserve(ReserveRoomAJAXRequest request) {
        ReserveRoomRequest reserveRequest = new ReserveRoomRequest();
        reserveRequest.roomId = request.roomId;
        reserveRequest.startTime = request.startTime;
        reserveRequest.endTime = request.endTime;
        reserveRequest.userId = 1L; // To be extracted from session in real impl
        
        ReserveRoomResponse response = bookingWebService.reserve(reserveRequest);
        ReserveRoomAJAXResponse ajaxResponse = new ReserveRoomAJAXResponse();
        ajaxResponse.id = response.id;
        return ajaxResponse;
    }
    
    @Override
    public CancelReservationAJAXResponse cancel(CancelReservationAJAXRequest request) {
        CancelReservationRequest cancelRequest = new CancelReservationRequest();
        cancelRequest.id = request.id;
        cancelRequest.userId = 1L; // To be extracted from session
        bookingWebService.cancel(cancelRequest);
        return new CancelReservationAJAXResponse();
    }
}