package si.fri.prpo.lokacijskiopomniki.api.v1.viri;

import org.eclipse.microprofile.openapi.annotations.*;
import si.fri.prpo.lokacijskiopomniki.storitve.PorociloZrno;
import si.fri.prpo.lokacijskiopomniki.storitve.PrehodiZrno;
import si.fri.prpo.lokacijskiopomniki.entitete.Prehodi;
import com.kumuluz.ee.rest.beans.QueryParameters;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Context;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.headers.Header;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
@ApplicationScoped
@Path("porocila")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class PorociloVir {
    @Context
    protected UriInfo uriInfo;
    @Inject
    private PorociloZrno porociloZrno;
    @GET
    @Path("{id}")
    public Response vrniPorocilo(@PathParam("id") Integer id) {

        Porocilo porocilo = porociloZrno.pridobiPorocilo(id);

        if(porocilo != null){
            return Response.ok(porocilo).build();
        }else{
            return  Response.status(Response.Status.NOT_FOUND).build();
        }

    }
    @POST
    public Response dodajPorocilo(Porocilo a){

        return Response
                .status(Response.Status.CREATED)
                .entity(porociloZrno.addPorocilo(a))
                .build();
    }


}
