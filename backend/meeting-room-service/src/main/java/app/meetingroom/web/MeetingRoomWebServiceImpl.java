package app.meetingroom.web;

import app.meetingroom.api.MeetingRoomWebService;
import app.meetingroom.api.dto.RoomListResponse;
import app.meetingroom.api.dto.RoomView;
import app.meetingroom.service.MeetingRoomService;
import core.framework.inject.Inject;

public class MeetingRoomWebServiceImpl implements MeetingRoomWebService {
    @Inject
    MeetingRoomService meetingRoomService;

    @Override
    public RoomListResponse listRooms(Long companyId) {
        RoomListResponse response = new RoomListResponse();
        response.items = meetingRoomService.findByCompany(companyId);
        return response;
    }

    @Override
    public RoomView get(Long id) {
        return meetingRoomService.get(id);
    }
}