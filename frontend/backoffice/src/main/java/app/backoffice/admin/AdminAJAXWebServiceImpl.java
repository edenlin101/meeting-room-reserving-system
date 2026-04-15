package app.backoffice.admin;
import app.user.api.BOUserWebService;
import app.user.api.user.BOUpdateUserStatusRequest;
import app.backoffice.api.AdminAJAXWebService;
import app.backoffice.api.admin.AdminLoginAJAXRequest;
import app.backoffice.api.admin.AdminLoginAJAXResponse;
import app.backoffice.api.user.UpdateUserStatusAJAXRequest;
import app.backoffice.api.user.UpdateUserStatusAJAXResponse;
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