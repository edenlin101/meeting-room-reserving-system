package app.website;

import core.framework.app.Application;

public class WebsiteApp extends Application {
    @Override
    protected void initialize() {
        load(module(WebsiteModule.class));
    }
}