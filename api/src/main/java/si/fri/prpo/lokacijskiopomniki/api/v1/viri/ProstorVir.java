package si.fri.prpo.lokacijskiopomniki.api.v1.viri;

import com.kumuluz.ee.rest.beans.QueryParameters;
import si.fri.prpo.lokacijskiopomniki.entitete.Prostor;
import si.fri.prpo.lokacijskiopomniki.storitve.ProstorZrno;
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
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;

@ApplicationScoped
@Path("prostor")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class ProstorVir {

    @Context
    protected UriInfo uriInfo;

    @Inject
    private ProstorZrno prostorZrno;

    @GET
    public Response vrniProstore(){

        QueryParameters query = QueryParameters.query(uriInfo.getRequestUri().getQuery()).build();
        Long prostorCount = prostorZrno.getProstorCount(query);
        return Response
                .ok(prostorZrno.getProstor(query))
                .header("X-Total-Count", prostorCount)
                .build();
    }

    @Operation(description = "Vrne prostore", summary = "Seznam prostorov")
            @APIResponses({
            @APIResponse(responseCode = "200",
                    description = "Seznam prostorov",
                    content = @Content(schema = @Schema(implementation = Prostor.class)),
                    headers = {@Header(name = "X-Total-Count", description = "Število vrnejenih prostorov")})
            })

    @GET
    @Path("{id}")
    public Response vrniProstor(@PathParam("id") Integer id) {

        Prostor pz = prostorZrno.pridobiProstor(id);

        if(pz != null){
            return Response.ok(pz).build();
        }else{
            return  Response.status(Response.Status.NOT_FOUND).build();
        }

    }
    @Operation(description = "Dodaj prostor", summary = "Dodajanje prostora")
    @APIResponses({
            @APIResponse(responseCode = "201",
                    description = "Prostor dodan"
            ),
            @APIResponse(responseCode = "405", description = "Napaka")
    })


    @POST
    public Response dodajProstor(Prostor p){

        return Response
                .status(Response.Status.CREATED)
                .entity(prostorZrno.addProstor(p))
                .build();
    }

    @Operation(description = "Posodobi prostor", summary = "Posodabljanje prostora")
           @APIResponses({
            @APIResponse(responseCode = "201", description = "Prostor uspešno posodobljen"
            )
    })

    @PUT
    @Path("{id}")
    public Response posodobiProstor(@PathParam("id") Integer id, Prostor p) {
        return Response
                .status(Response.Status.CREATED)
                .entity(prostorZrno.updateProstor(id,p))
                .build();
    }

    @Path("{id}")
    public Response zbrisiArtikel(@Parameter(
            description = "Zbrisanje prostora", required = true)
                                  @PathParam("id") Integer id){
        return Response .status(Response.Status.OK)
                .entity(prostorZrno.deleteProstor(id))
                .build();
    }

    @DELETE
    @Path("{id}")
    public Response odstraniProstor(@PathParam("id") Integer id) {
        return Response
                .status(Response.Status.OK)
                .entity(prostorZrno.deleteProstor(id))
                .build();
    }
}