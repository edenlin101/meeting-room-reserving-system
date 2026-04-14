package app.meetingroom.web;

import app.meetingroom.api.ReservationWebService;
import app.meetingroom.api.dto.ReservationListResponse;
import app.meetingroom.api.dto.ReservationRequest;
import app.meetingroom.api.dto.ReservationView;
import app.meetingroom.api.dto.SearchReservationRequest;
import app.meetingroom.service.ReservationService;
import core.framework.inject.Inject;

public class ReservationWebServiceImpl implements ReservationWebService {
    @Inject
    ReservationService reservationService;

    @Override
    public ReservationListResponse search(Long roomId, SearchReservationRequest request) {
        ReservationListResponse response = new ReservationListResponse();
        response.items = reservationService.search(roomId, request.date);
        return response;
    }

    @Override
    public ReservationView create(Long roomId, ReservationRequest request) {
        return reservationService.create(roomId, request);
    }

    @Override
    public void cancel(Long id) {
        reservationService.cancel(id);
    }
}