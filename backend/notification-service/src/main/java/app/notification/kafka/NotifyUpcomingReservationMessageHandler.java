package app.notification.kafka;

import app.booking.api.kafka.NotifyUpcomingReservationMessage;
import core.framework.kafka.MessageHandler;
import core.framework.log.ActionLogContext;

public class NotifyUpcomingReservationMessageHandler implements MessageHandler<NotifyUpcomingReservationMessage> {
    @Override
    public void handle(String key, NotifyUpcomingReservationMessage message) {
        ActionLogContext.put("userId", message.userId);
        ActionLogContext.put("roomId", message.roomId);
        // Simulate sending notification (e.g. email, SMS)
        System.out.println("Notification sent to user " + message.userId + 
            ": Your reservation for room " + message.roomId + 
            " will start at " + message.startTime);
    }
}