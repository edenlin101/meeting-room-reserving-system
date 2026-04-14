package app.meetingroom.kafka;

import core.framework.api.json.Property;

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



}
