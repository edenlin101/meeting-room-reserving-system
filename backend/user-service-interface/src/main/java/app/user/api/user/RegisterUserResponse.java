package app.user.api.user;
import core.framework.api.validate.NotNull;

import core.framework.api.json.Property;

public class RegisterUserResponse {
    @NotNull
    @Property(name = "id")
    public Long id;

    @NotNull
    @Property(name = "username")
    public String username;

    @NotNull
    @Property(name = "status")
    public String status;
}