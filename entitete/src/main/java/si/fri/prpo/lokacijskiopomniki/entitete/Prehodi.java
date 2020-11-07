package si.fri.prpo.lokacijskiopomniki.entitete;


import org.eclipse.persistence.jpa.jpql.parser.DateTime;

import javax.persistence.*;
import java.util.*;
import java.util.Date;
@Entity
@Table(name="prehodi")
@NamedQueries(value =
        {
                @NamedQuery(name = "Prehodi.getAll", query = "SELECT o FROM Prehodi o"),
                @NamedQuery(name = "Prehodi.getByUporabniskoIme",
                        query = "SELECT o FROM Prehodi o")
        })
public class Prehodi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vhoda")
    private Integer idVhoda;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_izhoda")
    private Integer idIzhoda;
    @Column(name = "casVstopa")
    private String časVstopa;
    @Column(name = "casIzstopa")
    private String časIzstopa;
    @ManyToOne
    @JoinColumn(name="uporabnik_id")
    private Uporabnik uporabnikId;
    @ManyToOne
    @JoinColumn(name="prostor_id")
    private Prostor prostorId;

    // @OneToMany(mappedBy = "uporabnik", cascade = CascadeType.ALL)

    public Integer getIdVhoda(){return idVhoda;}

    public void setIdVhoda(Integer idVhoda){this.idVhoda=idVhoda;}

    public Integer getIdIzhoda(){return idIzhoda;}

    public void setIdIzhoda(Integer idIzhoda){this.idIzhoda=idIzhoda;}

    public String getČasVstopa(){return časVstopa;}

    public void setČasVstopa(String časVstopa){this.časVstopa=časVstopa;}

    public String getČasIzstopaa(){return časVstopa;}

    public void setČasIzstopatopa(String časIzstopa){this.časVstopa=časIzstopa;}

    public Uporabnik getUporabnikId(){return uporabnikId;}

    public void setUporabnikId(Uporabnik uporabnikId){this.uporabnikId=uporabnikId;}

    public Prostor getProstorId(){return prostorId;}

    public void setProstorId(Prostor prostorId){this.prostorId=prostorId;}
}