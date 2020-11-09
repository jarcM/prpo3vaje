package si.fri.prpo.lokacijskiopomniki.storitve;

import si.fri.prpo.lokacijskiopomniki.entitete.Uporabnik;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.*;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class UporabnikZrno {
    @PersistenceContext(unitName = "lokacijski-opomniki-jpa")
    private Logger log=Logger.getLogger(UporabnikZrno.class.getName());
    private static EntityManager em;

    public static List<Uporabnik> getUporabniki() {

        return (List<Uporabnik>)em.createNamedQuery("Uporabnik.getAll").getResultList();
    }
}


