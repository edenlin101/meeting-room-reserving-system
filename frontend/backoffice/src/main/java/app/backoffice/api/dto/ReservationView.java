package app.backoffice.api.dto;

import core.framework.api.web.service.Property;

import java.time.LocalDateTime;

public class ReservationView {
    @Property(name = "id")
    public Long id;

    @Property(name = "roomId")
    public Long roomId;

    @Property(name = "userId")
    public Long userId;

    @Property(name = "startTime")
    public LocalDateTime startTime;

    @Property(name = "endTime")
    public LocalDateTime endTime;

    @Property(name = "status")
    public String status;
}