package app.backoffice.api.company;
import core.framework.api.validate.NotNull;
import core.framework.api.json.Property;

public class CreateCompanyAJAXResponse {
    @NotNull
    @Property(name = "id")
    public Long id;
}