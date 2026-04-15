package app.meetingroom.api.user;
import core.framework.api.validate.NotNull;

import core.framework.api.json.Property;

import java.util.List;

public class UserListResponse {
    @NotNull
    @Property(name = "items")
    public List<UserView> items;
}