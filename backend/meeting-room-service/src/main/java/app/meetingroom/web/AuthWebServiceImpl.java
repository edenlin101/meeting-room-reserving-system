package app.meetingroom.web;

import app.meetingroom.api.AuthWebService;
import app.meetingroom.api.user.LoginRequest;
import app.meetingroom.api.user.LoginResponse;
import app.meetingroom.api.user.RegisterRequest;
import app.meetingroom.api.user.UserView;
import app.meetingroom.service.UserService;
import core.framework.inject.Inject;

public class AuthWebServiceImpl implements AuthWebService {
    @Inject
    UserService userService;

    @Override
    public UserView register(RegisterRequest request) {
        return userService.create(request.username, request.password, request.companyId);
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        LoginResponse response = new LoginResponse();
        response.userId = 1L;
        response.username = request.username;
        response.status = "ACTIVE";
        return response;
    }
}
