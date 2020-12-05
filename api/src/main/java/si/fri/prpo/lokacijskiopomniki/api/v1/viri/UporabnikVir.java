package si.fri.prpo.lokacijskiopomniki.api.v1.viri;

import si.fri.prpo.lokacijskiopomniki.entitete.Uporabnik;
import si.fri.prpo.lokacijskiopomniki.storitve.anotacije.BeleziKlice;
import si.fri.prpo.lokacijskiopomniki.storitve.UporabnikZrno;
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
@Path("uporabniki")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class UporabnikVir {
    @Context
    protected UriInfo uriInfo;

    @Inject
    private UporabnikZrno uporabnikZrno;

    @GET
    public Response pridobiUporabnike(){

        QueryParameters query = QueryParameters.query(uriInfo.getRequestUri().getQuery()).build();
        Long uporabnikiCount = uporabnikZrno.getUporabnikiCount(query);
        return Response
                .ok(uporabnikZrno.getUporabniki(query))
                .header("X-Total-Count", uporabnikiCount)
                .build();
    }

    @Operation(description = "Pridobi uporabnike", summary = "Pridobi uporabnike")
            @APIResponses({
            @APIResponse(responseCode = "200",
                    description = "Pridobljeni uporabniki",
                    content = @Content(schema = @Schema(implementation = Uporabnik.class)),
                    headers = {@Header(name = "X-Total-Count", description = "Število uporabnikov")})

    })
    @GET
    @Path("{id}")
    public Response pridobiUporabnika(@PathParam("id") Integer id) {

        Uporabnik u = uporabnikZrno.pridobiUporabnika(id);

        if(u != null){
            return Response.ok(u).build();
        }else{
            return  Response.status(Response.Status.NOT_FOUND).build();
        }

    }

    @Operation(description = "Dodaj uporabnika", summary = "Dodaj uporabnika")
            @APIResponses({
            @APIResponse(responseCode = "201",
                    description = "Uporabnik je bil dodan"
            ),
            @APIResponse(responseCode = "405", description = "Error")
    })
    @POST
    @BeleziKlice
    public Response dodajUporabnika(Uporabnik u){

        return Response
                .status(Response.Status.CREATED)
                .entity(uporabnikZrno.addUporabnik(u))
                .build();
    }

    @Operation(description = "Posodobi uporabnika", summary = "Posodobi uporabnika")
            @APIResponses({
            @APIResponse(responseCode = "201", description = "Uporabnik je bil posodobljen"
            ), @APIResponse(responseCode = "404", description = "Uporabnik ni bil najden")
    })

    @PUT
    @Path("{id}")
    public Response posodobiUporabnika(@PathParam("id") Integer id, Uporabnik u) {
        return Response
                .status(Response.Status.CREATED)
                .entity(uporabnikZrno.updateUporabnik(id,u))
                .build();
    }



    @Operation(description = "Odstrani uporabnika", summary = "Odstrani uporabnika")
            @APIResponses({
                    @APIResponse(responseCode = "200", description = "Uporabnik je bil odstranjen"),
                    @APIResponse(responseCode = "404", description = "Uporabnik ni bil najden")
            })

    @DELETE
    @Path("{id}")
    public Response odstraniUporabnika(@PathParam("id") Integer id) {
        return Response
                .status(Response.Status.OK)
                .entity(uporabnikZrno.deleteUporabnik(id))
                .build();
    }
}
