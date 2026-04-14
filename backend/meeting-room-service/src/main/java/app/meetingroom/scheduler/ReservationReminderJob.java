package app.meetingroom.scheduler;

import app.meetingroom.kafka.ReservationReminderEvent;
import app.meetingroom.service.ReservationService;
import core.framework.inject.Inject;
import core.framework.kafka.MessagePublisher;
import core.framework.scheduler.Job;
import core.framework.scheduler.JobContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.List;

public class ReservationReminderJob implements Job {
    private static final Logger LOG = LoggerFactory.getLogger(ReservationReminderJob.class);

    @Inject
    ReservationService reservationService;

    @Inject
    MessagePublisher<ReservationReminderEvent> publisher;

    @Override
    public void execute(JobContext context) {
        LOG.info("Running reservation reminder job");
        List<Long> upcomingReservationIds = reservationService.getUpcomingReservations();
        for (Long reservationId : upcomingReservationIds) {
            ReservationReminderEvent event = new ReservationReminderEvent();
            event.reservationId = reservationId;
            event.userId = 1L;
            event.startTime = LocalDateTime.now().plusHours(1).toString();
            publisher.publish(String.valueOf(reservationId), event);
        }
    }
}
