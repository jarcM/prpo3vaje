package si.fri.prpo.lokacijskiopomniki.api.v1.viri;

import org.eclipse.microprofile.openapi.annotations.*;
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
@Path("prehodi")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class PrehodiVir {
    @Context
    protected UriInfo uriInfo;

    @Inject
    private PrehodiZrno prehodZrno;

//    @GET
//    public Response vrniPrehode(){
//
//    }

    @Operation(description = "Vrne vse prehode", summary = "Seznam prehodov me prostori")
    @APIResponses({
            @APIResponse(responseCode = "200",
                    description = "Seznam prehodov med prostori",
                    content = @Content(schema = @Schema(implementation = Prehodi.class)),
                    headers = {@Header(name = "X-Total-Count", description = "Število vrnjenih prostorov")})
    })

    public Response pridobiPrehod(){
        QueryParameters query = QueryParameters.query(uriInfo.getRequestUri().getQuery()).build();
        Long prehodiCount = prehodZrno.getPrehodCount(query);
        return Response
                .ok(prehodZrno.getPrehodCount(query))
                .header("X-Total-Count", prehodiCount)
                .build();
    }


    @Operation(description = "Vrni prehod", summary = "Vrnjen prehod")
            @APIResponses({
            @APIResponse(responseCode = "200",
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
    @Operation(description = "Dodaj prehod", summary = "Dodajanje prehoda")
            @APIResponses({
            @APIResponse(responseCode = "201",
                    description = "Prehod dodan"
            ),
            @APIResponse(responseCode = "405", description = "Error")
    })
    @POST
    public Response dodajPrehod(Prehodi a){

        return Response
                .status(Response.Status.CREATED)
                .entity(prehodZrno.addPrehod(a))
                .build();
    }
    @Operation(description = "Posodobi prehdo", summary = "Posodabljanje prehoda")
            @APIResponses({
            @APIResponse(responseCode = "201", description = "Posodobljen prehod"
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

    @Operation(description = "Odstrani prehod", summary = "Odstranjevanje prehoda")
            @APIResponses({
                    @APIResponse(responseCode = "200", description = "Prehod odstranjen"),
                    @APIResponse(responseCode = "404", description = "Prehod not found")

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