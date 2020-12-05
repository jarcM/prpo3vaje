package si.fri.prpo.lokacijskiopomniki.storitve;

import si.fri.prpo.lokacijskiopomniki.entitete.Prehodi;

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
public class PrehodiZrno {
    private Logger log=Logger.getLogger(PrehodiZrno.class.getName());
    @PersistenceContext(unitName = "lokacijski-opomniki-jpa")
    private EntityManager em;

    @PostConstruct
    private void init(){
        log.info("Inicializacija zrna" + PrehodiZrno.class.getSimpleName());
    }
    @PreDestroy
    private void destroy(){
        log.info("Delecija Zrna" + PrehodiZrno.class.getSimpleName());
    }

    public List<Prehodi> getPrehod() {
        return (List<Prehodi>)em.createNamedQuery("Prehodi.getAll").getResultList();
    }
    public Prehodi pridobiPrehod(int idPrehoda) {
        return em.find(Prehodi.class,idPrehoda);
    }
    public List<Prehodi> pridobiPrehodeCriteriaAPI(){
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Prehodi> query= criteriaBuilder.createQuery(Prehodi.class);
        Root<Prehodi> from =query.from(Prehodi.class);
        query.select(from);
        return em.createQuery(query).getResultList();
    }
    //Create update read delete
    @Transactional
    public Prehodi addPrehod(Prehodi prehod){
        if(prehod!=null){
            em.persist(prehod);
        }

        return prehod;
    }
    @Transactional
    public Prehodi updatePrehod(int idPrehoda,Prehodi prehod){
        Prehodi asd=em.find(Prehodi.class,idPrehoda);
        prehod.setIdPrehoda(asd.getIdPrehoda());
        em.merge(prehod);
        return em.find(Prehodi.class,idPrehoda);
    }

    @Transactional
    public boolean deletePrehod(int idPrehoda){
        Prehodi asd=em.find(Prehodi.class,idPrehoda);
        if(asd!=null){
            em.remove(asd);
            return true;
        }

        return false;
    }
    public List<Prehodi> getPrehod(QueryParameters query) {
        return JPAUtils.queryEntities(em, Prehodi.class, query);
    }

    public Long getPrehodCount(QueryParameters query) {
        return JPAUtils.queryEntitiesCount(em, Prehodi.class, query);
    }
}


