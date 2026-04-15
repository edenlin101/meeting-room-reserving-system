package app.backoffice;
import app.user.api.BOUserWebService;
import app.resource.api.BOCompanyWebService;
import app.resource.api.BORoomWebService;
import app.booking.api.BOBookingWebService;
import app.backoffice.api.AdminAJAXWebService;
import app.backoffice.admin.AdminAJAXWebServiceImpl;
import app.backoffice.api.ResourceAJAXWebService;
import app.backoffice.resource.ResourceAJAXWebServiceImpl;
import app.backoffice.api.ReservationAJAXWebService;
import app.backoffice.reservation.ReservationAJAXWebServiceImpl;
import core.framework.module.Module;

public class BackofficeModule extends Module {
    @Override
    protected void initialize() {
        site().session().local();

        api().client(BOUserWebService.class, requiredProperty("app.userService.url"));
        api().client(BOCompanyWebService.class, requiredProperty("app.resourceService.url"));
        api().client(BORoomWebService.class, requiredProperty("app.resourceService.url"));
        api().client(BOBookingWebService.class, requiredProperty("app.bookingService.url"));

        api().service(AdminAJAXWebService.class, bind(AdminAJAXWebServiceImpl.class));
        api().service(ResourceAJAXWebService.class, bind(ResourceAJAXWebServiceImpl.class));
        api().service(ReservationAJAXWebService.class, bind(ReservationAJAXWebServiceImpl.class));
    }
}