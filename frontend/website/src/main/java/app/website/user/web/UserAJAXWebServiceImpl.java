package app.website.user.web;

import app.user.api.UserWebService;
import app.user.api.user.LoginUserRequest;
import app.user.api.user.LoginUserResponse;
import app.user.api.user.RegisterUserRequest;
import app.user.api.user.RegisterUserResponse;
import app.website.user.api.user.LoginAJAXRequest;
import app.website.user.api.user.LoginAJAXResponse;
import app.website.user.api.user.RegisterUserAJAXRequest;
import app.website.user.api.user.RegisterUserAJAXResponse;
import app.website.user.api.UserAJAXWebService;
import core.framework.inject.Inject;

public class UserAJAXWebServiceImpl implements UserAJAXWebService {
    @Inject
    UserWebService userWebService;

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
        
        return ajaxResponse;
    }
}
