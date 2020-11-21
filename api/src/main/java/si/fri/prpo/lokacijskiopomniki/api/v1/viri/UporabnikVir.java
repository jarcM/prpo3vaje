package si.fri.prpo.lokacijskiopomniki.api.v1.viri;

import si.fri.prpo.lokacijskiopomniki.entitete.Uporabnik;
import si.fri.prpo.lokacijskiopomniki.storitve.anotacije.BeleziKlice;
import si.fri.prpo.lokacijskiopomniki.storitve.UporabnikZrno;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@ApplicationScoped
@Path("uporabniki")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class UporabnikVir {

    @Inject
    private UporabnikZrno uporabnikZrno;

    @GET
    public Response pridobiUporabnike(){
        return Response.ok(uporabnikZrno.getUporabniki()).build();
    }

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

    @POST
    @BeleziKlice
    public Response dodajUporabnika(Uporabnik u){

        return Response
                .status(Response.Status.CREATED)
                .entity(uporabnikZrno.addUporabnik(u))
                .build();
    }

    @PUT
    @Path("{id}")
    public Response posodobiUporabnika(@PathParam("id") Integer id, Uporabnik u) {
        return Response
                .status(Response.Status.CREATED)
                .entity(uporabnikZrno.updateUporabnik(id,u))
                .build();
    }


    @DELETE
    @Path("{id}")
    public Response odstraniUporabnika(@PathParam("id") Integer id) {
        return Response
                .status(Response.Status.OK)
                .entity(uporabnikZrno.deleteUporabnik(id))
                .build();
    }
}
