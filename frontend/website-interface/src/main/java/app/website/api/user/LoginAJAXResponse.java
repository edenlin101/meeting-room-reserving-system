package app.website.api.user;
import core.framework.api.validate.NotNull;

import core.framework.api.json.Property;

public class LoginAJAXResponse {
    @NotNull
    @Property(name = "token")
    public String token;

    @NotNull
    @Property(name = "user_id")
    public Long userId;
}
