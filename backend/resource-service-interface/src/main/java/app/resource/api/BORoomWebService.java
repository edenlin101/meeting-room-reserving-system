package app.resource.api;
import app.resource.api.bo.room.BOCreateRoomRequest;
import app.resource.api.bo.room.BOCreateRoomResponse;
import app.resource.api.bo.room.BODeleteRoomResponse;
import app.resource.api.bo.room.BOListRoomRequest;
import app.resource.api.bo.room.BOListRoomResponse;
import core.framework.api.web.service.DELETE;
import core.framework.api.web.service.GET;
import core.framework.api.web.service.POST;
import core.framework.api.web.service.Path;
import core.framework.api.web.service.PathParam;

public interface BORoomWebService {
    @POST @Path("/bo/room") BOCreateRoomResponse create(BOCreateRoomRequest request);
    @DELETE @Path("/bo/room/:id") BODeleteRoomResponse delete(@PathParam("id") Long id);
    @GET @Path("/bo/room/list") BOListRoomResponse list(BOListRoomRequest request);
}