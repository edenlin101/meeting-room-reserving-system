package app.meetingroom.api.company;

import core.framework.api.json.Property;

import java.util.List;

public class CompanyListResponse {
    @Property(name = "items")
    public List<CompanyView> items;
}