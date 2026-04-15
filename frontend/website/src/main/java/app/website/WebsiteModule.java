package app.website;

import app.user.api.UserWebService;
import app.resource.api.CompanyWebService;
import app.resource.api.RoomWebService;
import app.booking.api.BookingWebService;
import app.website.api.UserAJAXWebService;
import app.website.user.UserAJAXWebServiceImpl;
import app.website.api.ResourceAJAXWebService;
import app.website.resource.ResourceAJAXWebServiceImpl;
import app.website.api.ReservationAJAXWebService;
import app.website.reservation.ReservationAJAXWebServiceImpl;
import core.framework.module.Module;

public class WebsiteModule extends Module {
    @Override
    protected void initialize() {
        site().session().local();

        api().client(UserWebService.class, requiredProperty("app.userService.url"));
        api().client(CompanyWebService.class, requiredProperty("app.resourceService.url"));
        api().client(RoomWebService.class, requiredProperty("app.resourceService.url"));
        api().client(BookingWebService.class, requiredProperty("app.bookingService.url"));
        
        api().service(UserAJAXWebService.class, bind(UserAJAXWebServiceImpl.class));
        api().service(ResourceAJAXWebService.class, bind(ResourceAJAXWebServiceImpl.class));
        api().service(ReservationAJAXWebService.class, bind(ReservationAJAXWebServiceImpl.class));
    }
}
