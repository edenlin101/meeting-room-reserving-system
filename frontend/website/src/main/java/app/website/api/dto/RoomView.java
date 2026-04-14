package app.website.api.dto;

import core.framework.api.web.service.Property;

public class RoomView {
    @Property(name = "id")
    public Long id;

    @Property(name = "companyId")
    public Long companyId;

    @Property(name = "name")
    public String name;

    @Property(name = "capacity")
    public Integer capacity;

    @Property(name = "status")
    public String status;
}