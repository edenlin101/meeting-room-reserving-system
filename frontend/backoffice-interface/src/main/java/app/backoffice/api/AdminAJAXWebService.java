package app.backoffice.api;
import app.backoffice.api.admin.AdminLoginAJAXRequest;
import app.backoffice.api.admin.AdminLoginAJAXResponse;
import app.backoffice.api.user.UpdateUserStatusAJAXRequest;
import app.backoffice.api.user.UpdateUserStatusAJAXResponse;
import core.framework.api.web.service.POST;
import core.framework.api.web.service.PUT;
import core.framework.api.web.service.Path;

public interface AdminAJAXWebService {
    @POST
    @Path("/ajax/admin/login")
    AdminLoginAJAXResponse login(AdminLoginAJAXRequest request);

    @PUT
    @Path("/ajax/user/status")
    UpdateUserStatusAJAXResponse updateStatus(UpdateUserStatusAJAXRequest request);
}