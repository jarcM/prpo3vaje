package si.fri.prpo.lokacijskiopomniki.storitve;

import javax.enterprise.context.ApplicationScoped;
import java.util.logging.Logger;

@ApplicationScoped
public class StevecZrno{
    private Logger log=Logger.getLogger(StevecZrno.class.getName());
    private String zrnoID;

    private static int stevec = 0;

    public int povecajStevec(){
        stevec++;
        log.info(StevecZrno.class.getSimpleName()+" Št vseh klicev: " + stevec);
        return stevec;
    }
}