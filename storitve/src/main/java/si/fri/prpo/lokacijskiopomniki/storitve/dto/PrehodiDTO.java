package si.fri.prpo.lokacijskiopomniki.storitve.dto;

public class PrehodiDTO{
    private Integer uporabnikId;
    private Integer idVhoda;
    private Integer idIzhoda;
    private Integer prehodProstor;
    private String casVstopa;
    private String casIzstopa;

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

    public String getcasIzstopa(){
        return casIzstopa;
    }
    public void setcasIzstopa(String casIzstopa){
        this.casIzstopa = casIzstopa;
    }

    public Integer getidIzhoda(){
        return idIzhoda;
    }
    public void setidIzhoda(Integer idIzhoda){
        this.idIzhoda=idIzhoda;
    }

    public String getcasVstopa(){
        return casVstopa;
    }
    public void setcasVstopa(String casVstopa){
        this.casVstopa = casVstopa;
    }

}