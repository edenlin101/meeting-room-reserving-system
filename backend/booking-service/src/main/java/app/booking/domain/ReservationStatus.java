package app.booking.domain;
import core.framework.db.DBEnumValue;

public enum ReservationStatus {
    @DBEnumValue("ACTIVE") ACTIVE,
    @DBEnumValue("CANCELLED") CANCELLED
}