package app.user.api;

import core.framework.api.web.service.PUT;
import core.framework.api.web.service.Path;
import app.user.api.user.BOUpdateUserStatusRequest;
import app.user.api.user.BOUpdateUserStatusResponse;

public interface BOUserWebService {
    @PUT
    @Path("/bo/user/status")
    BOUpdateUserStatusResponse updateStatus(BOUpdateUserStatusRequest request);
}