package si.fri.prpo.lokacijskiopomniki.storitve;

import si.fri.prpo.lokacijskiopomniki.entitete.Prostor;
import si.fri.prpo.lokacijskiopomniki.entitete.Uporabnik;

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

@ApplicationScoped
public class ProstorZrno {
    private Logger log=Logger.getLogger(ProstorZrno.class.getName());
    @PersistenceContext(unitName = "lokacijski-opomniki-jpa")
    private EntityManager em;

    @PostConstruct
    private void init(){
        log.info("Inicializacija zrna" + ProstorZrno.class.getSimpleName());
    }
    @PreDestroy
    private void destroy(){
        log.info("Delecija Zrna" + ProstorZrno.class.getSimpleName());
    }

    public List<Prostor> getProstor() {
        return (List<Prostor>)em.createNamedQuery("Prostor.getAll").getResultList();
    }
    public Prostor pridobiProstor(int idProstora) {
        return em.find(Prostor.class,idProstora);
    }
    public List<Prostor> pridobiProstoreCriteriaAPI(){
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder() ;
        CriteriaQuery<Prostor> query= criteriaBuilder.createQuery(Prostor.class);
        Root<Prostor> from =query.from(Prostor.class);
        query.select(from);
        return em.createQuery(query).getResultList();
    }
    //Create update read delete
    @Transactional
    public Prostor addProstor(Prostor prostor){
        if(prostor!=null){
            em.persist(prostor);
        }
        return prostor;
    }
    @Transactional
    public Prostor updateProstor(int idOsebe,Prostor prostor){
        Prostor p=em.find(Prostor.class,idOsebe);
        prostor.setidProstora(p.getIdProstora());
        em.merge(prostor);
        return em.find(Prostor.class,id);
    }

    @Transactional
    public boolean deleteProstor(int idProstora){
        Prostor p=em.find(Prostor.class,idProstora);
        if(p!=null) {
            em.remove(p);
            return true;
        }
        return false;
    }
}


