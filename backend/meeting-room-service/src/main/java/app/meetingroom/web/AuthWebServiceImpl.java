package app.meetingroom.web;

import app.meetingroom.api.AuthWebService;
import app.meetingroom.api.dto.LoginRequest;
import app.meetingroom.api.dto.LoginResponse;
import app.meetingroom.api.dto.RegisterRequest;
import app.meetingroom.api.dto.UserView;
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
