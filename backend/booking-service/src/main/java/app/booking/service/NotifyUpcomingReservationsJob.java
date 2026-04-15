package app.booking.service;

import app.booking.api.kafka.ReservationUpcomingMessage;
import app.booking.domain.Reservation;
import app.booking.domain.ReservationStatus;
import core.framework.db.Repository;
import core.framework.inject.Inject;
import core.framework.kafka.MessagePublisher;
import core.framework.scheduler.Job;
import core.framework.scheduler.JobContext;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class NotifyUpcomingReservationsJob implements Job {
    @Inject Repository<Reservation> reservationRepository;
    @Inject MessagePublisher<ReservationUpcomingMessage> publisher;

    @Override
    public void execute(JobContext context) {
        ZonedDateTime now = ZonedDateTime.now();
        // find reservations starting between now + 9 minutes and now + 11 minutes
        ZonedDateTime startRange = now.plusMinutes(9);
        ZonedDateTime endRange = now.plusMinutes(11);

        List<Reservation> upcomingReservations = reservationRepository.select(
            "status = ? AND start_time >= ? AND start_time < ?",
            ReservationStatus.ACTIVE, startRange, endRange
        );

        for (Reservation reservation : upcomingReservations) {
            ReservationUpcomingMessage message = new ReservationUpcomingMessage();
            message.reservationId = reservation.id;
            message.userId = reservation.userId;
            message.roomId = reservation.roomId;
            message.startTime = reservation.startTime.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
            
            publisher.publish(String.valueOf(reservation.id), message);
        }
    }
}