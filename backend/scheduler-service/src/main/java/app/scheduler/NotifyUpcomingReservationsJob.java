package app.scheduler;

import app.booking.api.kafka.CheckUpcomingReservationMessage;
import core.framework.inject.Inject;
import core.framework.kafka.MessagePublisher;
import core.framework.scheduler.Job;
import core.framework.scheduler.JobContext;
import java.time.ZonedDateTime;

public class NotifyUpcomingReservationsJob implements Job {
    @Inject
    MessagePublisher<CheckUpcomingReservationMessage> publisher;

    @Override
    public void execute(JobContext context) {
        CheckUpcomingReservationMessage message = new CheckUpcomingReservationMessage();
        message.triggerTime = ZonedDateTime.now();
        publisher.publish(message); // Publish without key for random distribution
    }
}