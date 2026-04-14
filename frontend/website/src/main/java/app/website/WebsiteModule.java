package app.website;

import app.user.api.UserWebService;
import app.website.user.api.UserAJAXWebService;
import app.website.user.web.UserAJAXWebServiceImpl;
import core.framework.module.Module;

public class WebsiteModule extends Module {
    @Override
    protected void initialize() {
        api().client(UserWebService.class, requiredProperty("app.userService.url"));
        
        api().service(UserAJAXWebService.class, bind(UserAJAXWebServiceImpl.class));
    }
}
