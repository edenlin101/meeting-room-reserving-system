package com.wonder.meetingroom.service;

import com.wonder.meetingroom.api.dto.RoomView;
import com.wonder.meetingroom.domain.Room;
import core.framework.db.Query;
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

    public List<RoomView> findAll() {
        Query<Room> query = roomRepository.select();
        List<Room> rooms = query.fetch();
        return rooms.stream().map(this::view).collect(Collectors.toList());
    }

    public List<RoomView> findByCompany(Long companyId) {
        Query<Room> query = roomRepository.select();
        query.where("company_id = ?", companyId);
        List<Room> rooms = query.fetch();
        return rooms.stream().map(this::view).collect(Collectors.toList());
    }

    public RoomView get(Long id) {
        Room room = roomRepository.get(id).orElseThrow(() -> new NotFoundException("room not found, id=" + id));
        return view(room);
    }

    public RoomView view(Room room) {
        RoomView view = new RoomView();
        view.id = room.id;
        view.companyId = room.companyId;
        view.name = room.name;
        view.capacity = room.capacity;
        view.status = room.status != null ? room.status.name() : null;
        return view;
    }
}
