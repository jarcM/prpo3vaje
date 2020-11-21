package si.fri.prpo.lokacijskiopomniki.api.v1.viri;

import si.fri.prpo.lokacijskiopomniki.storitve.PrehodiZrno;
import si.fri.prpo.lokacijskiopomniki.entitete.Prehodi;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@ApplicationScoped
@Path("prehodi")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class PrehodiVir {

    @Inject
    private PrehodiZrno prehodZrno;

    @GET
    public Response vrniPrehode(){
        return Response.ok(prehodZrno.getPrehod()).build();
    }

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

    @POST
    public Response dodajPrehod(Prehodi a){

        return Response
                .status(Response.Status.CREATED)
                .entity(prehodZrno.addPrehod(a))
                .build();
    }

    @PUT
    @Path("{id}")
    public Response posodobiPrehod(@PathParam("id") Integer id, Prehodi a) {
        return Response
                .status(Response.Status.CREATED)
                .entity(prehodZrno.updatePrehod(id,a))
                .build();
    }


    @DELETE
    @Path("{id}")
    public Response odstraniPrehod(@PathParam("id") Integer id) {
        return Response
                .status(Response.Status.OK)
                .entity(prehodZrno.deletePrehod(id))
                .build();
    }
}