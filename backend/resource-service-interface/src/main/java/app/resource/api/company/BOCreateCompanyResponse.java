package app.resource.api.company;
import core.framework.api.validate.NotNull;
import core.framework.api.json.Property;

public class BOCreateCompanyResponse {
    @NotNull
    @Property(name = "id") public Long id;
}