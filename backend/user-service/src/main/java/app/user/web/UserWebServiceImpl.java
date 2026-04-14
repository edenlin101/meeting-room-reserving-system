package app.user.web;

import app.user.api.UserWebService;
import app.user.api.user.LoginUserRequest;
import app.user.api.user.LoginUserResponse;
import app.user.api.user.RegisterUserRequest;
import app.user.api.user.RegisterUserResponse;
import app.user.domain.User;
import app.user.service.UserService;
import core.framework.inject.Inject;
import java.util.UUID;

public class UserWebServiceImpl implements UserWebService {
    @Inject
    UserService userService;

    @Override
    public RegisterUserResponse register(RegisterUserRequest request) {
        User user = userService.register(request.username, request.password, request.companyId);
        
        RegisterUserResponse response = new RegisterUserResponse();
        response.id = user.id;
        response.username = user.username;
        response.status = user.status.name();
        
        return response;
    }

    @Override
    public LoginUserResponse login(LoginUserRequest request) {
        User user = userService.login(request.username, request.password);
        
        LoginUserResponse response = new LoginUserResponse();
        response.id = user.id;
        response.username = user.username;
        response.companyId = user.companyId;
        // In real app, issue a proper JWT. For demo, we return a mock token
        response.token = UUID.randomUUID().toString(); 
        
        return response;
    }
}