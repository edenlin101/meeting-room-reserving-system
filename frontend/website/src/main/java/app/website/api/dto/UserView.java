package app.website.api.dto;

import core.framework.api.web.service.Property;

public class UserView {
    @Property(name = "id")
    public Long id;

    @Property(name = "username")
    public String username;

    @Property(name = "companyId")
    public Long companyId;

    @Property(name = "role")
    public String role;

    @Property(name = "status")
    public String status;
}