package si.fri.prpo.lokacijskiopomniki.storitve.interceptor;
import si.fri.prpo.lokacijskiopomniki.storitve.StevecZrno;
import si.fri.prpo.lokacijskiopomniki.storitve.anotacije.BeleziKlice;
import javax.inject.Inject;
import javax.interceptor.*;

@Interceptor
@BeleziKlice
public class BeleziKliceInterceptor {

    @Inject
    private StevecZrno steveczrno;

    @AroundInvoke
    public Object dobiSteviloKlicev(InvocationContext context) throws Exception{
        steveczrno.povecajStevec();
        return context.proceed();
    }

}