package app.resource.service;
import app.resource.domain.Company;
import app.resource.domain.CompanyStatus;
import core.framework.db.Repository;
import core.framework.inject.Inject;
import core.framework.web.exception.NotFoundException;
import java.time.ZonedDateTime;
import java.util.List;
public class BOCompanyService {
    @Inject
    Repository<Company> companyRepository;
    
    public Company create(String name) {
        Company company = new Company();
        company.name = name;
        company.status = CompanyStatus.ACTIVE;
        company.createdTime = ZonedDateTime.now();
        company.id = companyRepository.insert(company).orElseThrow();
        return company;
    }
    
    public void delete(Long id) {
        Company company = companyRepository.get(id).orElseThrow(() -> new NotFoundException("company not found, id=" + id));
        company.status = CompanyStatus.INACTIVE;
        company.updatedTime = ZonedDateTime.now();
        companyRepository.update(company);
    }
    
    public List<Company> list() {
        return companyRepository.select("status = ?", CompanyStatus.ACTIVE);
    }
}