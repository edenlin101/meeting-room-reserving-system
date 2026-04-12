package com.wonder.meetingroom.kafka;

import core.framework.api.json.Property;

/**
 * Reservation Reminder Event.
 *
 * @author Opencode
 */
public class ReservationReminderEvent {
    @Property(name = "user_id")
    public Long userId;

    @Property(name = "reservation_id")
    public Long reservationId;

    @Property(name = "room_name")
    public String roomName;

    @Property(name = "start_time")
    public String startTime;

    @Property(name = "end_time")
    public String endTime;

    public ReservationReminderEvent() {
    }

    public ReservationReminderEvent(Long userId, Long reservationId, String roomName, String startTime, String endTime) {
        this.userId = userId;
        this.reservationId = reservationId;
        this.roomName = roomName;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}