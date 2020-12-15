package si.fri.prpo.lokacijskiopomniki.api.v1;

import javax.annotation.PostConstruct;
import java.lang.annotation.Repeatable;
import java.util.logging.Logger;
import javax.ws.rs.core.Response;
import java.util.*;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("porocila")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class PorociloVir {
    private HashMap<Integer,Integer> porocila=new LinkedHashMap<>();
    private Logger log=Logger.getLogger(PorociloVir.class.getName());

    @PostConstruct
    public void init(){
        log.info("Dodajanje Porocila");

    }
    @GET
    public Response getPorocilo(){
        return Response.ok(
        porocila
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue, (e1,e2) -> e1,LinkedHashMap::new)).keySet())
        .build();
    }
    @POST
    public Response dodajPorocilo(Integer integer){
        log.info("Prostor 2");
        return Response.ok().build();
    }
}
