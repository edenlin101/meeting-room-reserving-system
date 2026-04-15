package app.booking.domain;
import core.framework.db.Column;
import core.framework.db.PrimaryKey;
import core.framework.db.Table;
import java.time.ZonedDateTime;
@Table(name = "reservations")
public class Reservation {
    @PrimaryKey(autoIncrement = true)
    @Column(name = "id")
    public Long id;

    @Column(name = "room_id")
    public Long roomId;

    @Column(name = "user_id")
    public Long userId;

    @Column(name = "start_time")
    public ZonedDateTime startTime;

    @Column(name = "end_time")
    public ZonedDateTime endTime;

    @Column(name = "status")
    public ReservationStatus status;

    @Column(name = "created_time")
    public ZonedDateTime createdTime;

    @Column(name = "updated_time")
    public ZonedDateTime updatedTime;
}