package app.meetingroom.api.dto;

import core.framework.api.json.Property;

public class UserView {
    @Property(name = "id")
    public Long id;

    @Property(name = "username")
    public String username;

    @Property(name = "company_id")
    public Long companyId;

    @Property(name = "status")
    public String status;
}
