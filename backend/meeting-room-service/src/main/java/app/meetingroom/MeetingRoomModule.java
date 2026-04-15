package app.meetingroom;

import app.meetingroom.api.AdminWebService;
import app.meetingroom.api.AuthWebService;
import app.meetingroom.api.MeetingRoomWebService;
import app.meetingroom.api.ReservationWebService;
import app.meetingroom.domain.Company;
import app.meetingroom.domain.Reservation;
import app.meetingroom.domain.Room;
import app.meetingroom.domain.User;
import app.meetingroom.kafka.ReservationReminderEvent;
import app.meetingroom.kafka.ReservationReminderHandler;
import app.meetingroom.kafka.NotificationService;
import app.meetingroom.scheduler.ReservationReminderJob;
import app.meetingroom.service.CompanyService;
import app.meetingroom.service.MeetingRoomService;
import app.meetingroom.service.ReservationService;
import app.meetingroom.service.UserService;
import app.meetingroom.web.AdminWebServiceImpl;
import app.meetingroom.web.AuthWebServiceImpl;
import app.meetingroom.web.MeetingRoomWebServiceImpl;
import app.meetingroom.web.ReservationWebServiceImpl;
import core.framework.module.Module;

public class MeetingRoomModule extends Module {
    @Override
    protected void initialize() {
        db().repository(Company.class);
        db().repository(Room.class);
        db().repository(Reservation.class);
        db().repository(User.class);

        bind(CompanyService.class);
        bind(MeetingRoomService.class);
        bind(ReservationService.class);
        bind(UserService.class);

        api().service(AuthWebService.class, bind(AuthWebServiceImpl.class));
        api().service(AdminWebService.class, bind(AdminWebServiceImpl.class));
        api().service(MeetingRoomWebService.class, bind(MeetingRoomWebServiceImpl.class));
        api().service(ReservationWebService.class, bind(ReservationWebServiceImpl.class));

        kafka().uri(requiredProperty("sys.kafka.url"));
        kafka().publish("reservation-reminder", ReservationReminderEvent.class);
        bind(NotificationService.class);
        bind(ReservationReminderHandler.class);
        bind(ReservationReminderJob.class);
    }
}
