package si.fri.prpo.lokacijskiopomniki.api.v1;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;
import org.eclipse.microprofile.openapi.annotations.servers.Server;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
@OpenAPIDefinition(info = @Info(title = "lokacijski opomniki", version = "v1", contact = @Contact(), license = @License(name = ""), description = "API."), security = @SecurityRequirement(name = "openid-connect"), servers = @Server(url ="http://localhost:8080/v1"))
@ApplicationPath("si/fri/prpo/lokacijskiopomniki/api/v1/viri")
public class lokacijskiOpomniki extends Application{
}