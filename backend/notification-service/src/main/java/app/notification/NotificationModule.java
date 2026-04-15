package app.notification;

import app.booking.api.kafka.NotifyUpcomingReservationMessage;
import app.notification.kafka.NotifyUpcomingReservationMessageHandler;
import core.framework.module.Module;

public class NotificationModule extends Module {
    @Override
    protected void initialize() {
        loadProperties("app.properties");
        
        kafka().uri(requiredProperty("sys.kafka.uri"));
        kafka().subscribe("notify-upcoming-reservation", NotifyUpcomingReservationMessage.class, bind(NotifyUpcomingReservationMessageHandler.class));
    }
}