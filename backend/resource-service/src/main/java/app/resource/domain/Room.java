package app.resource.domain;
import core.framework.db.Column;
import core.framework.db.PrimaryKey;
import core.framework.db.Table;
import java.time.ZonedDateTime;

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

    @Column(name = "created_time")
    public ZonedDateTime createdTime;

    @Column(name = "updated_time")
    public ZonedDateTime updatedTime;
}