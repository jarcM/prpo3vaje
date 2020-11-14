package servleti;

import si.fri.prpo.lokacijskiopomniki.storitve.PrehodiZrno;
import si.fri.prpo.lokacijskiopomniki.storitve.UporabnikZrno;

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

    private Logger log=Logger.getLogger(JPAServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter pw=resp.getWriter();
        pw.append("<br>List Uporabnikov<br>");
        uporabnikZrno.getUporabniki().forEach(o-> pw.append(String.valueOf(o.getId())).append(o.getIme()).append("<br>"));
        pw.append(uporabnikZrno.pridobiUporabnika(1).getIme());
        prehodiZrno.getPrehod().forEach(o-> pw.append(String.valueOf(o.getIdPrehoda())).append(o.getUporabnikId().getIme()).append(o.getProstorId().getTrenutnaZasedenost().toString()).append("<br>"));
        log(String.valueOf(uporabnikZrno.getUporabniki()));


    }
}