package app.backoffice.api.dto;

import core.framework.api.web.service.Property;

public class CompanyView {
    @Property(name = "id")
    public Long id;

    @Property(name = "name")
    public String name;

    @Property(name = "status")
    public String status;
}