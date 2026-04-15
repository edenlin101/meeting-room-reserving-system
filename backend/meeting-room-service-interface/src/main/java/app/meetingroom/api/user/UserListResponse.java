package app.meetingroom.api.user;

import core.framework.api.json.Property;

import java.util.List;

public class UserListResponse {
    @Property(name = "items")
    public List<UserView> items;
}