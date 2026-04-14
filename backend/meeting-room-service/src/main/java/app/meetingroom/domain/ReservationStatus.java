package app.meetingroom.domain;

import core.framework.db.DBEnumValue;

public enum ReservationStatus {
    @DBEnumValue("CONFIRMED")
    CONFIRMED,
    @DBEnumValue("CANCELLED")
    CANCELLED
}
