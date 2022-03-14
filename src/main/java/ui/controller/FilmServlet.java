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
    FilmDB db = new FilmDB();

    public void init() {
        //request.setAttribute("empty", false);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Film maxRating = db.MaxRating();
        Film maxSpeelduur = db.MaxSpeelduur();
        request.setAttribute("maxr", maxRating);
        request.setAttribute("maxs", maxSpeelduur);
        request.setAttribute("filmlist", db.getFilmList());
        request.getRequestDispatcher("overview.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean missing=false;
        if (request.getParameter("titel") == null || (request.getParameter("titel")).isBlank()) {
            missing=true;
        }
        if (request.getParameter("tijd") == null || (request.getParameter("tijd")).isBlank()) {
            missing=true;
        }
        if (request.getParameter("rating") == null || (request.getParameter("rating")).isBlank()) {
            missing=true;
        }
        if (request.getParameter("jaar") == null || (request.getParameter("jaar")).isBlank()) {
            missing=true;
        }
        if(missing){
            request.setAttribute("empty", "U vulde niet alle velden in");
            request.getRequestDispatcher("add.jsp").forward(request, response);
        }
        String titel = request.getParameter("titel");
        int tijd = Integer.parseInt(request.getParameter("tijd"));
        int jaar = Integer.parseInt(request.getParameter("jaar"));
        double rating = Integer.parseInt(request.getParameter("rating"));
        db.add(new Film(titel, tijd, jaar, rating));
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
