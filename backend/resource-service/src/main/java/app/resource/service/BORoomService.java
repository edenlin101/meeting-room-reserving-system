package app.resource.service;
import app.resource.domain.Room;
import app.resource.domain.RoomStatus;
import core.framework.db.Repository;
import core.framework.inject.Inject;
import core.framework.web.exception.NotFoundException;
import java.time.ZonedDateTime;
import java.util.List;

public class BORoomService {
    @Inject
    Repository<Room> roomRepository;
    
    public Room create(Long companyId, String name, Integer capacity) {
        Room room = new Room();
        room.companyId = companyId;
        room.name = name;
        room.capacity = capacity;
        room.status = RoomStatus.ACTIVE;
        room.createdTime = ZonedDateTime.now();
        room.id = roomRepository.insert(room).orElseThrow();
        return room;
    }
    
    public void delete(Long id) {
        Room room = roomRepository.get(id).orElseThrow(() -> new NotFoundException("room not found, id=" + id));
        room.status = RoomStatus.INACTIVE;
        room.updatedTime = ZonedDateTime.now();
        roomRepository.update(room);
    }
    
    public List<Room> list(Long companyId) {
        if (companyId != null) {
            return roomRepository.select("company_id = ? AND status = ?", companyId, RoomStatus.ACTIVE);
        }
        return roomRepository.select("status = ?", RoomStatus.ACTIVE);
    }
}