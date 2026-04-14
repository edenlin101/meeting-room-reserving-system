package app.meetingroom.domain;

import core.framework.db.DBEnumValue;

public enum CompanyStatus {
    @DBEnumValue("ACTIVE")
    ACTIVE,
    @DBEnumValue("INACTIVE")
    INACTIVE
}
