package app.meetingroom.api.company;

import core.framework.api.json.Property;
import core.framework.api.validate.NotBlank;
import core.framework.api.validate.NotNull;

public class CompanyRequest {
    @NotBlank
    @NotNull
    @Property(name = "name")
    public String name;

    @NotNull
    @Property(name = "address")
    public String address;
}
