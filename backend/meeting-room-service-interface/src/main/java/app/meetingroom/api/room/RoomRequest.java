package app.meetingroom.api.room;

import core.framework.api.json.Property;
import core.framework.api.validate.NotNull;

public class RoomRequest {
    @NotNull
    @Property(name = "company_id")
    public Long companyId;

    @NotNull
    @Property(name = "name")
    public String name;

    @NotNull
    @Property(name = "capacity")
    public Integer capacity;
}
