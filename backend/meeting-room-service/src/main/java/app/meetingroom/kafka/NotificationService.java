package app.meetingroom.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotificationService {
    private static final Logger LOG = LoggerFactory.getLogger(NotificationService.class);

    public void sendReminder(ReservationReminderEvent event) {
        LOG.info("Notification sent to user {}: Your reservation (ID: {}) for room '{}' will start at {} and end at {}",
            event.userId, event.reservationId, event.roomName, event.startTime, event.endTime);
    }
}
