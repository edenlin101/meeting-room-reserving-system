package app.website;

import app.user.api.UserWebService;
import app.resource.api.CompanyWebService;
import app.resource.api.RoomWebService;
import app.booking.api.BookingWebService;
import app.website.user.api.UserAJAXWebService;
import app.website.user.web.UserAJAXWebServiceImpl;
import app.website.resource.api.ResourceAJAXWebService;
import app.website.resource.web.ResourceAJAXWebServiceImpl;
import app.website.reservation.api.ReservationAJAXWebService;
import app.website.reservation.web.ReservationAJAXWebServiceImpl;
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
