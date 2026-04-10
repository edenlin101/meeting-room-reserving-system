package com.wonder.meetingroom.domain;

import core.framework.db.Column;
import core.framework.db.PrimaryKey;
import core.framework.db.Table;

import java.time.LocalDateTime;

/**
 * Reservation Entity.
 *
 * @author Opencode
 */
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
    public LocalDateTime startTime;

    @Column(name = "end_time")
    public LocalDateTime endTime;

    @Column(name = "status")
    public ReservationStatus status;
}
