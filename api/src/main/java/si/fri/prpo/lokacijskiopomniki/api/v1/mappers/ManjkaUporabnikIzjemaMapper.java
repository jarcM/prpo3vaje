package si.fri.prpo.lokacijskiopomniki.api.v1.mappers;

import si.fri.prpo.lokacijskiopomniki.storitve.izjeme.ManjkaUporabnikIzjema;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ManjkaUporabnikIzjemaMapper implements ExceptionMapper<ManjkaUporabnikIzjema> {

    @Override
    public Response toResponse(ManjkaUporabnikIzjema manjkaUporabnikIzjema) {
        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity("{\"napaka\":\"" + manjkaUporabnikIzjema.getMessage() + "\"}")
                .build();
    }
}