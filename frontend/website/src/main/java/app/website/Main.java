package app.website;

import core.framework.app.StartupHook;

public class Main implements StartupHook {
    public static void main(String[] args) {
        core.framework.app.Application.run(WebsiteApp.class, args);
    }

    @Override
    public void start() {
    }
}