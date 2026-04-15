package app.meetingroom.web;

import app.meetingroom.api.AdminWebService;
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
import app.meetingroom.service.CompanyService;
import app.meetingroom.service.MeetingRoomService;
import app.meetingroom.service.ReservationService;
import app.meetingroom.service.UserService;
import core.framework.inject.Inject;

public class AdminWebServiceImpl implements AdminWebService {
    @Inject
    CompanyService companyService;
    @Inject
    MeetingRoomService meetingRoomService;
    @Inject
    ReservationService reservationService;
    @Inject
    UserService userService;

    @Override
    public CompanyListResponse listCompany() {
        CompanyListResponse response = new CompanyListResponse();
        response.items = companyService.search();
        return response;
    }

    @Override
    public CompanyView createCompany(CompanyRequest request) {
        return companyService.create(request.name);
    }

    @Override
    public void removeCompany(Long id) {
        companyService.deactivate(id);
    }

    @Override
    public RoomListResponse listRoom(SearchRoomsRequest request) {
        RoomListResponse response = new RoomListResponse();
        response.items = meetingRoomService.findByCompany(request.companyId);
        return response;
    }

    @Override
    public RoomView createRoom(RoomRequest request) {
        return meetingRoomService.create(request);
    }

    @Override
    public void removeRoom(Long id) {
        meetingRoomService.deactivate(id);
    }

    @Override
    public ReservationListResponse searchReservation(SearchReservationsRequest request) {
        ReservationListResponse response = new ReservationListResponse();
        response.items = reservationService.searchAll();
        return response;
    }

    @Override
    public UserListResponse listUser(SearchUsersRequest request) {
        UserListResponse response = new UserListResponse();
        response.items = userService.search(request.companyId);
        return response;
    }

    @Override
    public void activateUser(Long id) {
    }

    @Override
    public void deactivateUser(Long id) {
        userService.deactivate(id);
    }
}