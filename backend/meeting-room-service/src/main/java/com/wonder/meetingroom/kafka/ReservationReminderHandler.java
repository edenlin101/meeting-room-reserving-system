package com.wonder.meetingroom.kafka;

import core.framework.kafka.MessageHandler;
import core.framework.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Reservation Reminder Handler.
 *
 * @author Opencode
 */
public class ReservationReminderHandler implements MessageHandler<ReservationReminderEvent> {
    private static final Logger logger = LoggerFactory.getLogger(ReservationReminderHandler.class);

    @Inject
    NotificationService notificationService;

    @Override
    public void handle(String key, ReservationReminderEvent message) {
        logger.info("Sending reservation reminder to user {}, reservation {} starts at {}",
            message.userId, message.reservationId, message.startTime);

        notificationService.sendReminder(message);
    }
}