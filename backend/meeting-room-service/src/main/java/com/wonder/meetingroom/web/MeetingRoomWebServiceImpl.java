package com.wonder.meetingroom.web;

import com.wonder.meetingroom.api.MeetingRoomWebService;
import com.wonder.meetingroom.api.dto.RoomView;
import com.wonder.meetingroom.service.MeetingRoomService;
import core.framework.inject.Inject;

import java.util.List;

/**
 * @author Opencode
 */
public class MeetingRoomWebServiceImpl implements MeetingRoomWebService {
    @Inject
    MeetingRoomService meetingRoomService;

    @Override
    public List<RoomView> listRooms(Long companyId) {
        return meetingRoomService.findByCompany(companyId);
    }

    @Override
    public RoomView get(Long id) {
        return meetingRoomService.get(id);
    }
}
