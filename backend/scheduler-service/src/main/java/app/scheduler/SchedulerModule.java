package app.scheduler;

import app.booking.api.kafka.ReservationUpcomingMessage;
import app.scheduler.NotifyUpcomingReservationsJob;
import core.framework.module.Module;

import java.time.Duration;

public class SchedulerModule extends Module {
    @Override
    protected void initialize() {
        loadProperties("app.properties");

        db().url(requiredProperty("sys.jdbc.url"));
        db().user(requiredProperty("sys.jdbc.user"));
        db().password(requiredProperty("sys.jdbc.password"));
        db().view(NotifyUpcomingReservationsJob.ReservationData.class);

        kafka().uri(requiredProperty("sys.kafka.uri"));
        kafka().publish("reservation-upcoming", ReservationUpcomingMessage.class);

        NotifyUpcomingReservationsJob job = bind(NotifyUpcomingReservationsJob.class);
        schedule().fixedRate("notify-upcoming-reservations", job, Duration.ofMinutes(1));
    }
}