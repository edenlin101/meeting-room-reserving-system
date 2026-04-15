package app.resource.service;
import app.resource.domain.Room;
import app.resource.domain.RoomStatus;
import core.framework.db.Repository;
import core.framework.inject.Inject;
import java.util.List;
public class RoomService {
    @Inject Repository<Room> roomRepository;
    
    public List<Room> list(Long companyId) {
        if (companyId != null) {
            return roomRepository.select("company_id = ? AND status = ?", companyId, RoomStatus.ACTIVE);
        }
        return roomRepository.select("status = ?", RoomStatus.ACTIVE);
    }
}