package app.backoffice.api.company;
import core.framework.api.json.Property;
import core.framework.api.validate.NotBlank;
import core.framework.api.validate.NotNull;

public class CreateCompanyAJAXRequest {
    @NotBlank
    @NotNull
    @Property(name = "name")
    public String name;
}