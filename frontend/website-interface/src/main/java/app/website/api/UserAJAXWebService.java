package app.website.api;

import app.website.api.user.LoginAJAXRequest;
import app.website.api.user.LoginAJAXResponse;
import app.website.api.user.RegisterUserAJAXRequest;
import app.website.api.user.RegisterUserAJAXResponse;
import core.framework.api.web.service.POST;
import core.framework.api.web.service.Path;

public interface UserAJAXWebService {
    @POST
    @Path("/ajax/user/register")
    RegisterUserAJAXResponse register(RegisterUserAJAXRequest request);
    @POST
    @Path("/ajax/user/login")
    LoginAJAXResponse login(LoginAJAXRequest request);
}
