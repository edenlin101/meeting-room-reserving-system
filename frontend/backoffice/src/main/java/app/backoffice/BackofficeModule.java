package app.backoffice;

import app.backoffice.api.BackofficeWebService;
import app.backoffice.web.BackofficeWebServiceImpl;
import core.framework.module.Module;

public class BackofficeModule extends Module {
    @Override
    protected void initialize() {
        bind(BackofficeWebService.class);
        api().service(BackofficeWebService.class, bind(BackofficeWebServiceImpl.class));
    }
}