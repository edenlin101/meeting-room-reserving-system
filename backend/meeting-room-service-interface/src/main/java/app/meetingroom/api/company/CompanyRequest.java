package app.meetingroom.api.company;

import core.framework.api.json.Property;
import core.framework.api.validate.NotBlank;
import core.framework.api.validate.NotNull;

public class CompanyRequest {
    @NotNull
    @NotBlank
    @Property(name = "name")
    public String name;

    @Property(name = "address")
    public String address;
}
