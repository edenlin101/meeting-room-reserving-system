package app.booking.service;

import app.booking.api.kafka.CheckUpcomingReservationMessage;
import app.booking.api.kafka.NotifyUpcomingReservationMessage;
import app.booking.domain.Reservation;
import app.booking.domain.ReservationStatus;
import core.framework.db.Repository;
import core.framework.inject.Inject;
import core.framework.kafka.MessageHandler;
import core.framework.kafka.MessagePublisher;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CheckUpcomingReservationMessageHandler implements MessageHandler<CheckUpcomingReservationMessage> {
    @Inject
    Repository<Reservation> reservationRepository;
    
    @Inject
    MessagePublisher<NotifyUpcomingReservationMessage> publisher;

    @Override
    public void handle(String key, CheckUpcomingReservationMessage message) throws Exception {
        ZonedDateTime now = message.triggerTime;
        if (now == null) {
            now = ZonedDateTime.now();
        }
        
        ZonedDateTime startRange = now.plusMinutes(9);
        ZonedDateTime endRange = now.plusMinutes(11);

        List<Reservation> upcomingReservations = reservationRepository.select(
            "status = ? AND start_time >= ? AND start_time < ?",
            ReservationStatus.ACTIVE, startRange, endRange
        );

        for (Reservation reservation : upcomingReservations) {
            NotifyUpcomingReservationMessage notifyMessage = new NotifyUpcomingReservationMessage();
            notifyMessage.reservationId = reservation.id;
            notifyMessage.userId = reservation.userId;
            notifyMessage.roomId = reservation.roomId;
            notifyMessage.startTime = reservation.startTime.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
            
            publisher.publish(String.valueOf(reservation.id), notifyMessage);
        }
    }
}