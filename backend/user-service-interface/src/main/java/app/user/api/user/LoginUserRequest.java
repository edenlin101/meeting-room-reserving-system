package app.user.api.user;

import core.framework.api.json.Property;
import core.framework.api.validate.NotBlank;
import core.framework.api.validate.NotNull;

public class LoginUserRequest {
    @NotBlank
    @NotNull
    @Property(name = "username")
    public String username;

    @NotBlank
    @NotNull
    @Property(name = "password")
    public String password;
}