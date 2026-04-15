package app.booking;
import app.booking.api.BOBookingWebService;
import app.booking.api.BookingWebService;
import app.booking.api.kafka.ReservationUpcomingMessage;
import app.booking.domain.Reservation;
import app.booking.service.BOBookingService;
import app.booking.service.BookingService;
import app.booking.service.NotifyUpcomingReservationsJob;
import app.booking.web.BOBookingWebServiceImpl;
import app.booking.web.BookingWebServiceImpl;
import core.framework.module.Module;
import java.time.Duration;

public class BookingModule extends Module {
    @Override
    protected void initialize() {
        loadProperties("app.properties");
        
        db().repository(Reservation.class);
        
        kafka().uri(requiredProperty("sys.kafka.uri"));
        kafka().publish("reservation-upcoming", ReservationUpcomingMessage.class);

        bind(BookingService.class);
        bind(BOBookingService.class);
        
        NotifyUpcomingReservationsJob job = bind(NotifyUpcomingReservationsJob.class);
        schedule().fixedRate("notify-upcoming-reservations", job, Duration.ofMinutes(1));

        api().service(BookingWebService.class, bind(BookingWebServiceImpl.class));
        api().service(BOBookingWebService.class, bind(BOBookingWebServiceImpl.class));
    }
}