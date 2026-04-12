package com.wonder.meetingroom.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Notification Service.
 *
 * @author Opencode
 */
public class NotificationService {
    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);

    public void sendReminder(ReservationReminderEvent event) {
        logger.info("Notification sent to user {}: Your reservation (ID: {}) for room '{}' will start at {} and end at {}",
            event.userId, event.reservationId, event.roomName, event.startTime, event.endTime);
    }
}