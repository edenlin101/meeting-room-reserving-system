package app.website.api.user;
import core.framework.api.validate.NotNull;

import core.framework.api.json.Property;

public class RegisterUserAJAXResponse {
    @NotNull
    @Property(name = "user_id")
    public Long userId;
}
