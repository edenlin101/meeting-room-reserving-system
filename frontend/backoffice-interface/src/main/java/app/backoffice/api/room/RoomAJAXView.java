package app.backoffice.api.room;
import core.framework.api.json.Property;
import core.framework.api.validate.NotNull;

public class RoomAJAXView {
    @NotNull
    @Property(name = "id")
    public Long id;

    @NotNull
    @Property(name = "name")
    public String name;

    @NotNull
    @Property(name = "capacity")
    public Integer capacity;
}