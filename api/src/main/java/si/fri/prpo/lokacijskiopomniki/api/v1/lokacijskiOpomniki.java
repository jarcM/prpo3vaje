package si.fri.prpo.lokacijskiopomniki.api.v1;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
@OpenAPIDefinition(info = @Info(title = "lokacijski opomniki", version = "v1", contact = @Contact(), license = @License(), description = "API."), security = @SecurityRequirement(name = "openid-connect"), servers = @Server(url ="http://localhost:8080/v1"))
@ApplicationPath("si/fri/prpo/lokacijskiopomniki/api/v1/viri")
public class lokacijskiOpomniki extends Application{
}