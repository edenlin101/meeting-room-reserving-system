package com.wonder.meetingroom;

import com.wonder.meetingroom.api.MeetingRoomWebService;
import com.wonder.meetingroom.api.ReservationWebService;
import com.wonder.meetingroom.domain.Reservation;
import com.wonder.meetingroom.domain.Room;
import com.wonder.meetingroom.service.MeetingRoomService;
import com.wonder.meetingroom.web.MeetingRoomWebServiceImpl;
import com.wonder.meetingroom.service.ReservationService;
import com.wonder.meetingroom.web.ReservationWebServiceImpl;
import core.framework.module.Module;

/**
 * @author Opencode
 */
public class MeetingRoomModule extends Module {
    @Override
    protected void initialize() {
        // configure db
        db().repository(Room.class);
        db().repository(Reservation.class);

        // bind services
        bind(MeetingRoomService.class);
        bind(ReservationService.class);

        // register web services
        api().service(MeetingRoomWebService.class, bind(MeetingRoomWebServiceImpl.class));
        api().service(ReservationWebService.class, bind(ReservationWebServiceImpl.class));
    }
}
