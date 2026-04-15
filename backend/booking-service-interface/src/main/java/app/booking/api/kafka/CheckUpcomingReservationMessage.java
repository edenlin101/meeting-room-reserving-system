package app.booking.api.kafka;

import core.framework.api.json.Property;
import core.framework.api.validate.NotNull;
import java.time.ZonedDateTime;

public class CheckUpcomingReservationMessage {
    @NotNull
    @Property(name = "trigger_time")
    public ZonedDateTime triggerTime;
}