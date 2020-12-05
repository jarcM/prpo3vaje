package si.fri.prpo.lokacijskiopomniki.storitve.interceptor;
import si.fri.prpo.lokacijskiopomniki.storitve.StevecZrno;
import si.fri.prpo.lokacijskiopomniki.storitve.anotacije.BeleziKlice;
import javax.inject.Inject;
import javax.interceptor.*;
import java.util.logging.Logger;

@Interceptor
@BeleziKlice
public class BeleziKliceInterceptor {
    private final Logger log = Logger.getLogger(BeleziKliceInterceptor.class.getName());

    @Inject
    private StevecZrno steveczrno;

    @AroundInvoke
    public Object dobiSteviloKlicev(InvocationContext context) throws Exception{
        int st = steveczrno.povecajStevec();
        log.info("St klicev: " + st);
        return context.proceed();
    }

}