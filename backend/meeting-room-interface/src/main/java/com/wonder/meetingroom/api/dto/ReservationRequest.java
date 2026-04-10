package com.wonder.meetingroom.api.dto;

import core.framework.api.json.Property;
import core.framework.api.validate.NotNull;
import java.time.LocalDateTime;

/**
 * Reservation Request.
 *
 * @author Opencode
 */
public class ReservationRequest {
    @NotNull
    @Property(name = "start_time")
    public LocalDateTime startTime;

    @NotNull
    @Property(name = "end_time")
    public LocalDateTime endTime;

    @NotNull
    @Property(name = "user_id")
    public Long userId;
}
