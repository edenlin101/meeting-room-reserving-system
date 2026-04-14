package app.website.api;

import app.website.api.dto.*;
import core.framework.api.web.service.DELETE;
import core.framework.api.web.service.GET;
import core.framework.api.web.service.POST;
import core.framework.api.web.service.Path;
import core.framework.api.web.service.PathParam;

public interface WebsiteWebService {

    @POST
    @Path("/auth/register")
    UserView register(RegisterRequest request);

    @POST
    @Path("/auth/login")
    LoginResponse login(LoginRequest request);

    @GET
    @Path("/rooms")
    RoomListResponse searchRooms(SearchRoomsRequest request);

    @GET
    @Path("/rooms/:roomId/reservations")
    ReservationListResponse getRoomReservations(@PathParam("roomId") Long roomId, SearchReservationsRequest request);

    @POST
    @Path("/reservations/:roomId")
    ReservationView reserve(@PathParam("roomId") Long roomId, ReservationRequest request);

    @DELETE
    @Path("/reservations/:id")
    void cancel(@PathParam("id") Long id);
}