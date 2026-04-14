package app.user;

import app.user.api.BOUserWebService;
import app.user.api.UserWebService;
import app.user.domain.User;
import app.user.service.BOUserService;
import app.user.service.UserService;
import app.user.web.BOUserWebServiceImpl;
import app.user.web.UserWebServiceImpl;
import core.framework.module.Module;

public class UserModule extends Module {
    @Override
    protected void initialize() {
        loadProperties("app.properties");
        
        db().repository(User.class);
        
        bind(UserService.class);
        bind(BOUserService.class);
        
        api().service(UserWebService.class, bind(UserWebServiceImpl.class));
        api().service(BOUserWebService.class, bind(BOUserWebServiceImpl.class));

        http().listenHTTP(property("sys.http.listen").orElse("0.0.0.0:8080"));
    }
}