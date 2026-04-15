package app.resource.api;
import app.resource.api.room.ListRoomRequest;
import app.resource.api.room.ListRoomResponse;
import core.framework.api.web.service.GET;
import core.framework.api.web.service.Path;

public interface RoomWebService {
    @GET @Path("/room") ListRoomResponse list(ListRoomRequest request);
}