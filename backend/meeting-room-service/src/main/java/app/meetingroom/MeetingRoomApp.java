package app.meetingroom;

import core.framework.module.App;
import core.framework.module.SystemModule;

public class MeetingRoomApp extends App {
    @Override
    protected void initialize() {
        load(new SystemModule("sys.properties"));
        load(new MeetingRoomModule());
    }
}
