package app.backoffice;

import core.framework.app.Application;

public class BackofficeApp extends Application {
    @Override
    protected void initialize() {
        load(module(BackofficeModule.class));
    }
}