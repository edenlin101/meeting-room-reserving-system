package com.wonder.meetingroom.api;

import com.wonder.meetingroom.api.dto.RoomView;
import core.framework.api.web.service.GET;
import core.framework.api.web.service.Path;
import core.framework.api.web.service.PathParam;
import java.util.List;

/**
 * Meeting Room Web Service.
 *
 * @author Opencode
 */
public interface MeetingRoomWebService {

    @GET
    @Path("/company/:companyId/rooms")
    List<RoomView> listRooms(@PathParam("companyId") Long companyId);

    @GET
    @Path("/rooms/:id")
    RoomView get(@PathParam("id") Long id);
}
