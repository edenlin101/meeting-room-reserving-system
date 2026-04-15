package app.meetingroom.api;

import app.meetingroom.api.reservation.ReservationListResponse;
import app.meetingroom.api.reservation.ReservationRequest;
import app.meetingroom.api.reservation.ReservationView;
import app.meetingroom.api.reservation.SearchReservationRequest;
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