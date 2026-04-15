package app.meetingroom.api.user;
import core.framework.api.validate.NotNull;

import core.framework.api.json.Property;

public class LoginResponse {
    @NotNull
    @Property(name = "user_id")
    public Long userId;

    @NotNull
    @Property(name = "username")
    public String username;

    @NotNull
    @Property(name = "company_id")
    public Long companyId;

    @NotNull
    @Property(name = "status")
    public String status;
}
