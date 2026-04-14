package app.user.api.bo.user;

import core.framework.api.json.Property;
import core.framework.api.validate.NotNull;

public class BOUpdateUserStatusRequest {
    @NotNull
    @Property(name = "user_id")
    public Long userId;

    @NotNull
    @Property(name = "status")
    public String status;
}