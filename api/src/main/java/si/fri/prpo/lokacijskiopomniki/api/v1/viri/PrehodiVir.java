package si.fri.prpo.lokacijskiopomniki.api.v1.viri;

import si.fri.prpo.lokacijskiopomniki.storitve.PrehodiZrno;
import si.fri.prpo.lokacijskiopomniki.entitete.Prehodi;
import com.kumuluz.ee.rest.beans.QueryParameters;
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
@Path("prehodi")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class PrehodiVir {
    @Context
    protected UriInfo uriInfo;

    @Inject
    private PrehodiZrno prehodZrno;

    @GET
    public Response vrniPrehode(){
        @Operation(description = "Vrne vse prehode", summary = "Seznam prehodov me prostori",
                tags = "prehodi", responses = {
                @ApiResponse(responseCode = "200",
                        description = "Seznam prehodov med prostori",
                        content = @Content(array = @ArraySchema(schema = @Schema(implementation = NakupovalniSeznam.class))),
                        headers = {@Header(name = "X-Total-Count", description = "Število vrnjenih prostorov")})
        })
    }
    public Response pridobiPrehod(){
        QueryParameters query = QueryParameters.query(uriInfo.getRequestUri().getQuery()).build();
        Long prehodiCount = prehodZrno.getNakupovalniSeznamiCount(query);
        return Response
                .ok(nsBean.getPrehodiCOunt(query))
                .header("X-Total-Count", prehodiCount)
                .build();
    }


    @Operation(description = "Vrni prehod", summary = "Vrnjen prehod",
            tags = "prehodi", responses = {
            @ApiResponse(responseCode = "200",
                    description = "Vrnjen prehod",
                    content = @Content(schema = @Schema(implementation = Prehodi.class))
            )
    })
    @GET
    @Path("{id}")
    public Response vrniPrehod(@PathParam("id") Integer id) {

        Prehodi prehod = prehodZrno.pridobiPrehod(id);

        if(prehod != null){
            return Response.ok(prehod).build();
        }else{
            return  Response.status(Response.Status.NOT_FOUND).build();
        }

    }
    @Operation(description = "Dodaj prehod", summary = "Dodajanje prehoda",
            tags = "prehodi", responses = {
            @ApiResponse(responseCode = "201",
                    description = "Prehod dodan"
            ),
            @ApiResponse(responseCode = "405", description = "Error")
    })
    @POST
    public Response dodajPrehod(Prehodi a){

        return Response
                .status(Response.Status.CREATED)
                .entity(prehodZrno.addPrehod(a))
                .build();
    }
    @Operation(description = "Posodobi prehdo", summary = "Posodabljanje prehoda",
            tags = "prehodi", responses = {
            @ApiResponse(responseCode = "201", description = "Posodobljen prehod"
            )
    })

    @PUT
    @Path("{id}")
    public Response posodobiPrehod(@PathParam("id") Integer id, Prehodi a) {
        return Response
                .status(Response.Status.CREATED)
                .entity(prehodZrno.updatePrehod(id,a))
                .build();
    }

    @Operation(description = "Odstrani prehod", summary = "Odstranjevanje prehoda",
            tags = "prehodii",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Prehod odstranjen"),
                    @ApiResponse(responseCode = "404", description = "Prehod not found")

            })
    @DELETE
    @Path("{id}")
    public Response odstraniPrehod(@PathParam("id") Integer id) {
        return Response
                .status(Response.Status.OK)
                .entity(prehodZrno.deletePrehod(id))
                .build();
    }
}