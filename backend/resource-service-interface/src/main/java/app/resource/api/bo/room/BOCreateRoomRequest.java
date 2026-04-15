package app.resource.api.bo.room;
import core.framework.api.json.Property;
import core.framework.api.validate.NotBlank;
import core.framework.api.validate.NotNull;

public class BOCreateRoomRequest {
    @NotNull @Property(name = "company_id") public Long companyId;
    @NotNull @NotBlank @Property(name = "name") public String name;
    @NotNull @Property(name = "capacity") public Integer capacity;
}