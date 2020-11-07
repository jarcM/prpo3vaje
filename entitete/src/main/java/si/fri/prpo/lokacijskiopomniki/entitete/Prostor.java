package si.fri.prpo.lokacijskiopomniki.entitete;

import org.eclipse.persistence.jpa.jpql.parser.DateTime;

import javax.persistence.*;


@Entity
@Table(name="prostor")
@NamedQueries(value =
        {
                @NamedQuery(name = "Prehodi.getAll", query = "SELECT o FROM Prostor o"),
                @NamedQuery(name = "Prehodi.getByIdProstora", query = "SELECT o FROM Prostor o")
        })
public class Prostor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO.IDENTITY)
    @Column(name = "id_prostora")
    private Integer idprostora;
    private Integer trenutnaZasedenost;
    private Integer dovoljenoStObiskovalcev;

    // @OneToMany(mappedBy = "uporabnik", cascade = CascadeType.ALL)

    public Integer getidprostora(){return idprostora;}

    public void setidVhoda(Integer idprostora){this.idprostora=idprostora;}

    public Integer getTrenutnaZasedenost(){return trenutnaZasedenost;}

    public void setTrenutnaZasedenost(Integer trenutnaZasedenost){this.trenutnaZasedenost=trenutnaZasedenost;}

    public Integer DovoljenoStObiskovalcev(){return dovoljenoStObiskovalcev;}

    public void setDovoljenoStObiskovalce(Integer dovoljenoStObiskovalcev){this.dovoljenoStObiskovalcev=dovoljenoStObiskovalcev;}



}