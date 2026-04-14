package app.user.api.user;

import core.framework.api.json.Property;

public class LoginUserResponse {
    @Property(name = "token")
    public String token;

    @Property(name = "id")
    public Long id;

    @Property(name = "username")
    public String username;

    @Property(name = "company_id")
    public Long companyId;
}