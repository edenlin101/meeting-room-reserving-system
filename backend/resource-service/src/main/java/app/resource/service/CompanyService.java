package app.resource.service;
import app.resource.domain.Company;
import app.resource.domain.CompanyStatus;
import core.framework.db.Repository;
import core.framework.inject.Inject;
import java.util.List;

public class CompanyService {
    @Inject
    Repository<Company> companyRepository;
    
    public List<Company> list() {
        return companyRepository.select("status = ?", CompanyStatus.ACTIVE);
    }
}