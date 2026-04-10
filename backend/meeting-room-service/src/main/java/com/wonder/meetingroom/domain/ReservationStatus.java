package com.wonder.meetingroom.domain;

import core.framework.db.DBEnumValue;

/**
 * @author Opencode
 */
public enum ReservationStatus {
    @DBEnumValue("CONFIRMED")
    CONFIRMED,
    @DBEnumValue("CANCELLED")
    CANCELLED
}
