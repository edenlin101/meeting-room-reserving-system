package app.resource.api;
import app.resource.api.bo.company.BOCreateCompanyRequest;
import app.resource.api.bo.company.BOCreateCompanyResponse;
import app.resource.api.bo.company.BODeleteCompanyResponse;
import app.resource.api.bo.company.BOListCompanyRequest;
import app.resource.api.bo.company.BOListCompanyResponse;
import core.framework.api.web.service.DELETE;
import core.framework.api.web.service.GET;
import core.framework.api.web.service.POST;
import core.framework.api.web.service.Path;
import core.framework.api.web.service.PathParam;
public interface BOCompanyWebService {
    @POST @Path("/bo/company") BOCreateCompanyResponse create(BOCreateCompanyRequest request);
    @DELETE @Path("/bo/company/:id") BODeleteCompanyResponse delete(@PathParam("id") Long id);
    @GET @Path("/bo/company/list") BOListCompanyResponse list(BOListCompanyRequest request);
}