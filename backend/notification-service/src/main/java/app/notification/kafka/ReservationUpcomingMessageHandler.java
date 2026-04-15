package app.notification.kafka;

import app.booking.api.kafka.ReservationUpcomingMessage;
import core.framework.kafka.MessageHandler;
import core.framework.log.ActionLogContext;

public class ReservationUpcomingMessageHandler implements MessageHandler<ReservationUpcomingMessage> {
    @Override
    public void handle(String key, ReservationUpcomingMessage message) {
        ActionLogContext.put("userId", message.userId);
        ActionLogContext.put("roomId", message.roomId);
        // Simulate sending notification (e.g. email, SMS)
        System.out.println("Notification sent to user " + message.userId + 
            ": Your reservation for room " + message.roomId + 
            " will start at " + message.startTime);
    }
}