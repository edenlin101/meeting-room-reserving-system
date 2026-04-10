package com.wonder.meetingroom.service;

import com.wonder.meetingroom.api.dto.RoomView;
import com.wonder.meetingroom.domain.Room;
import core.framework.db.Repository;
import core.framework.inject.Inject;
import core.framework.web.exception.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Meeting Room Service.
 *
 * @author Opencode
 */
public class MeetingRoomService {
    @Inject
    Repository<Room> roomRepository;

    public List<RoomView> findByCompany(Long companyId) {
        List<Room> rooms = roomRepository.select("company_id = ?", companyId);
        return rooms.stream().map(this::view).collect(Collectors.toList());
    }

    public RoomView get(Long id) {
        Room room = roomRepository.get(id).orElseThrow(() -> new NotFoundException("room not found, id=" + id));
        return view(room);
    }

    private RoomView view(Room room) {
        RoomView view = new RoomView();
        view.id = room.id;
        view.companyId = room.companyId;
        view.name = room.name;
        view.capacity = room.capacity;
        view.status = room.status != null ? room.status.name() : null;
        return view;
    }
}
