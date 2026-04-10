package com.wonder.meetingroom.api.dto;

import core.framework.api.json.Property;

/**
 * Room View.
 *
 * @author Opencode
 */
public class RoomView {
    @Property(name = "id")
    public Long id;

    @Property(name = "company_id")
    public Long companyId;

    @Property(name = "name")
    public String name;

    @Property(name = "capacity")
    public Integer capacity;

    @Property(name = "status")
    public String status;
}
