package servleti;

import si.fri.prpo.lokacijskiopomniki.entitete.Uporabnik;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import si.fri.prpo.lokacijskiopomniki.storitve.UporabnikZrno;

@WebServlet("/servlet")
public class JPAServlet extends HttpServlet {

    @Inject
    private UporabnikZrno uporabnikiZrno;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Uporabnik> uporabniki = uporabnikiZrno.getUporabniki();
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter pw=resp.getWriter();

        pw.append("<br/><br/>Uporabniki:<br/>");
        uporabnikiZrno.getUporabniki().stream().forEach(u->pw.append(u.toString()+"<br/><br/>"));

    }
}