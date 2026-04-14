package app.backoffice.api.dto;

import core.framework.api.web.service.Property;

public class CompanyRequest {
    @Property(name = "name")
    public String name;
}