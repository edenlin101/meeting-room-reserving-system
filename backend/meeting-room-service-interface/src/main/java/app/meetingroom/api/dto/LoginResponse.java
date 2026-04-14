package app.meetingroom.api.dto;

import core.framework.api.json.Property;

public class LoginResponse {
    @Property(name = "user_id")
    public Long userId;

    @Property(name = "username")
    public String username;

    @Property(name = "company_id")
    public Long companyId;

    @Property(name = "status")
    public String status;
}
