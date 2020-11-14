package si.fri.prpo.lokacijskiopomniki.storitve;

import si.fri.prpo.lokacijskiopomniki.entitete.Uporabnik;

import si.fri.prpo.lokacijskiopomniki.entitete.Prehodi;
import si.fri.prpo.lokacijskiopomniki.entitete.Prostor;
import si.fri.prpo.lokacijskiopomniki.storitve.dto.UporabnikDTO;
import si.fri.prpo.lokacijskiopomniki.storitve.dto.ProstorDTO;
import si.fri.prpo.lokacijskiopomniki.storitve.dto.PrehodiDTO;
import si.fri.prpo.lokacijskiopomniki.storitve.UporabnikZrno;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class UpravljanjePrehodiZrno{
    private Logger log=Logger.getLogger(UpravljanjePrehodiZrno.class.getName());
    private String zrnoID;

    @Inject
    private ProstorZrno prostorZrno;

    @Inject
    private UporabnikZrno uporabnikiZrno;

    @Inject
    private PrehodiZrno prehodiZrno;

    @PostConstruct
    private void init(){
        log.info("Inicializacije zrna" + UpravljanjePrehodiZrno.class.getSimpleName());
    }

    @PreDestroy
    private void destroy(){
        log.info("Definicija zrna" + UpravljanjePrehodiZrno.class.getSimpleName());
    }
    @Transactional
    public Prehodi createPrehodi(PrehodiDTO prehodiDTO){
        Uporabnik uporabnik=uporabnikiZrno.pridobiUporabnika(prehodiDTO.getUporabnikId());

        if(uporabnik == null){
            log.info("Ne morem ustvariti novega prehoda. Uporabnik ne obstaja");
            return null;

        }
        Prostor prostor=prostorZrno.pridobiProstor(prehodiDTO.getProstorId());

        if(prostor == null){
            log.info("Ne morem ustvariti novega prehoda. Uporabnik ne obstaja");
            return null;

        }
        Prehodi prehodi=new Prehodi();
        prehodi.setUporabnikId(uporabnik);
        prehodi.setProstorId(prostor);
        uporabnik.getPrehodi().add(prehodi); // whyyyy
        prehodi.setIdVhoda(prehodiDTO.getidVhoda());
        prehodi.setIdIzhoda(prehodiDTO.getidIzhoda());
        prehodi.setCasIzstopa(prehodiDTO.getcasIzstopa());
        prehodi.setCasVstopa(prehodiDTO.getcasVstopa());
        return prehodi;
    }

}