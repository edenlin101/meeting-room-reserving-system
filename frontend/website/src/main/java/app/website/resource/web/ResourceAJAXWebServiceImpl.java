package app.website.resource.web;
import app.resource.api.CompanyWebService;
import app.resource.api.RoomWebService;
import app.resource.api.company.ListCompanyRequest;
import app.resource.api.company.ListCompanyResponse;
import app.resource.api.room.ListRoomRequest;
import app.resource.api.room.ListRoomResponse;
import app.website.resource.api.ResourceAJAXWebService;
import app.website.resource.api.company.CompanyAJAXView;
import app.website.resource.api.company.ListCompanyAJAXRequest;
import app.website.resource.api.company.ListCompanyAJAXResponse;
import app.website.resource.api.room.ListRoomAJAXRequest;
import app.website.resource.api.room.ListRoomAJAXResponse;
import app.website.resource.api.room.RoomAJAXView;
import core.framework.inject.Inject;
import java.util.stream.Collectors;
public class ResourceAJAXWebServiceImpl implements ResourceAJAXWebService {
    @Inject CompanyWebService companyWebService;
    @Inject RoomWebService roomWebService;
    
    @Override
    public ListCompanyAJAXResponse listCompanies(ListCompanyAJAXRequest request) {
        ListCompanyResponse response = companyWebService.list(new ListCompanyRequest());
        ListCompanyAJAXResponse ajaxResponse = new ListCompanyAJAXResponse();
        ajaxResponse.companies = response.companies.stream().map(company -> {
            CompanyAJAXView view = new CompanyAJAXView();
            view.id = company.id;
            view.name = company.name;
            return view;
        }).collect(Collectors.toList());
        return ajaxResponse;
    }
    
    @Override
    public ListRoomAJAXResponse listRooms(ListRoomAJAXRequest request) {
        ListRoomRequest roomRequest = new ListRoomRequest();
        roomRequest.companyId = request.companyId;
        ListRoomResponse response = roomWebService.list(roomRequest);
        
        ListRoomAJAXResponse ajaxResponse = new ListRoomAJAXResponse();
        ajaxResponse.rooms = response.rooms.stream().map(room -> {
            RoomAJAXView view = new RoomAJAXView();
            view.id = room.id;
            view.name = room.name;
            view.capacity = room.capacity;
            return view;
        }).collect(Collectors.toList());
        return ajaxResponse;
    }
}