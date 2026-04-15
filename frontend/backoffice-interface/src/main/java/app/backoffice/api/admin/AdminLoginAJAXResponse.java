package app.backoffice.api.admin;
import core.framework.api.validate.NotNull;
import core.framework.api.json.Property;

public class AdminLoginAJAXResponse {
    @NotNull
    @Property(name = "token")
    public String token;
}