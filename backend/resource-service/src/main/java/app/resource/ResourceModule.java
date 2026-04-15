package app.resource;
import app.resource.api.BOCompanyWebService;
import app.resource.api.BORoomWebService;
import app.resource.api.CompanyWebService;
import app.resource.api.RoomWebService;
import app.resource.domain.Company;
import app.resource.domain.Room;
import app.resource.service.BOCompanyService;
import app.resource.service.BORoomService;
import app.resource.service.CompanyService;
import app.resource.service.RoomService;
import app.resource.web.BOCompanyWebServiceImpl;
import app.resource.web.BORoomWebServiceImpl;
import app.resource.web.CompanyWebServiceImpl;
import app.resource.web.RoomWebServiceImpl;
import core.framework.module.Module;

public class ResourceModule extends Module {
    @Override
    protected void initialize() {
        loadProperties("app.properties");
        
        db().repository(Company.class);
        db().repository(Room.class);

        bind(CompanyService.class);
        bind(RoomService.class);
        bind(BOCompanyService.class);
        bind(BORoomService.class);

        api().service(CompanyWebService.class, bind(CompanyWebServiceImpl.class));
        api().service(RoomWebService.class, bind(RoomWebServiceImpl.class));
        api().service(BOCompanyWebService.class, bind(BOCompanyWebServiceImpl.class));
        api().service(BORoomWebService.class, bind(BORoomWebServiceImpl.class));
    }
}