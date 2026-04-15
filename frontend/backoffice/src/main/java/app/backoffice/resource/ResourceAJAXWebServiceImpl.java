package app.backoffice.resource;
import app.resource.api.BOCompanyWebService;
import app.resource.api.BORoomWebService;
import app.resource.api.company.BOCreateCompanyRequest;
import app.resource.api.company.BOCreateCompanyResponse;
import app.resource.api.company.BOListCompanyRequest;
import app.resource.api.company.BOListCompanyResponse;
import app.resource.api.room.BOCreateRoomRequest;
import app.resource.api.room.BOCreateRoomResponse;
import app.resource.api.room.BOListRoomRequest;
import app.resource.api.room.BOListRoomResponse;
import app.backoffice.api.ResourceAJAXWebService;
import app.backoffice.api.company.CompanyAJAXView;
import app.backoffice.api.company.CreateCompanyAJAXRequest;
import app.backoffice.api.company.CreateCompanyAJAXResponse;
import app.backoffice.api.company.DeleteCompanyAJAXResponse;
import app.backoffice.api.company.ListCompanyAJAXRequest;
import app.backoffice.api.company.ListCompanyAJAXResponse;
import app.backoffice.api.room.CreateRoomAJAXRequest;
import app.backoffice.api.room.CreateRoomAJAXResponse;
import app.backoffice.api.room.DeleteRoomAJAXResponse;
import app.backoffice.api.room.ListRoomAJAXRequest;
import app.backoffice.api.room.ListRoomAJAXResponse;
import app.backoffice.api.room.RoomAJAXView;
import core.framework.inject.Inject;
import java.util.stream.Collectors;

public class ResourceAJAXWebServiceImpl implements ResourceAJAXWebService {
    @Inject
    BOCompanyWebService boCompanyWebService;
    @Inject
    BORoomWebService boRoomWebService;

    @Override
    public CreateCompanyAJAXResponse createCompany(CreateCompanyAJAXRequest request) {
        BOCreateCompanyRequest boRequest = new BOCreateCompanyRequest();
        boRequest.name = request.name;
        BOCreateCompanyResponse boResponse = boCompanyWebService.create(boRequest);
        CreateCompanyAJAXResponse ajaxResponse = new CreateCompanyAJAXResponse();
        ajaxResponse.id = boResponse.id;
        return ajaxResponse;
    }

    @Override
    public DeleteCompanyAJAXResponse deleteCompany(Long id) {
        boCompanyWebService.delete(id);
        return new DeleteCompanyAJAXResponse();
    }

    @Override
    public ListCompanyAJAXResponse listCompany(ListCompanyAJAXRequest request) {
        BOListCompanyResponse boResponse = boCompanyWebService.list(new BOListCompanyRequest());
        ListCompanyAJAXResponse ajaxResponse = new ListCompanyAJAXResponse();
        ajaxResponse.companies = boResponse.companies.stream().map(c -> {
            CompanyAJAXView view = new CompanyAJAXView();
            view.id = c.id;
            view.name = c.name;
            return view;
        }).collect(Collectors.toList());
        return ajaxResponse;
    }

    @Override
    public CreateRoomAJAXResponse createRoom(CreateRoomAJAXRequest request) {
        BOCreateRoomRequest boRequest = new BOCreateRoomRequest();
        boRequest.companyId = request.companyId;
        boRequest.name = request.name;
        boRequest.capacity = request.capacity;
        BOCreateRoomResponse boResponse = boRoomWebService.create(boRequest);
        CreateRoomAJAXResponse ajaxResponse = new CreateRoomAJAXResponse();
        ajaxResponse.id = boResponse.id;
        return ajaxResponse;
    }

    @Override
    public DeleteRoomAJAXResponse deleteRoom(Long id) {
        boRoomWebService.delete(id);
        return new DeleteRoomAJAXResponse();
    }

    @Override
    public ListRoomAJAXResponse listRoom(ListRoomAJAXRequest request) {
        BOListRoomRequest boRequest = new BOListRoomRequest();
        boRequest.companyId = request.companyId;
        BOListRoomResponse boResponse = boRoomWebService.list(boRequest);
        ListRoomAJAXResponse ajaxResponse = new ListRoomAJAXResponse();
        ajaxResponse.rooms = boResponse.rooms.stream().map(r -> {
            RoomAJAXView view = new RoomAJAXView();
            view.id = r.id;
            view.name = r.name;
            view.capacity = r.capacity;
            return view;
        }).collect(Collectors.toList());
        return ajaxResponse;
    }
}