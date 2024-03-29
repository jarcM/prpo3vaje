package si.fri.prpo.lokacijskiopomniki.storitve;

import si.fri.prpo.lokacijskiopomniki.entitete.Uporabnik;
import si.fri.prpo.lokacijskiopomniki.storitve.anotacije.BeleziKlice;
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
public class UporabnikZrno {
    private Logger log=Logger.getLogger(UporabnikZrno.class.getName());
    @PersistenceContext(unitName = "lokacijski-opomniki-jpa")
    private EntityManager em;

    private void init(){
        log.info("Inicializacija zrna" + UporabnikZrno.class.getSimpleName());
    }
    private void destroy(){
        log.info("Delecija Zrna" + UporabnikZrno.class.getSimpleName());
    }

    public List<Uporabnik> getUporabniki() {
        return (List<Uporabnik>)em.createNamedQuery("Uporabnik.getAll").getResultList();
    }
    public Uporabnik pridobiUporabnika(int idOsebe) {
        return em.find(Uporabnik.class,idOsebe);
    }

    public List<Uporabnik> pridobiUporabnikeCriteriaAPI(){
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder() ;
        CriteriaQuery<Uporabnik> query= criteriaBuilder.createQuery(Uporabnik.class);
        Root<Uporabnik> from =query.from(Uporabnik.class);
        query.select(from);
        return em.createQuery(query).getResultList();
    }

    //Create update read delete
    @Transactional
    @BeleziKlice
    public Uporabnik addUporabnik(Uporabnik uporabnik){
        if(uporabnik!=null) {
            em.persist(uporabnik);
        }
        return uporabnik;
    }
    @Transactional
    public Uporabnik updateUporabnik(int idOsebe,Uporabnik uporabnik){
        Uporabnik asd=em.find(Uporabnik.class,idOsebe);
        uporabnik.setId(asd.getId());
        em.merge(uporabnik);
        return em.find(Uporabnik.class,idOsebe);
    }

    @Transactional
    public boolean deleteUporabnik(int idOsebe){
        Uporabnik asd=em.find(Uporabnik.class,idOsebe);
        if(asd!=null){
            em.remove(asd);
            return true;
        }
        return false;
    }
    public List<Uporabnik> getUporabniki(QueryParameters query) {
        return JPAUtils.queryEntities(em, Uporabnik.class, query);
    }

    public Long getUporabnikiCount(QueryParameters query) {
        return JPAUtils.queryEntitiesCount(em, Uporabnik.class, query);
    }



}


