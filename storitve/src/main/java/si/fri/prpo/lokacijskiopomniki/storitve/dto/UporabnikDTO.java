package si.fri.prpo.lokacijskiopomniki.storitve.dto;

public class UporabnikDTO{
    private Integer uporabnikId;
    private Integer prehodiId;

    public Integer getUporabnikId(){
        return uporabnikId;
    }

    public void setUporabnikId(Integer uporabnikId){
        this.uporabnikId=uporabnikId;
    }

    public Integer getPrehodiId(){
        return prehodiId;
    }

    public void setNsID(Integer nsID){
        this.prehodiId=prehodiId;
    }
}