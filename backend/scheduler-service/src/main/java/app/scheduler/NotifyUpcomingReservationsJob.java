package app.scheduler;

import app.booking.api.kafka.ReservationUpcomingMessage;
import core.framework.db.Database;
import core.framework.db.Repository;
import core.framework.inject.Inject;
import core.framework.kafka.MessagePublisher;
import core.framework.scheduler.Job;
import core.framework.scheduler.JobContext;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class NotifyUpcomingReservationsJob implements Job {
    @Inject Database database;
    @Inject MessagePublisher<ReservationUpcomingMessage> publisher;

    public static class ReservationData {
        public Long id;
        public Long room_id;
        public Long user_id;
        public ZonedDateTime start_time;
    }

    @Override
    public void execute(JobContext context) {
        ZonedDateTime now = ZonedDateTime.now();
        ZonedDateTime startRange = now.plusMinutes(9);
        ZonedDateTime endRange = now.plusMinutes(11);

        List<ReservationData> upcomingReservations = database.select(
            "SELECT id, room_id, user_id, start_time FROM reservations WHERE status = ? AND start_time >= ? AND start_time < ?",
            ReservationData.class,
            "ACTIVE", startRange, endRange
        );

        for (ReservationData reservation : upcomingReservations) {
            ReservationUpcomingMessage message = new ReservationUpcomingMessage();
            message.reservationId = reservation.id;
            message.userId = reservation.user_id;
            message.roomId = reservation.room_id;
            message.startTime = reservation.start_time.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
            
            publisher.publish(String.valueOf(reservation.id), message);
        }
    }
}