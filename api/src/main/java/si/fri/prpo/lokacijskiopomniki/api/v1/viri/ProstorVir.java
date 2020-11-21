package si.fri.prpo.lokacijskiopomniki.api.v1.viri;


import si.fri.prpo.lokacijskiopomniki.entitete.Prostor;
import si.fri.prpo.lokacijskiopomniki.storitve.ProstorZrno;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@ApplicationScoped
@Path("prostor")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class ProstorVir {

    @Inject
    private ProstorZrno prostorZrno;

    @GET
    public Response vrniProstore(){
        return Response.ok(prostorZrno.getProstor()).build();
    }

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
    /* @Operation(description = "Dodaj prostor", summary= "Dodajanje prostora")
     @ApiResponses({
             @ApiResponse(respondeCode="201",
                 description="Prostor uspešno dodan."
             ),
             @ApiResponse(responseCode="405", description "Validacijska napaka.)
     })*/
    @POST
    public Response dodajProstor(Prostor p){

        return Response
                .status(Response.Status.CREATED)
                .entity(prostorZrno.addProstor(p))
                .build();
    }

    @PUT
    @Path("{id}")
    public Response posodobiProstor(@PathParam("id") Integer id, Prostor p) {
        return Response
                .status(Response.Status.CREATED)
                .entity(prostorZrno.updateProstor(id,p))
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