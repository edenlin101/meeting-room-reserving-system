package app.meetingroom.service;

import app.meetingroom.api.dto.RoomRequest;
import app.meetingroom.api.dto.RoomView;
import app.meetingroom.domain.Room;
import app.meetingroom.domain.RoomStatus;
import core.framework.db.Query;
import core.framework.db.Repository;
import core.framework.inject.Inject;
import core.framework.web.exception.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

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

    public RoomView create(RoomRequest request) {
        Room room = new Room();
        room.companyId = request.companyId;
        room.name = request.name;
        room.capacity = request.capacity;
        room.status = RoomStatus.ACTIVE;
        room.id = roomRepository.insert(room).orElseThrow();
        return view(room);
    }

    public void deactivate(Long id) {
        Room room = roomRepository.get(id).orElseThrow(() -> new NotFoundException("room not found, id=" + id));
        room.status = RoomStatus.INACTIVE;
        roomRepository.update(room);
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
