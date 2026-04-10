package com.wonder.meetingroom.domain;

import core.framework.db.DBEnumValue;

/**
 * @author Opencode
 */
public enum RoomStatus {
    @DBEnumValue("ACTIVE")
    ACTIVE,
    @DBEnumValue("INACTIVE")
    INACTIVE
}
