package com.wonder.meetingroom.api;

import com.wonder.meetingroom.api.dto.ReservationView;
import com.wonder.meetingroom.api.dto.ReservationRequest;
import core.framework.api.web.service.GET;
import core.framework.api.web.service.POST;
import core.framework.api.web.service.DELETE;
import core.framework.api.web.service.Path;
import core.framework.api.web.service.PathParam;
import core.framework.api.web.service.QueryParam;
import java.util.List;

/**
 * Reservation Web Service.
 *
 * @author Opencode
 */
public interface ReservationWebService {

    @GET
    @Path("/rooms/:roomId/reservations")
    List<ReservationView> search(@PathParam("roomId") Long roomId, @QueryParam("date") String date);

    @POST
    @Path("/rooms/:roomId/reservations")
    ReservationView create(@PathParam("roomId") Long roomId, ReservationRequest request);

    @DELETE
    @Path("/reservations/:id")
    void cancel(@PathParam("id") Long id);
}
