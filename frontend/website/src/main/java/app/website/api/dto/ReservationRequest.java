package app.website.api.dto;

import core.framework.api.web.service.Property;

import java.time.LocalDateTime;

public class ReservationRequest {
    @Property(name = "userId")
    public Long userId;

    @Property(name = "startTime")
    public LocalDateTime startTime;

    @Property(name = "endTime")
    public LocalDateTime endTime;
}