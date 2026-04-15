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
    @Path("/admin/companies")
    CompanyListResponse listCompanies();

    @POST
    @Path("/admin/companies")
    CompanyView createCompany(CompanyRequest request);

    @DELETE
    @Path("/admin/companies/:id")
    void removeCompany(@PathParam("id") Long id);

    @GET
    @Path("/admin/rooms")
    RoomListResponse listRooms(SearchRoomsRequest request);

    @POST
    @Path("/admin/rooms")
    RoomView createRoom(RoomRequest request);

    @DELETE
    @Path("/admin/rooms/:id")
    void removeRoom(@PathParam("id") Long id);

    @GET
    @Path("/admin/reservations")
    ReservationListResponse searchReservations(SearchReservationsRequest request);

    @GET
    @Path("/admin/users")
    UserListResponse listUsers(SearchUsersRequest request);

    @PUT
    @Path("/admin/users/:id/activate")
    void activateUser(@PathParam("id") Long id);

    @PUT
    @Path("/admin/users/:id/deactivate")
    void deactivateUser(@PathParam("id") Long id);
}