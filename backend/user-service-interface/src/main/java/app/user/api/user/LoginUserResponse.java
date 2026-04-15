package app.user.api.user;
import core.framework.api.validate.NotNull;

import core.framework.api.json.Property;

public class LoginUserResponse {
    @NotNull
    @Property(name = "token")
    public String token;

    @NotNull
    @Property(name = "id")
    public Long id;

    @NotNull
    @Property(name = "username")
    public String username;

    @NotNull
    @Property(name = "company_id")
    public Long companyId;
}