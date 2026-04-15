package app.user.web;

import app.user.api.BOUserWebService;
import app.user.api.user.BOUpdateUserStatusRequest;
import app.user.api.user.BOUpdateUserStatusResponse;
import app.user.service.BOUserService;
import core.framework.inject.Inject;

public class BOUserWebServiceImpl implements BOUserWebService {
    @Inject
    BOUserService userService;

    @Override
    public BOUpdateUserStatusResponse updateStatus(BOUpdateUserStatusRequest request) {
        userService.updateStatus(request.userId, request.status);
        
        BOUpdateUserStatusResponse response = new BOUpdateUserStatusResponse();
        response.success = Boolean.TRUE;
        return response;
    }
}