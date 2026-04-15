package app.website.api.reservation;
import core.framework.api.web.service.QueryParam;
import core.framework.api.validate.NotNull;
import java.time.ZonedDateTime;
public class GetCalendarAJAXRequest {
    @NotNull
    @QueryParam(name = "room_id")
    public Long roomId;
    
    @NotNull
    @QueryParam(name = "date")
    public ZonedDateTime date;
}