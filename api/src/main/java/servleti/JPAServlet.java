package servleti;

import si.fri.prpo.lokacijskiopomniki.entitete.Prehodi;
import si.fri.prpo.lokacijskiopomniki.storitve.PrehodiZrno;
import si.fri.prpo.lokacijskiopomniki.storitve.UporabnikZrno;
import si.fri.prpo.lokacijskiopomniki.storitve.UpravljanjePrehodiZrno;
import si.fri.prpo.lokacijskiopomniki.storitve.dto.PrehodiDTO;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;


@WebServlet("/servlet")
public class JPAServlet extends HttpServlet {

    @Inject
    private UporabnikZrno uporabnikZrno;
    @Inject
    private PrehodiZrno prehodiZrno;
    @Inject
    private UpravljanjePrehodiZrno upravPrehod;

    private Logger log=Logger.getLogger(JPAServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter pw=resp.getWriter();
        pw.append("<br>Seznam prehodov<br>");
        PrehodiDTO newPrehod = new PrehodiDTO();
        newPrehod.setUporabnikId(1);
        newPrehod.setProstorId(1);
        newPrehod.setidVhoda(1);
        newPrehod.setidIzhoda(1);
        newPrehod.setcasVstopa("18:31");
        upravPrehod.createPrehodi(newPrehod);
//        prehodiZrno.getPrehod().forEach(o-> pw.append(String.valueOf(o.getIdPrehoda())).append("<br>"));
        prehodiZrno.getPrehod().forEach(o-> pw
                .append("idPrehoda: ").append(String.valueOf(o.getIdPrehoda())).append(" Čas Vstopa: ")
                .append(o.getCasVstopa()).append(" Ime Uporabnika: ")
                .append(o.getUporabnikId().getIme()).append(" Trenutna zasedenost: ")
                .append(o.getProstorId().getTrenutnaZasedenost().toString()).append(" Najvišja dovoljena zasedenost: ")
                .append(o.getProstorId().DovoljenoStObiskovalcev().toString()).append("<br>"));
        log(String.valueOf(uporabnikZrno.getUporabniki()));


    }
}