package app.resource.web;
import app.resource.api.BORoomWebService;
import app.resource.api.bo.room.BOCreateRoomRequest;
import app.resource.api.bo.room.BOCreateRoomResponse;
import app.resource.api.bo.room.BODeleteRoomResponse;
import app.resource.api.bo.room.BOListRoomRequest;
import app.resource.api.bo.room.BOListRoomResponse;
import app.resource.api.room.RoomView;
import app.resource.domain.Room;
import app.resource.service.BORoomService;
import core.framework.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class BORoomWebServiceImpl implements BORoomWebService {
    @Inject
    BORoomService boRoomService;

    @Override
    public BOCreateRoomResponse create(BOCreateRoomRequest request) {
        Room room = boRoomService.create(request.companyId, request.name, request.capacity);
        BOCreateRoomResponse response = new BOCreateRoomResponse();
        response.id = room.id;
        return response;
    }

    @Override
    public BODeleteRoomResponse delete(Long id) {
        boRoomService.delete(id);
        return new BODeleteRoomResponse();
    }

    @Override
    public BOListRoomResponse list(BOListRoomRequest request) {
        List<Room> rooms = boRoomService.list(request.companyId);
        BOListRoomResponse response = new BOListRoomResponse();
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