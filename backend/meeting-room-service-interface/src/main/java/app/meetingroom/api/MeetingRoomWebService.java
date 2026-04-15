package app.meetingroom.api;

import app.meetingroom.api.dto.RoomListResponse;
import app.meetingroom.api.dto.RoomView;
import core.framework.api.web.service.GET;
import core.framework.api.web.service.Path;
import core.framework.api.web.service.PathParam;

public interface MeetingRoomWebService {
    @GET
    @Path("/company/:companyId/rooms")
    RoomListResponse listRooms(@PathParam("companyId") Long companyId);

    @GET
    @Path("/rooms/:id")
    RoomView get(@PathParam("id") Long id);
}