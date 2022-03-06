package ui.controller;

import domain.model.Film;
import domain.db.FilmDB;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/FilmServlet")
public class FilmServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        /*
        response.setContentType("text/html");
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");*/

        FilmDB db = new FilmDB();
        Film maxRating = db.MaxRating();
        Film maxSpeelduur = db.MaxSpeelduur();
        request.setAttribute("maxr", maxRating);
        request.setAttribute("maxs", maxSpeelduur);
        request.setAttribute("filmlist", db.getFilmList());
        request.getRequestDispatcher("overview.jsp").forward(request, response);
    }

    public void destroy() {
    }
}
