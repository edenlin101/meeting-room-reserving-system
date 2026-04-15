package app.website.api.reservation;
import core.framework.api.json.Property;
import core.framework.api.validate.NotNull;
import java.time.ZonedDateTime;
public class ReservationAJAXView {
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
    public ZonedDateTime startTime;

    @NotNull
    @Property(name = "end_time")
    public ZonedDateTime endTime;

    @NotNull
    @Property(name = "status")
    public String status;
}