package com.wonder.meetingroom;

import core.framework.module.App;
import core.framework.module.SystemModule;

/**
 * Meeting Room Service App.
 *
 * @author Opencode
 */
public class MeetingRoomApp extends App {
    @Override
    protected void initialize() {
        load(new SystemModule("sys.properties"));
        load(new MeetingRoomModule());
    }
}
