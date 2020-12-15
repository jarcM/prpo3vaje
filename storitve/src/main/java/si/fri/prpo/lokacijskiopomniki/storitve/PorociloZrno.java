package si.fri.prpo.lokacijskiopomniki.storitve;

import si.fri.prpo.lokacijskiopomniki.entitete.Porocilo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;
import com.kumuluz.ee.rest.beans.QueryParameters;
import com.kumuluz.ee.rest.utils.JPAUtils;

@ApplicationScoped
public class PorociloZrno {
    private Logger log=Logger.getLogger(PorociloZrno.class.getName());
    @PersistenceContext(unitName = "lokacijski-opomniki-jpa")
    private EntityManager em;

    @PostConstruct
    private void init(){
        log.info("Inicializacija zrna" + PorociloZrno.class.getSimpleName());
    }
    @PreDestroy
    private void destroy(){
        log.info("Delecija Zrna" + PorociloZrno.class.getSimpleName());
    }

    public List<Porocilo> getPorocilo() {
        return (List<Porocilo>)em.createNamedQuery("Porocilo.getAll").getResultList();
    }
    public Porocilo pridobiPorocilo(int idPorocila) {
        return em.find(Porocilo.class,idPorocila);
    }
    public List<Porocilo> pridobiPrehodeCriteriaAPI(){
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Porocilo> query= criteriaBuilder.createQuery(Porocilo.class);
        Root<Porocilo> from =query.from(Porocilo.class);
        query.select(from);
        return em.createQuery(query).getResultList();
    }
    //Create update read delete
    @Transactional
    public Porocilo addPorocilo(Porocilo porocilo){
        if(porocilo!=null){
            em.persist(porocilo);
        }

        return porocilo;
    }
 
    public List<Porocilo> getPorocilo(QueryParameters query) {
        return JPAUtils.queryEntities(em, Porocilo.class, query);
    }

    public Long getPorociloCount(QueryParameters query) {
        return JPAUtils.queryEntitiesCount(em, Porocilo.class, query);
    }
}