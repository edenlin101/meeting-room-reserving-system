package com.wonder.meetingroom.web;

import com.wonder.meetingroom.api.ReservationWebService;
import com.wonder.meetingroom.api.dto.ReservationRequest;
import com.wonder.meetingroom.api.dto.ReservationView;
import com.wonder.meetingroom.service.ReservationService;
import core.framework.inject.Inject;

import java.util.List;

/**
 * @author Opencode
 */
public class ReservationWebServiceImpl implements ReservationWebService {
    @Inject
    ReservationService reservationService;

    @Override
    public List<ReservationView> search(Long roomId, String date) {
        return reservationService.search(roomId, date);
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
