package app.backoffice;

import core.framework.app.StartupHook;

public class Main implements StartupHook {
    public static void main(String[] args) {
        core.framework.app.Application.run(BackofficeApp.class, args);
    }

    @Override
    public void start() {
    }
}