package si.fri.prpo.lokacijskiopomniki.entitete;


import org.eclipse.persistence.jpa.jpql.parser.DateTime;

import javax.persistence.*;
import java.util.*;
@Entity
@Table(name="prehodi")
@NamedQueries(value =
        {
                @NamedQuery(name = "Prehodi.getAll", query = "SELECT o FROM Prehodi o"),
                @NamedQuery(name = "Prehodi.getByUporabniskoIme", query = "SELECT o FROM Prehodi o")
        })
public class Prehodi {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO.IDENTITY)
    @Column(name = "id_vhoda")
    private Integer idVhoda;
    @Column(name = "id_izhoda")
    private Integer idIzhoda;
    private DateTime časVstopa;
    private DateTime časIzstopa;

    // @OneToMany(mappedBy = "uporabnik", cascade = CascadeType.ALL)

    public Integer getIdVhoda(){return idVhoda;}

    public void setIdVhoda(Integer id){this.idVhoda=idVhoda;}

    public Integer getIdIzhoda(){return idIzhoda;}

    public void setIdIzhodae(String ime){this.idIzhoda=idIzhoda;}

    public DateTime getČasVstopa(){return časVstopa;}

    public void setČasVstopa(DateTime časVstopa){this.časVstopa=časVstopa;}

    public DateTime getČasIzstopaa(){return časVstopa;}

    public void setČasIzstopatopa(DateTime časIzstopa){this.časVstopa=časIzstopa;}
}