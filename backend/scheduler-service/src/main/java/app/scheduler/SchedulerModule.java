package app.scheduler;

import app.booking.api.kafka.CheckUpcomingReservationMessage;
import core.framework.module.Module;

import java.time.Duration;

public class SchedulerModule extends Module {
    @Override
    protected void initialize() {
        loadProperties("app.properties");

        kafka().uri(requiredProperty("sys.kafka.uri"));
        kafka().publish("check-upcoming-reservation", CheckUpcomingReservationMessage.class);

        CheckUpcomingReservationsJob job = bind(CheckUpcomingReservationsJob.class);
        schedule().fixedRate("notify-upcoming-reservations", job, Duration.ofMinutes(1));
    }
}