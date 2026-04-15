package app.meetingroom.api.reservation;

import core.framework.api.json.Property;
import java.time.LocalDateTime;

public class ReservationView {
    @Property(name = "id")
    public Long id;

    @Property(name = "room_id")
    public Long roomId;

    @Property(name = "user_id")
    public Long userId;

    @Property(name = "start_time")
    public LocalDateTime startTime;

    @Property(name = "end_time")
    public LocalDateTime endTime;

    @Property(name = "status")
    public String status;
}
