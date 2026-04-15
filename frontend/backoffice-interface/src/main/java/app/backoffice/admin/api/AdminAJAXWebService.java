package app.backoffice.admin.api;
import app.backoffice.admin.api.admin.AdminLoginAJAXRequest;
import app.backoffice.admin.api.admin.AdminLoginAJAXResponse;
import app.backoffice.admin.api.user.UpdateUserStatusAJAXRequest;
import app.backoffice.admin.api.user.UpdateUserStatusAJAXResponse;
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