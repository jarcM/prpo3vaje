package si.fri.prpo.lokacijskiopomniki.entitete;

import javax.persistence.*;
@Entity
@Table(name="uporabnik")
@NamedQueries(value =
        {
                @NamedQuery(name = "Uporabnik.getAll", query = "SELECT o FROM Uporabnik o"),
                @NamedQuery(name = "Uporabnik.getByUporabniskoIme", query = "SELECT o FROM Uporabnik o")
        })
public class Uporabnik {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO.IDENTITY)
    @Column(name = "id_osebe")
    private Integer idOsebe;
    private String ime;
    private String priimek;


   // @OneToMany(mappedBy = "uporabnik", cascade = CascadeType.ALL)

    public Integer getId(){return idOsebe;}

    public void setId(Integer id){this.idOsebe=idOsebe;}

    public String getIme(){return ime;}

    public void setIme(String ime){this.ime=ime;}

    public String getPriimek(){return priimek;}

    public void setPriimek(String priimek){this.priimek=priimek;}


}
