package app.meetingroom.api;

import app.meetingroom.api.dto.LoginRequest;
import app.meetingroom.api.dto.LoginResponse;
import app.meetingroom.api.dto.RegisterRequest;
import app.meetingroom.api.dto.UserView;
import core.framework.api.web.service.POST;
import core.framework.api.web.service.Path;

public interface AuthWebService {
    @POST
    @Path("/auth/register")
    UserView register(RegisterRequest request);

    @POST
    @Path("/auth/login")
    LoginResponse login(LoginRequest request);
}
