package app.meetingroom.domain;

import core.framework.db.Column;
import core.framework.db.PrimaryKey;
import core.framework.db.Table;

@Table(name = "rooms")
public class Room {
    @PrimaryKey(autoIncrement = true)
    @Column(name = "id")
    public Long id;

    @Column(name = "company_id")
    public Long companyId;

    @Column(name = "name")
    public String name;

    @Column(name = "capacity")
    public Integer capacity;

    @Column(name = "status")
    public RoomStatus status;
}
