package si.fri.prpo.lokacijskiopomniki.storitve.interceptorji;
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
    public void dobiSteviloKlicev(){
        steveczrno.povecajStevec();
    }

}