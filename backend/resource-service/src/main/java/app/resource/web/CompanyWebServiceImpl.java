package app.resource.web;
import app.resource.api.CompanyWebService;
import app.resource.api.company.CompanyView;
import app.resource.api.company.ListCompanyRequest;
import app.resource.api.company.ListCompanyResponse;
import app.resource.domain.Company;
import app.resource.service.CompanyService;
import core.framework.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class CompanyWebServiceImpl implements CompanyWebService {
    @Inject
    CompanyService companyService;

    @Override
    public ListCompanyResponse list(ListCompanyRequest request) {
        List<Company> companies = companyService.list();
        ListCompanyResponse response = new ListCompanyResponse();
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