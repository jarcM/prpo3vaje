package si.fri.prpo.lokacijskiopomniki.storitve.interceptor;
import si.fri.prpo.lokacijskiopomniki.storitve.StevecZrno;
import si.fri.prpo.lokacijskiopomniki.storitve.anotacije.BeleziKlice;
import javax.inject.Inject;
import javax.interceptor.*;
import java.util.logging.Logger;

@Interceptor
@BeleziKlice
public class BeleziKliceInterceptor {

    @Inject
    private StevecZrno steveczrno;

    @AroundInvoke
    public Object dobiSteviloKlicev(InvocationContext context) throws Exception{
        int stejKlice=steveczrno.povecajStevec();
        log.info(stejKlice);
        return context.proceed();
    }

}