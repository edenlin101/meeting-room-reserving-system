package app.booking;
import app.booking.api.BOBookingWebService;
import app.booking.api.BookingWebService;
import app.booking.domain.Reservation;
import app.booking.service.BOBookingService;
import app.booking.service.BookingService;
import app.booking.web.BOBookingWebServiceImpl;
import app.booking.web.BookingWebServiceImpl;
import core.framework.module.Module;

public class BookingModule extends Module {
    @Override
    protected void initialize() {
        loadProperties("app.properties");
        
        db().repository(Reservation.class);

        bind(BookingService.class);
        bind(BOBookingService.class);

        api().service(BookingWebService.class, bind(BookingWebServiceImpl.class));
        api().service(BOBookingWebService.class, bind(BOBookingWebServiceImpl.class));
    }
}