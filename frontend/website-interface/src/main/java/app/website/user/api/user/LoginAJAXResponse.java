package app.website.user.api.user;

import core.framework.api.json.Property;

public class LoginAJAXResponse {
    @Property(name = "token")
    public String token;

    @Property(name = "user_id")
    public Long userId;
}
