package si.fri.prpo.lokacijskiopomniki.entitete;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name="uporabnik")
@NamedQueries(value =
        {
                @NamedQuery(name = "Uporabnik.getAll", query = "SELECT o FROM Uporabnik o"),
                @NamedQuery(name = "Uporabnik.getByIdUporabnika",
                        query = "SELECT o FROM Uporabnik o WHERE o.idOsebe =:idOsebe"),
                @NamedQuery(name="Prehodi.getIdVhoda",
                        query="SELECT CONCAT(\"idVhoda: \",o.idVhoda) FROM Prehodi o WHERE o.prostorId=:prostorId"),

        })

public class Uporabnik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOsebe;
    @Column(name="ime")
    private String ime;
    @Column(name="priimek")
    private String priimek;

    @OneToMany(mappedBy="uporabnikId",cascade=CascadeType.ALL)
    private List<Prehodi> prehodi;

    public Integer getId(){return idOsebe;}

    public void setId(Integer id){this.idOsebe=idOsebe;}

    public String getIme(){return ime;}

    public void setIme(String ime){this.ime=ime;}

    public String getPriimek(){return priimek;}

    public void setPriimek(String priimek){this.priimek=priimek;}

    public List<Prehodi> getPrehodi(){
        return prehodi;
    }

    public void setPrehodi(List<Prehodi> prehodi){
        this.prehodi=prehodi;}

}

