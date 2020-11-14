package si.fri.prpo.lokacijskiopomniki.storitve.dto;

public class ProstorDTO{
    private Integer prostorId;
    private Integer prehodiId;

    public Integer getUporabnikId(){
        return prostorId;
    }

    public void setprostorId(Integer prostorId){
        this.prostorId=prostorId;
    }

    public Integer getPrehodiId(){
        return prehodiId;
    }

    public void setNsID(Integer nsID){
        this.prehodiId=prehodiId;
    }
}