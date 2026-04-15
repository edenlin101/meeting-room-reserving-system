package app.meetingroom.api.company;
import core.framework.api.validate.NotNull;

import core.framework.api.json.Property;

import java.util.List;

public class CompanyListResponse {
    @NotNull
    @Property(name = "items")
    public List<CompanyView> items;
}