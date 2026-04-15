package app.resource.domain;
import core.framework.db.DBEnumValue;

public enum RoomStatus {
    @DBEnumValue("ACTIVE") ACTIVE,
    @DBEnumValue("INACTIVE") INACTIVE
}