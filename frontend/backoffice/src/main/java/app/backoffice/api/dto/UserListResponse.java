package app.backoffice.api.dto;

import core.framework.api.web.service.Property;

import java.util.List;

public class UserListResponse {
    @Property(name = "items")
    public List<UserView> items;
}