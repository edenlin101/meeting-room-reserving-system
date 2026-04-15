package app.meetingroom.api.user;

import core.framework.api.json.Property;
import core.framework.api.validate.NotBlank;
import core.framework.api.validate.NotNull;

public class RegisterRequest {
    @NotBlank
    @NotNull
    @Property(name = "username")
    public String username;

    @NotBlank
    @NotNull
    @Property(name = "password")
    public String password;

    @NotNull
    @Property(name = "company_id")
    public Long companyId;
}
