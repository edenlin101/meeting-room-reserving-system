package app.meetingroom.kafka;

import core.framework.kafka.MessageHandler;
import core.framework.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReservationReminderHandler implements MessageHandler<ReservationReminderEvent> {
    private static final Logger LOG = LoggerFactory.getLogger(ReservationReminderHandler.class);
    @Inject
    NotificationService notificationService;

    @Override
    public void handle(String key, ReservationReminderEvent message) {
        LOG.info("Sending reservation reminder to user {}, reservation {} starts at {}",
            message.userId, message.reservationId, message.startTime);

        notificationService.sendReminder(message);
    }
}
