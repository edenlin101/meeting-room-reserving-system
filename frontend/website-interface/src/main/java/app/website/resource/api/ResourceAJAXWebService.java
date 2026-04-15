package app.website.resource.api;
import app.website.resource.api.company.ListCompanyAJAXRequest;
import app.website.resource.api.company.ListCompanyAJAXResponse;
import app.website.resource.api.room.ListRoomAJAXRequest;
import app.website.resource.api.room.ListRoomAJAXResponse;
import core.framework.api.web.service.GET;
import core.framework.api.web.service.Path;
public interface ResourceAJAXWebService {
    @GET
    @Path("/ajax/company/list")
    ListCompanyAJAXResponse listCompanies(ListCompanyAJAXRequest request);

    @GET
    @Path("/ajax/room/list")
    ListRoomAJAXResponse listRooms(ListRoomAJAXRequest request);
}