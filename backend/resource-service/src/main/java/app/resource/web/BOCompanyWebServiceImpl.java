package app.resource.web;
import app.resource.api.BOCompanyWebService;
import app.resource.api.bo.company.BOCreateCompanyRequest;
import app.resource.api.bo.company.BOCreateCompanyResponse;
import app.resource.api.bo.company.BODeleteCompanyResponse;
import app.resource.api.bo.company.BOListCompanyRequest;
import app.resource.api.bo.company.BOListCompanyResponse;
import app.resource.api.company.CompanyView;
import app.resource.domain.Company;
import app.resource.service.BOCompanyService;
import core.framework.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;
public class BOCompanyWebServiceImpl implements BOCompanyWebService {
    @Inject
    BOCompanyService boCompanyService;

    @Override
    public BOCreateCompanyResponse create(BOCreateCompanyRequest request) {
        Company company = boCompanyService.create(request.name);
        BOCreateCompanyResponse response = new BOCreateCompanyResponse();
        response.id = company.id;
        return response;
    }

    @Override
    public BODeleteCompanyResponse delete(Long id) {
        boCompanyService.delete(id);
        return new BODeleteCompanyResponse();
    }

    @Override
    public BOListCompanyResponse list(BOListCompanyRequest request) {
        List<Company> companies = boCompanyService.list();
        BOListCompanyResponse response = new BOListCompanyResponse();
        response.companies = companies.stream().map(this::view).collect(Collectors.toList());
        return response;
    }

    private CompanyView view(Company company) {
        CompanyView view = new CompanyView();
        view.id = company.id;
        view.name = company.name;
        view.status = company.status.name();
        return view;
    }
}