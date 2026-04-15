package app.meetingroom.api;

import app.meetingroom.api.dto.CompanyListResponse;
import app.meetingroom.api.dto.CompanyRequest;
import app.meetingroom.api.dto.CompanyView;
import app.meetingroom.api.dto.ReservationListResponse;
import app.meetingroom.api.dto.RoomListResponse;
import app.meetingroom.api.dto.RoomRequest;
import app.meetingroom.api.dto.RoomView;
import app.meetingroom.api.dto.SearchReservationsRequest;
import app.meetingroom.api.dto.SearchRoomsRequest;
import app.meetingroom.api.dto.SearchUsersRequest;
import app.meetingroom.api.dto.UserListResponse;
import core.framework.api.web.service.DELETE;
import core.framework.api.web.service.GET;
import core.framework.api.web.service.POST;
import core.framework.api.web.service.PUT;
import core.framework.api.web.service.Path;
import core.framework.api.web.service.PathParam;

public interface AdminWebService {
    @GET
    @Path("/admin/company")
    CompanyListResponse listCompany();

    @POST
    @Path("/admin/company")
    CompanyView createCompany(CompanyRequest request);

    @DELETE
    @Path("/admin/company/:id")
    void removeCompany(@PathParam("id") Long id);

    @GET
    @Path("/admin/room")
    RoomListResponse listRoom(SearchRoomsRequest request);

    @POST
    @Path("/admin/room")
    RoomView createRoom(RoomRequest request);

    @DELETE
    @Path("/admin/room/:id")
    void removeRoom(@PathParam("id") Long id);

    @GET
    @Path("/admin/reservation")
    ReservationListResponse searchReservation(SearchReservationsRequest request);

    @GET
    @Path("/admin/user")
    UserListResponse listUser(SearchUsersRequest request);

    @PUT
    @Path("/admin/user/:id/activate")
    void activateUser(@PathParam("id") Long id);

    @PUT
    @Path("/admin/user/:id/deactivate")
    void deactivateUser(@PathParam("id") Long id);
}