package app.backoffice.admin.web;
import app.user.api.BOUserWebService;
import app.user.api.bo.user.BOUpdateUserStatusRequest;
import app.backoffice.admin.api.AdminAJAXWebService;
import app.backoffice.admin.api.admin.AdminLoginAJAXRequest;
import app.backoffice.admin.api.admin.AdminLoginAJAXResponse;
import app.backoffice.admin.api.user.UpdateUserStatusAJAXRequest;
import app.backoffice.admin.api.user.UpdateUserStatusAJAXResponse;
import core.framework.inject.Inject;
import core.framework.web.Request;
import core.framework.web.exception.UnauthorizedException;

public class AdminAJAXWebServiceImpl implements AdminAJAXWebService {
    @Inject
    BOUserWebService boUserWebService;

    @Inject
    Request request;

    @Override
    public AdminLoginAJAXResponse login(AdminLoginAJAXRequest loginRequest) {
        // Implement admin login logic
        if (!"admin".equals(loginRequest.username) || !"admin".equals(loginRequest.password)) {
            throw new UnauthorizedException("invalid admin credentials");
        }
        
        request.session().set("adminId", "admin");

        AdminLoginAJAXResponse response = new AdminLoginAJAXResponse();
        response.token = "dummy-admin-token";
        return response;
    }

    @Override
    public UpdateUserStatusAJAXResponse updateStatus(UpdateUserStatusAJAXRequest statusRequest) {
        if (!request.session().get("adminId").isPresent()) {
            throw new UnauthorizedException("admin not logged in");
        }
        
        BOUpdateUserStatusRequest boRequest = new BOUpdateUserStatusRequest();
        boRequest.userId = statusRequest.userId;
        boRequest.status = statusRequest.status;
        boUserWebService.updateStatus(boRequest);
        return new UpdateUserStatusAJAXResponse();
    }
}