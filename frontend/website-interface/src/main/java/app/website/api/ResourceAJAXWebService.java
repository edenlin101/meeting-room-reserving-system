package app.website.api;
import app.website.api.company.ListCompanyAJAXRequest;
import app.website.api.company.ListCompanyAJAXResponse;
import app.website.api.room.ListRoomAJAXRequest;
import app.website.api.room.ListRoomAJAXResponse;
import core.framework.api.web.service.GET;
import core.framework.api.web.service.Path;

public interface ResourceAJAXWebService {
    @GET
    @Path("/ajax/company/list")
    ListCompanyAJAXResponse listCompany(ListCompanyAJAXRequest request);

    @GET
    @Path("/ajax/room/list")
    ListRoomAJAXResponse listRoom(ListRoomAJAXRequest request);
}