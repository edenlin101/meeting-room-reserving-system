package app.backoffice.admin.web;
import app.user.api.BOUserWebService;
import app.user.api.bo.user.BOUpdateUserStatusRequest;
import app.backoffice.admin.api.AdminAJAXWebService;
import app.backoffice.admin.api.admin.AdminLoginAJAXRequest;
import app.backoffice.admin.api.admin.AdminLoginAJAXResponse;
import app.backoffice.admin.api.user.UpdateUserStatusAJAXRequest;
import app.backoffice.admin.api.user.UpdateUserStatusAJAXResponse;
import core.framework.inject.Inject;
public class AdminAJAXWebServiceImpl implements AdminAJAXWebService {
    @Inject
    BOUserWebService boUserWebService;

    @Override
    public AdminLoginAJAXResponse login(AdminLoginAJAXRequest request) {
        // Implement admin login logic
        AdminLoginAJAXResponse response = new AdminLoginAJAXResponse();
        response.token = "dummy-admin-token";
        return response;
    }

    @Override
    public UpdateUserStatusAJAXResponse updateStatus(UpdateUserStatusAJAXRequest request) {
        BOUpdateUserStatusRequest boRequest = new BOUpdateUserStatusRequest();
        boRequest.userId = request.userId;
        boRequest.status = request.status;
        boUserWebService.updateStatus(boRequest);
        return new UpdateUserStatusAJAXResponse();
    }
}