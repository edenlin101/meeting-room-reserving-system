package app.meetingroom.api;

import app.meetingroom.api.dto.ReservationListResponse;
import app.meetingroom.api.dto.ReservationRequest;
import app.meetingroom.api.dto.ReservationView;
import app.meetingroom.api.dto.SearchReservationRequest;
import core.framework.api.web.service.GET;
import core.framework.api.web.service.POST;
import core.framework.api.web.service.DELETE;
import core.framework.api.web.service.Path;
import core.framework.api.web.service.PathParam;

public interface ReservationWebService {
    @GET
    @Path("/room/:id/reservation")
    ReservationListResponse search(@PathParam("id") Long roomId, SearchReservationRequest request);
    @POST
    @Path("/room/:id/reservation")
    ReservationView create(@PathParam("id") Long roomId, ReservationRequest request);
    @DELETE
    @Path("/reservation/:id")
    void cancel(@PathParam("id") Long id);
}