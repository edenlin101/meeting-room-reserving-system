package app.meetingroom.api;

import app.meetingroom.api.room.RoomListResponse;
import app.meetingroom.api.room.RoomView;
import core.framework.api.web.service.GET;
import core.framework.api.web.service.Path;
import core.framework.api.web.service.PathParam;

public interface MeetingRoomWebService {
    @GET
    @Path("/company/:companyId/room")
    RoomListResponse listRoom(@PathParam("companyId") Long companyId);
    @GET
    @Path("/room/:id")
    RoomView get(@PathParam("id") Long id);
}