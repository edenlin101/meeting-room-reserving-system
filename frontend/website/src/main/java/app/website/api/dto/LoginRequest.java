package app.website.api.dto;

import core.framework.api.web.service.Property;

public class LoginRequest {
    @Property(name = "username")
    public String username;

    @Property(name = "password")
    public String password;
}