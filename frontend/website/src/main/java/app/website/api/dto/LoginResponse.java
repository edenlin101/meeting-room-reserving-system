package app.website.api.dto;

import core.framework.api.web.service.Property;

public class LoginResponse {
    @Property(name = "token")
    public String token;

    @Property(name = "userId")
    public Long userId;

    @Property(name = "username")
    public String username;

    @Property(name = "companyId")
    public Long companyId;
}