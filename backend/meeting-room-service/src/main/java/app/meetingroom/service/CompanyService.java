package app.meetingroom.service;

import app.meetingroom.api.company.CompanyView;
import app.meetingroom.domain.Company;
import app.meetingroom.domain.CompanyStatus;
import core.framework.db.Query;
import core.framework.db.Repository;
import core.framework.inject.Inject;
import core.framework.web.exception.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

public class CompanyService {
    @Inject
    Repository<Company> companyRepository;

    public List<CompanyView> search() {
        Query<Company> query = companyRepository.select();
        return query.fetch().stream().map(this::view).collect(Collectors.toList());
    }

    public CompanyView get(Long id) {
        Company company = companyRepository.get(id).orElseThrow(() -> new NotFoundException("company not found, id=" + id));
        return view(company);
    }

    public CompanyView create(String name) {
        Company company = new Company();
        company.name = name;
        company.status = CompanyStatus.ACTIVE;
        company.id = companyRepository.insert(company).orElseThrow();
        return view(company);
    }

    public void deactivate(Long id) {
        Company company = companyRepository.get(id).orElseThrow(() -> new NotFoundException("company not found, id=" + id));
        company.status = CompanyStatus.INACTIVE;
        companyRepository.update(company);
    }

    private CompanyView view(Company company) {
        CompanyView view = new CompanyView();
        view.id = company.id;
        view.name = company.name;
        view.status = company.status != null ? company.status.name() : null;
        return view;
    }
}
