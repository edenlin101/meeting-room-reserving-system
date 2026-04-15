package app.meetingroom.api.reservation;
import core.framework.api.validate.NotNull;

import core.framework.api.json.Property;
import java.time.LocalDateTime;

public class ReservationView {
    @NotNull
    @Property(name = "id")
    public Long id;

    @NotNull
    @Property(name = "room_id")
    public Long roomId;

    @NotNull
    @Property(name = "user_id")
    public Long userId;

    @NotNull
    @Property(name = "start_time")
    public LocalDateTime startTime;

    @NotNull
    @Property(name = "end_time")
    public LocalDateTime endTime;

    @NotNull
    @Property(name = "status")
    public String status;
}
