package app.booking;
import app.booking.api.BOBookingWebService;
import app.booking.api.BookingWebService;
import app.booking.api.kafka.CheckUpcomingReservationMessage;
import app.booking.api.kafka.NotifyUpcomingReservationMessage;
import app.booking.domain.Reservation;
import app.booking.service.BOBookingService;
import app.booking.service.BookingService;
import app.booking.service.CheckUpcomingReservationMessageHandler;
import app.booking.web.BOBookingWebServiceImpl;
import app.booking.web.BookingWebServiceImpl;
import core.framework.module.Module;

public class BookingModule extends Module {
    @Override
    protected void initialize() {
        loadProperties("app.properties");
        
        db().repository(Reservation.class);

        kafka().uri(requiredProperty("sys.kafka.uri"));
        kafka().publish("notify-upcoming-reservation", NotifyUpcomingReservationMessage.class);
        kafka().subscribe("check-upcoming-reservation", CheckUpcomingReservationMessage.class, bind(CheckUpcomingReservationMessageHandler.class));

        bind(BookingService.class);
        bind(BOBookingService.class);
        
        api().service(BookingWebService.class, bind(BookingWebServiceImpl.class));
        api().service(BOBookingWebService.class, bind(BOBookingWebServiceImpl.class));
    }
}