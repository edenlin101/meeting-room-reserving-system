package app.website;

import app.website.api.WebsiteWebService;
import app.website.web.WebsiteWebServiceImpl;
import core.framework.module.Module;

public class WebsiteModule extends Module {
    @Override
    protected void initialize() {
        bind(WebsiteWebService.class);
        api().service(WebsiteWebService.class, bind(WebsiteWebServiceImpl.class));
    }
}