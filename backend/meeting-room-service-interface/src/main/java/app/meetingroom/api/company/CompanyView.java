package app.meetingroom.api.company;

import core.framework.api.json.Property;

public class CompanyView {
    @Property(name = "id")
    public Long id;

    @Property(name = "name")
    public String name;

    @Property(name = "address")
    public String address;

    @Property(name = "status")
    public String status;
}
