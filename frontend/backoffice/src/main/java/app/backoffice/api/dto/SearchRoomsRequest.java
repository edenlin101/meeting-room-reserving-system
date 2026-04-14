package app.backoffice.api.dto;

import core.framework.api.web.service.Property;

public class SearchRoomsRequest {
    @Property(name = "companyId")
    public Long companyId;
}