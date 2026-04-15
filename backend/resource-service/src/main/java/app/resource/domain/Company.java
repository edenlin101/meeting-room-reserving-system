package app.resource.domain;
import core.framework.db.Column;
import core.framework.db.PrimaryKey;
import core.framework.db.Table;
import java.time.ZonedDateTime;
@Table(name = "companies")
public class Company {
    @PrimaryKey(autoIncrement = true)
    @Column(name = "id")
    public Long id;

    @Column(name = "name")
    public String name;

    @Column(name = "status")
    public CompanyStatus status;

    @Column(name = "created_time")
    public ZonedDateTime createdTime;

    @Column(name = "updated_time")
    public ZonedDateTime updatedTime;
}