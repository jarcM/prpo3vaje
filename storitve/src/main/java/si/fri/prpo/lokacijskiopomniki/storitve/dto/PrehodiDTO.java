package si.fri.prpo.lokacijskiopomniki.storitve.dto;

public class PrehodiDTO{
    private Integer uporabnikId;
    private Integer idVhoda;
    private Integer prehodProstor;
    private String časVstopa;
    private String časIzstopa;

    public Integer getUporabnikId(){
        return uporabnikId;
    }
    public void setUporabnikId(Integer uporabnikId){
        this.uporabnikId=uporabnikId;
    }

    public Integer getidVhoda(){
        return idVhoda;
    }
    public void setidVhoda(Integer idVhoda){
        this.idVhoda=idVhoda;
    }

    public Integer getčasIzstopa(){
        return časIzstopa;
    }
    public void setčasIzstopa(Integer časIzstopa){
        this.časIzstopa=idIzhoda;
    }

    public Integer getidIzhoda(){
        return idIzhoda;
    }
    public void setidIzhoda(Integer idIzhoda){
        this.idIzhoda=idIzhoda;
    }

    public Integer getčasVstopa(){
        return časVstopa;
    }
    public void setčasVstopa(Integer časVstopa){
        this.časVstopa=idIzhoda;
    }

}