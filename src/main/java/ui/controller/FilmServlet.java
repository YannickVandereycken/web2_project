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
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Film maxRating = db.MaxRating();
        Film maxSpeelduur = db.MaxSpeelduur();
        request.setAttribute("maxr", maxRating);
        request.setAttribute("maxs", maxSpeelduur);
        request.setAttribute("filmlist", db.getFilmList());
        processRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page = "index.jsp";
        if (request.getParameter("page") != null) {
            page = request.getParameter("page");
        }
        String destination = "";
        switch (page) {
            case "overview":
                destination = overview(request);
                break;
            case "add":
                destination = goAdd(request);
                break;
            case "addFilm":
                destination = add(request);
                break;
            case "search":
                destination = goSearch(request);
                break;
            case "searchFilm":
                destination = search(request);
                break;
            case "confirmation":
                destination = confirmation(request);
                break;
            case "Bevestig":
                destination = delete(request);
                break;
            case "Annuleer":
                destination = index(request);
                break;
            default:
                destination = index(request);
        }
        request.getRequestDispatcher(destination).forward(request, response);
    }

    private String index(HttpServletRequest request) {
        Film maxRating = db.MaxRating();
        Film maxSpeelduur = db.MaxSpeelduur();
        request.setAttribute("maxr", maxRating);
        request.setAttribute("maxs", maxSpeelduur);
        return "index.jsp";
    }

    private String overview(HttpServletRequest request) {

        request.setAttribute("filmlist", db.getFilmList());
        return "overview.jsp";
    }

    private String goSearch(HttpServletRequest request) {
        return "search.jsp";
    }

    private String search(HttpServletRequest request) {
        String titel = request.getParameter("titel");
        request.setAttribute("result", db.vindFilm(titel));
        return "result.jsp";
    }

    private String goAdd(HttpServletRequest request) {
        return "add.jsp";
    }

    private String add(HttpServletRequest request) {
        boolean missing = false;
        if (request.getParameter("titel") == null || (request.getParameter("titel")).isBlank()) {
            missing = true;
        }
        if (request.getParameter("tijd") == null || (request.getParameter("tijd")).isBlank()) {
            missing = true;
        }
        if (request.getParameter("rating") == null || (request.getParameter("rating")).isBlank()) {
            missing = true;
        }
        if (request.getParameter("jaar") == null || (request.getParameter("jaar")).isBlank()) {
            missing = true;
        }
        if (missing) {
            request.setAttribute("error", "U vulde niet alle velden in");
            return "add.jsp";
        }
        String titel = request.getParameter("titel");
        int tijd = Integer.parseInt(request.getParameter("tijd"));
        int jaar = Integer.parseInt(request.getParameter("jaar"));
        double rating = Double.parseDouble(request.getParameter("rating"));
        db.add(new Film(titel, tijd, jaar, rating));
        return overview(request);
    }

    private String confirmation(HttpServletRequest request) {
        return "confirmation.jsp";
    }

    private String delete(HttpServletRequest request) {
        db.verwijderFilm(db.vindFilm(request.getParameter("titel")));
        return overview(request);
    }

    public void destroy() {
    }
}
