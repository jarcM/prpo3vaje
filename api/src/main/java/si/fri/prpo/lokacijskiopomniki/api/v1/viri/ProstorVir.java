package si.fri.prpo.lokacijskiopomniki.api.v1.viri;

import com.kumuluz.ee.rest.beans.QueryParameters;
import si.fri.prpo.lokacijskiopomniki.entitete.Prostor;
import si.fri.prpo.lokacijskiopomniki.storitve.ProstorZrno;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Context;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

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
                .ok(aBean.getArtikli(query))
                .header("X-Total-Count", artCount)
                .build();
    }

    @Operation(description = "Vrne prostore", summary = "Seznam prostorov",
            tags = "prostor", responses = {
            @ApiResponse(responseCode = "200",
                    description = "Seznam prostorov",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = Artikel.class))),
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
    @Operation(description = "Dodaj prostor", summary = "Dodajanje prostora",
            tags = "prostor", responses = {
            @ApiResponse(responseCode = "201",
                    description = "Prostor dodan"
            ),
            @ApiResponse(responseCode = "405", description = "Napaka")
    })


    @POST
    public Response dodajProstor(Prostor p){

        return Response
                .status(Response.Status.CREATED)
                .entity(prostorZrno.addProstor(p))
                .build();
    }

    @Operation(description = "Posodobi prostor", summary = "Posodabljanje prostora",
            tags = "prostor", responses = {
            @ApiResponse(responseCode = "201", description = "Prostor uspešno posodobljen"
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
                .entity(prostorZrno.odstraniProstor(id))
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