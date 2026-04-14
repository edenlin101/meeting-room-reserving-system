package app.backoffice.web;

import app.backoffice.api.BackofficeWebService;
import app.backoffice.api.dto.*;
import core.framework.inject.Inject;
import core.framework.web.site.RemoteService;

public class BackofficeWebServiceImpl implements BackofficeWebService {
    @Inject
    RemoteService remoteService;

    @Override
    public CompanyListResponse listCompanies() {
        return remoteService.call("http://resource-service:8080/admin/companies", null, CompanyListResponse.class);
    }

    @Override
    public CompanyView createCompany(CompanyRequest request) {
        return remoteService.call("http://resource-service:8080/admin/companies", request, CompanyView.class);
    }

    @Override
    public void removeCompany(Long id) {
        remoteService.delete("http://resource-service:8080/admin/companies/" + id);
    }

    @Override
    public RoomListResponse listRooms(SearchRoomsRequest request) {
        String url = "http://resource-service:8080/admin/rooms";
        if (request.companyId != null) {
            url += "?companyId=" + request.companyId;
        }
        return remoteService.call(url, null, RoomListResponse.class);
    }

    @Override
    public RoomView createRoom(RoomRequest request) {
        return remoteService.call("http://resource-service:8080/admin/rooms", request, RoomView.class);
    }

    @Override
    public void removeRoom(Long id) {
        remoteService.delete("http://resource-service:8080/admin/rooms/" + id);
    }

    @Override
    public ReservationListResponse searchReservations(SearchReservationsRequest request) {
        String url = "http://booking-service:8080/reservations";
        if (request.roomId != null) {
            url += "?roomId=" + request.roomId;
        }
        if (request.companyId != null) {
            url += (request.roomId != null ? "&" : "?") + "companyId=" + request.companyId;
        }
        if (request.date != null) {
            url += (request.roomId != null || request.companyId != null ? "&" : "?") + "date=" + request.date;
        }
        return remoteService.call(url, null, ReservationListResponse.class);
    }

    @Override
    public UserListResponse listUsers(SearchUsersRequest request) {
        String url = "http://user-service:8080/users";
        if (request.companyId != null) {
            url += "?companyId=" + request.companyId;
        }
        return remoteService.call(url, null, UserListResponse.class);
    }

    @Override
    public void activateUser(Long id) {
        remoteService.put("http://user-service:8080/admin/users/" + id + "/activate", null, Void.class);
    }

    @Override
    public void deactivateUser(Long id) {
        remoteService.put("http://user-service:8080/admin/users/" + id + "/deactivate", null, Void.class);
    }
}