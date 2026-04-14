package app.website.web;

import app.website.api.WebsiteWebService;
import app.website.api.dto.*;
import core.framework.inject.Inject;
import core.framework.web.site.RemoteService;

public class WebsiteWebServiceImpl implements WebsiteWebService {
    @Inject
    RemoteService remoteService;

    @Override
    public UserView register(RegisterRequest request) {
        return remoteService.call("http://user-service:8080/auth/register", request, UserView.class);
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        return remoteService.call("http://user-service:8080/auth/login", request, LoginResponse.class);
    }

    @Override
    public RoomListResponse searchRooms(SearchRoomsRequest request) {
        String url = "http://resource-service:8080/rooms";
        if (request.companyId != null) {
            url += "?companyId=" + request.companyId;
        }
        return remoteService.call(url, null, RoomListResponse.class);
    }

    @Override
    public ReservationListResponse getRoomReservations(Long roomId, SearchReservationsRequest request) {
        String url = "http://booking-service:8080/reservations/" + roomId;
        if (request.date != null) {
            url += "?date=" + request.date;
        }
        return remoteService.call(url, null, ReservationListResponse.class);
    }
/
    @Override
    public ReservationView reserve(Long roomId, ReservationRequest request) {
        return remoteService.call("http://booking-service:8080/reservations/" + roomId, request, ReservationView.class);
    }

    @Override
    public void cancel(Long id) {
        remoteService.delete("http://booking-service:8080/reservations/" + id);
    }
}