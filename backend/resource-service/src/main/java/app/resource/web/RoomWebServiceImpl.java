package app.resource.web;
import app.resource.api.RoomWebService;
import app.resource.api.room.ListRoomRequest;
import app.resource.api.room.ListRoomResponse;
import app.resource.api.room.RoomView;
import app.resource.domain.Room;
import app.resource.service.RoomService;
import core.framework.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;
public class RoomWebServiceImpl implements RoomWebService {
    @Inject
    RoomService roomService;

    @Override
    public ListRoomResponse list(ListRoomRequest request) {
        List<Room> rooms = roomService.list(request.companyId);
        ListRoomResponse response = new ListRoomResponse();
        response.rooms = rooms.stream().map(this::view).collect(Collectors.toList());
        return response;
    }

    private RoomView view(Room room) {
        RoomView view = new RoomView();
        view.id = room.id;
        view.companyId = room.companyId;
        view.name = room.name;
        view.capacity = room.capacity;
        view.status = room.status.name();
        return view;
    }
}