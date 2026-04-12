package com.wonder.meetingroom;

import com.wonder.meetingroom.api.AdminWebService;
import com.wonder.meetingroom.api.AuthWebService;
import com.wonder.meetingroom.api.MeetingRoomWebService;
import com.wonder.meetingroom.api.ReservationWebService;
import com.wonder.meetingroom.domain.Company;
import com.wonder.meetingroom.domain.Reservation;
import com.wonder.meetingroom.domain.Room;
import com.wonder.meetingroom.domain.User;
import com.wonder.meetingroom.kafka.ReservationReminderEvent;
import com.wonder.meetingroom.kafka.ReservationReminderHandler;
import com.wonder.meetingroom.scheduler.ReservationReminderJob;
import com.wonder.meetingroom.service.CompanyService;
import com.wonder.meetingroom.service.MeetingRoomService;
import com.wonder.meetingroom.service.ReservationService;
import com.wonder.meetingroom.service.UserService;
import com.wonder.meetingroom.web.AdminWebServiceImpl;
import com.wonder.meetingroom.web.AuthWebServiceImpl;
import com.wonder.meetingroom.web.MeetingRoomWebServiceImpl;
import com.wonder.meetingroom.web.ReservationWebServiceImpl;
import core.framework.module.Module;

/**
 * @author Opencode
 */
public class MeetingRoomModule extends Module {
    @Override
    protected void initialize() {
        // configure db
        db().repository(Company.class);
        db().repository(Room.class);
        db().repository(Reservation.class);
        db().repository(User.class);

        // bind services
        bind(CompanyService.class);
        bind(MeetingRoomService.class);
        bind(ReservationService.class);
        bind(UserService.class);

        // register web services
        api().service(AuthWebService.class, bind(AuthWebServiceImpl.class));
        api().service(AdminWebService.class, bind(AdminWebServiceImpl.class));
        api().service(MeetingRoomWebService.class, bind(MeetingRoomWebServiceImpl.class));
        api().service(ReservationWebService.class, bind(ReservationWebServiceImpl.class));

        // configure kafka
        kafka().publish("reservation-reminder", ReservationReminderEvent.class);
        kafka().subscribe("reservation-reminder", ReservationReminderEvent.class, new ReservationReminderHandler());

        // register scheduled jobs
        schedule().fixedRate("reservation-reminder", new ReservationReminderJob(), java.time.Duration.ofMinutes(1));
    }
}