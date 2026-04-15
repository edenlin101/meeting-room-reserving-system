package app.website.api.reservation;
import core.framework.api.json.Property;
import core.framework.api.validate.NotNull;
import java.time.ZonedDateTime;
public class ReserveRoomAJAXRequest {
    @NotNull
    @Property(name = "room_id")
    public Long roomId;

    @NotNull
    @Property(name = "start_time")
    public ZonedDateTime startTime;

    @NotNull
    @Property(name = "end_time")
    public ZonedDateTime endTime;
}