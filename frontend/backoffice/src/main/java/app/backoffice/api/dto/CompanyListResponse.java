package app.backoffice.api.dto;

import core.framework.api.web.service.Property;

import java.util.List;

public class CompanyListResponse {
    @Property(name = "items")
    public List<CompanyView> items;
}