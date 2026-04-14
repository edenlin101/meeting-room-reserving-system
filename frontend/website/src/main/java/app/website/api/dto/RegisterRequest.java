package app.website.api.dto;

import core.framework.api.web.service.Property;

public class RegisterRequest {
    @Property(name = "username")
    public String username;

    @Property(name = "password")
    public String password;

    @Property(name = "companyId")
    public Long companyId;
}