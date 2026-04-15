package app.booking.api.kafka;
import core.framework.api.json.Property;
import core.framework.api.validate.NotNull;

public class ReservationUpcomingMessage {
    @NotNull
    @Property(name = "reservation_id")
    public Long reservationId;

    @NotNull
    @Property(name = "user_id")
    public Long userId;

    @NotNull
    @Property(name = "room_id")
    public Long roomId;

    @NotNull
    @Property(name = "start_time")
    public String startTime;
}