package app.backoffice.api;
import app.backoffice.api.company.CreateCompanyAJAXRequest;
import app.backoffice.api.company.CreateCompanyAJAXResponse;
import app.backoffice.api.company.DeleteCompanyAJAXResponse;
import app.backoffice.api.company.ListCompanyAJAXRequest;
import app.backoffice.api.company.ListCompanyAJAXResponse;
import app.backoffice.api.room.CreateRoomAJAXRequest;
import app.backoffice.api.room.CreateRoomAJAXResponse;
import app.backoffice.api.room.DeleteRoomAJAXResponse;
import app.backoffice.api.room.ListRoomAJAXRequest;
import app.backoffice.api.room.ListRoomAJAXResponse;
import core.framework.api.web.service.DELETE;
import core.framework.api.web.service.GET;
import core.framework.api.web.service.POST;
import core.framework.api.web.service.Path;
import core.framework.api.web.service.PathParam;

public interface ResourceAJAXWebService {
    @POST
    @Path("/ajax/company/create")
    CreateCompanyAJAXResponse createCompany(CreateCompanyAJAXRequest request);
    @DELETE
    @Path("/ajax/company/:id")
    DeleteCompanyAJAXResponse deleteCompany(@PathParam("id") Long id);
    @GET
    @Path("/ajax/company/list")
    ListCompanyAJAXResponse listCompany(ListCompanyAJAXRequest request);
    @POST
    @Path("/ajax/room/create")
    CreateRoomAJAXResponse createRoom(CreateRoomAJAXRequest request);
    @DELETE
    @Path("/ajax/room/:id")
    DeleteRoomAJAXResponse deleteRoom(@PathParam("id") Long id);
    @GET
    @Path("/ajax/room/list")
    ListRoomAJAXResponse listRoom(ListRoomAJAXRequest request);
}