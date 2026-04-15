package app.website.user;

import app.user.api.UserWebService;
import app.user.api.user.LoginUserRequest;
import app.user.api.user.LoginUserResponse;
import app.user.api.user.RegisterUserRequest;
import app.user.api.user.RegisterUserResponse;
import app.website.api.user.LoginAJAXRequest;
import app.website.api.user.LoginAJAXResponse;
import app.website.api.user.RegisterUserAJAXRequest;
import app.website.api.user.RegisterUserAJAXResponse;
import app.website.api.UserAJAXWebService;
import core.framework.inject.Inject;
import core.framework.web.Request;

public class UserAJAXWebServiceImpl implements UserAJAXWebService {
    @Inject
    UserWebService userWebService;
    @Inject
    Request request;

    @Override
    public RegisterUserAJAXResponse register(RegisterUserAJAXRequest ajaxRequest) {
        RegisterUserRequest serviceRequest = new RegisterUserRequest();
        serviceRequest.username = ajaxRequest.username;
        serviceRequest.password = ajaxRequest.password;
        serviceRequest.companyId = ajaxRequest.companyId;
        
        RegisterUserResponse serviceResponse = userWebService.register(serviceRequest);
        
        RegisterUserAJAXResponse ajaxResponse = new RegisterUserAJAXResponse();
        ajaxResponse.userId = serviceResponse.id;
        
        return ajaxResponse;
    }

    @Override
    public LoginAJAXResponse login(LoginAJAXRequest ajaxRequest) {
        LoginUserRequest serviceRequest = new LoginUserRequest();
        serviceRequest.username = ajaxRequest.username;
        serviceRequest.password = ajaxRequest.password;
        
        LoginUserResponse serviceResponse = userWebService.login(serviceRequest);
        
        LoginAJAXResponse ajaxResponse = new LoginAJAXResponse();
        ajaxResponse.token = serviceResponse.token;
        ajaxResponse.userId = serviceResponse.id;
        
        request.session().set("userId", String.valueOf(serviceResponse.id));
        
        return ajaxResponse;
    }
}
