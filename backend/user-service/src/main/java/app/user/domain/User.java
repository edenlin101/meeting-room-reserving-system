package app.user.domain;

import core.framework.api.validate.NotNull;
import core.framework.api.validate.NotBlank;
import core.framework.db.Column;
import core.framework.db.PrimaryKey;
import core.framework.db.Table;
import java.time.LocalDateTime;

@Table(name = "users")
public class User {
    @PrimaryKey(autoIncrement = true)
    @Column(name = "id")
    public Long id;

    @NotNull
    @NotBlank
    @Column(name = "username")
    public String username;

    @NotNull
    @NotBlank
    @Column(name = "password")
    public String password;

    @NotNull
    @Column(name = "company_id")
    public Long companyId;

    @NotNull
    @Column(name = "status")
    public UserStatus status;

    @NotNull
    @Column(name = "created_time")
    public LocalDateTime createdTime;
}