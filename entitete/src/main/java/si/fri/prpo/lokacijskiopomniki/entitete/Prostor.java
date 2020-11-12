package si.fri.prpo.lokacijskiopomniki.entitete;

import org.eclipse.persistence.jpa.jpql.parser.DateTime;

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name="prostor")
@NamedQueries(value =
        {
                @NamedQuery(name = "Prostor.getAll", query = "SELECT o FROM Prostor o"),
               /* @NamedQuery(name = "Prehodi.getByIdProstora",
                        query = "SELECT o FROM Prostor o")*/

        })
public class Prostor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer idProstora;
    @Column(name = "trenutnaZasedenost")
    private Integer trenutnaZasedenost;
    @Column(name = "dovoljenoStObiskovalcev")
    private Integer dovoljenoStObiskovalcev;
    //@OneToMany(mappedBy = "prostor", cascade =CascadeType.ALL)
    private List<Prehodi> prehodi;

    // @OneToMany(mappedBy = "uporabnik", cascade = CascadeType.ALL)

    public Integer getIdProstora(){return idProstora;}

    public void setidProstora(Integer idprostora){this.idProstora=idProstora;}

    public Integer getTrenutnaZasedenost(){return trenutnaZasedenost;}

    public void setTrenutnaZasedenost(Integer trenutnaZasedenost){this.trenutnaZasedenost=trenutnaZasedenost;}

    public Integer DovoljenoStObiskovalcev(){return dovoljenoStObiskovalcev;}

    public void setDovoljenoStObiskovalce(Integer dovoljenoStObiskovalcev){this.dovoljenoStObiskovalcev=dovoljenoStObiskovalcev;}

    public List<Prehodi> getPrehodi(){
        return prehodi;
    }
    public void setPrehodi(List<Prehodi> nakupovalniSeznami){
        this.prehodi=prehodi;}

}