package app.user.api.user;

import core.framework.api.json.Property;

public class RegisterUserResponse {
    @Property(name = "id")
    public Long id;

    @Property(name = "username")
    public String username;

    @Property(name = "status")
    public String status;
}