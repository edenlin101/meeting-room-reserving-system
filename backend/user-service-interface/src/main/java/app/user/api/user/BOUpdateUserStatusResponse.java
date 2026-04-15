package app.user.api.user;
import core.framework.api.validate.NotNull;

import core.framework.api.json.Property;

public class BOUpdateUserStatusResponse {
    @NotNull
    @Property(name = "success")
    public Boolean success;
}