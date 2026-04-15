package app.website.resource;
import app.resource.api.CompanyWebService;
import app.resource.api.RoomWebService;
import app.resource.api.company.ListCompanyRequest;
import app.resource.api.company.ListCompanyResponse;
import app.resource.api.room.ListRoomRequest;
import app.resource.api.room.ListRoomResponse;
import app.website.api.ResourceAJAXWebService;
import app.website.api.company.CompanyAJAXView;
import app.website.api.company.ListCompanyAJAXRequest;
import app.website.api.company.ListCompanyAJAXResponse;
import app.website.api.room.ListRoomAJAXRequest;
import app.website.api.room.ListRoomAJAXResponse;
import app.website.api.room.RoomAJAXView;
import core.framework.inject.Inject;
import java.util.stream.Collectors;
public class ResourceAJAXWebServiceImpl implements ResourceAJAXWebService {
    @Inject
    CompanyWebService companyWebService;
    @Inject
    RoomWebService roomWebService;
    
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