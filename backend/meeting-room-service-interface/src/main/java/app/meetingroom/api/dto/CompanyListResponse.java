package app.meetingroom.api.dto;

import core.framework.api.json.Property;

import java.util.List;

public class CompanyListResponse {
    @Property(name = "items")
    public List<CompanyView> items;
}