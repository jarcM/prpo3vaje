package si.fri.prpo.lokacijskiopomniki.storitve.izjeme;

public class ManjkaUporabnikIzjema extends RuntimeException {
    public ManjkaUporabnikIzjema(String msg) {
        super(msg);
    }
}