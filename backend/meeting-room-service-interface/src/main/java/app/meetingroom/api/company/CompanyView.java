package app.meetingroom.api.company;
import core.framework.api.validate.NotNull;

import core.framework.api.json.Property;

public class CompanyView {
    @NotNull
    @Property(name = "id")
    public Long id;

    @NotNull
    @Property(name = "name")
    public String name;

    @NotNull
    @Property(name = "address")
    public String address;

    @NotNull
    @Property(name = "status")
    public String status;
}
