package app.backoffice.api;

import app.backoffice.api.dto.*;
import core.framework.api.web.service.DELETE;
import core.framework.api.web.service.GET;
import core.framework.api.web.service.POST;
import core.framework.api.web.service.PUT;
import core.framework.api.web.service.Path;
import core.framework.api.web.service.PathParam;

public interface BackofficeWebService {

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