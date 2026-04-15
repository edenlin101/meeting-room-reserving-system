package app.meetingroom.api.reservation;

import core.framework.api.json.Property;
import core.framework.api.validate.NotNull;
import java.time.LocalDateTime;

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
