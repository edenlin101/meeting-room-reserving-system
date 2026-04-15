package app.notification;

import app.booking.api.kafka.ReservationUpcomingMessage;
import app.notification.kafka.ReservationUpcomingMessageHandler;
import core.framework.module.Module;

public class NotificationModule extends Module {
    @Override
    protected void initialize() {
        loadProperties("app.properties");
        
        kafka().uri(requiredProperty("sys.kafka.uri"));
        kafka().subscribe("reservation-upcoming", ReservationUpcomingMessage.class, bind(ReservationUpcomingMessageHandler.class));
    }
}