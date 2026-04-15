package app.resource.api.company;
import core.framework.api.json.Property;
import core.framework.api.validate.NotNull;
public class CompanyView {
    @NotNull @Property(name = "id") public Long id;
    @NotNull @Property(name = "name") public String name;
    @NotNull @Property(name = "status") public String status;
}