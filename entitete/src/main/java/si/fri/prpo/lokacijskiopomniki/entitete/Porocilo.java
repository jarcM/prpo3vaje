package si.fri.prpo.lokacijskiopomniki.entitete;


import javax.persistence.*;

@Entity
@Table(name="porocilo")
@NamedQueries(value =
        {
                @NamedQuery(name = "Prehodi.getAll", query = "SELECT o FROM Prehodi o"),
//                @NamedQuery(name = "Prehodi.getByUporabniskoIme",
//                        query = "SELECT o FROM Prehodi o")
        })
public class Porocilo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPrehoda;
    @Column(name = "id_vhoda")
    private Integer idVhoda;
    @Column(name = "id_izhoda")
    private Integer idIzhoda;
    @Column(name = "casVstopa")
    private String casVstopa;
    @Column(name = "casIzstopa")
    private String casIzstopa;
    @ManyToOne
    @JoinColumn(name="uporabnik_id")
    private Uporabnik uporabnikId;
    @ManyToOne
    @JoinColumn(name="prostor_id")
    private Prostor prostorId;

    public Integer getIdPrehoda(){return idPrehoda;}

    public void setIdPrehoda(Integer idPrehoda){this.idPrehoda=idPrehoda;}

    public Integer getIdVhoda(){return idVhoda;}

    public void setIdVhoda(Integer idVhoda){this.idVhoda=idVhoda;}

    public Integer getIdIzhoda(){return idIzhoda;}

    public void setIdIzhoda(Integer idIzhoda){this.idIzhoda=idIzhoda;}

    public String getCasVstopa(){return casVstopa;}

    public void setCasVstopa(String casVstopa){this.casVstopa = casVstopa;}

    public String getCasIzstopa(){return casVstopa;}

    public void setCasIzstopa(String casIzstopa){this.casVstopa = casIzstopa;}

    public Uporabnik getUporabnikId(){return uporabnikId;}

    public void setUporabnikId(Uporabnik uporabnikId){this.uporabnikId=uporabnikId;}

    public Prostor getProstorId(){return prostorId;}

    public void setProstorId(Prostor prostorId){this.prostorId=prostorId;}
}