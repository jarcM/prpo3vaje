package si.fri.prpo.lokacijskiopomniki.storitve.dto;

public class PorociloDTO {
    private Integer prostorId;
    private String casVstopa;
    private String casIzstopa;

    public Integer getProstorId(){
        return prostorId;
    }
    public void setProstorId(Integer prostorId){
        this.prostorId=prostorId;
    }
    public String getcasIzstopa(){
        return casIzstopa;
    }
    public void setcasIzstopa(String casIzstopa){
        this.casIzstopa = casIzstopa;
    }
    public String getcasVstopa(){
        return casVstopa;
    }
    public void setcasVstopa(String casVstopa){
        this.casVstopa = casVstopa;
    }

}

