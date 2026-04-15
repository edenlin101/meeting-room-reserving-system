package app.user.api;

import core.framework.api.web.service.POST;
import core.framework.api.web.service.Path;
import app.user.api.user.RegisterUserRequest;
import app.user.api.user.RegisterUserResponse;
import app.user.api.user.LoginUserRequest;
import app.user.api.user.LoginUserResponse;

public interface UserWebService {
    @POST
    @Path("/user/register")
    RegisterUserResponse register(RegisterUserRequest request);
    @POST
    @Path("/user/login")
    LoginUserResponse login(LoginUserRequest request);
}
