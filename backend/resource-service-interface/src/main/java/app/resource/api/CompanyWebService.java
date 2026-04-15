package app.resource.api;
import app.resource.api.company.ListCompanyRequest;
import app.resource.api.company.ListCompanyResponse;
import core.framework.api.web.service.GET;
import core.framework.api.web.service.Path;

public interface CompanyWebService {
    @GET @Path("/company") ListCompanyResponse list(ListCompanyRequest request);
}