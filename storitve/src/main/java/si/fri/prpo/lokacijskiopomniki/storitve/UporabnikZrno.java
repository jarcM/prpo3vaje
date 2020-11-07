package si.fri.prpo.lokacijskiopomniki.storitve;

import si.fri.prpo.lokacijskiopomniki.entitete.Uporabnik;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@ApplicationScoped
public class UporabnikZrno {
    @PersistenceContext(unitName = "lokacijski-opomniki-jpa")
    private Logger log=Logger.getLogger(UporabnikZrno.class.getName());
    private static EntityManager em;

    public static List<Uporabnik> getUporabniki() {

        return (List<Uporabnik>) em.createNamedQuery("Uporabnik.getAll").getResultList();
    }
}


