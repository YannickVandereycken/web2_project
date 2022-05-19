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
        HttpSession session = request.getSession();
        if (session.getAttribute("logbook") == null) session.setAttribute("logbook", new ArrayList<String>());
        ArrayList<String> logbook = (ArrayList<String>) session.getAttribute("logbook");
        logbook.add(page);
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
                destination = search(request, response);
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
            case "update":
                destination = goUpdate(request);
                break;
            case "updateFilm":
                destination = update(request);
                break;
            case "goLogbook":
                destination = goLogbook(request);
                break;
            case "reset":
                destination = resetLogbook(request);
                break;
            default:
                destination = index(request);
        }
        request.getRequestDispatcher(destination).forward(request, response);
    }

    private String index(HttpServletRequest request) {
        request.setAttribute("maxr", db.MaxRating());
        request.setAttribute("maxs", db.MaxSpeelduur());
        return "index.jsp";
    }

    private String overview(HttpServletRequest request) {
        request.setAttribute("filmlist", db.getFilmList());
        return "overview.jsp";
    }

    private String goSearch(HttpServletRequest request) {
        return "search.jsp";
    }

    private String search(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<String> errors = new ArrayList<String>();
        Film film = new Film();
        validateTitel(film, request, errors);
        if (errors.size() == 0) {
            try {
                request.setAttribute("result", db.vindFilm(request.getParameter("titel")));
                LastSearch(request, response, request.getParameter("titel"));
                return "result.jsp";
            } catch (IllegalArgumentException e) {
                errors.add(e.getMessage());
            }
        }
        request.setAttribute("errors", errors);
        return goSearch(request);
    }

    private String goAdd(HttpServletRequest request) {
        return "add.jsp";
    }

    private String add(HttpServletRequest request) {
        ArrayList<String> errors = new ArrayList<String>();
        Film film = new Film();
        validateTitel(film, request, errors);
        validateSpeelduur(film, request, errors);
        validateJaar(film, request, errors);
        validateRating(film, request, errors);
        if (errors.size() == 0) {
            try {
                db.add(film);
                return overview(request);
            } catch (IllegalArgumentException e) {
                errors.add(e.getMessage());
            }
        }
        request.setAttribute("errors", errors);
        return "add.jsp";
    }

    private String confirmation(HttpServletRequest request) {
        request.setAttribute("db", db);
        return "confirmation.jsp";
    }

    private String delete(HttpServletRequest request) {
        db.verwijderFilm(db.vindId(Integer.parseInt(request.getParameter("id"))));
        return overview(request);
    }

    private String goUpdate(HttpServletRequest request) {
        Film u = db.vindId(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("titelPrevious", u.getTitel());
        request.setAttribute("tijdPrevious", u.getSpeelduur());
        request.setAttribute("jaarPrevious", u.getJaar());
        request.setAttribute("ratingPrevious", u.getRating());
        request.setAttribute("id", request.getParameter("id"));
        return "update.jsp";
    }

    private String update(HttpServletRequest request) {
        ArrayList<String> errors = new ArrayList<String>();
        Film update = new Film();
        validateTitel(update, request, errors);
        validateSpeelduur(update, request, errors);
        validateJaar(update, request, errors);
        validateRating(update, request, errors);
        if (errors.size() == 0) {
            try {
                db.wijzigFilm(update, Integer.parseInt(request.getParameter("id")));
                return overview(request);
            } catch (IllegalArgumentException e) {
                errors.add(e.getMessage());
            }
        }
        request.setAttribute("errors", errors);
        return goUpdate(request);
    }

    private String goLogbook(HttpServletRequest request) {
        return "logbook.jsp";
    }

    private void validateTitel(Film film, HttpServletRequest request, ArrayList<String> errors) {
        String titel = request.getParameter("titel");
        try {
            film.setTitel(titel);
            request.setAttribute("titelPrevious", titel);
        } catch (IllegalArgumentException e) {
            errors.add(e.getMessage());
            request.setAttribute("titelError", true);
        }
    }

    private void validateSpeelduur(Film film, HttpServletRequest request, ArrayList<String> errors) {
        String tijd = request.getParameter("tijd");
        try {
            film.setSpeelduur(Integer.parseInt(tijd));
            request.setAttribute("tijdPrevious", tijd);
        } catch (IllegalArgumentException e) {
            errors.add("Speelduur moet positief zijn");
            request.setAttribute("tijdError", true);
        }
    }

    private void validateJaar(Film film, HttpServletRequest request, ArrayList<String> errors) {
        String jaar = request.getParameter("jaar");
        try {
            film.setJaar(Integer.parseInt(jaar));
            request.setAttribute("jaarPrevious", jaar);
        } catch (IllegalArgumentException e) {
            errors.add("Releasejaar moet na 1870 zijn");
            request.setAttribute("jaarError", true);
        }
    }

    private void validateRating(Film film, HttpServletRequest request, ArrayList<String> errors) {
        String rating = request.getParameter("rating");
        try {
            film.setRating(Double.parseDouble(rating));
            request.setAttribute("ratingPrevious", rating);
        } catch (IllegalArgumentException e) {
            errors.add("Rating moet tussen 0 en 10 zijn");
            request.setAttribute("ratingError", true);
        }
    }

    private void LastSearch(HttpServletRequest request, HttpServletResponse response, String lastSearchTerm) {
        Cookie c = new Cookie("lastSearch", lastSearchTerm);
        response.addCookie(c);

        if (lastSearchTerm == null || lastSearchTerm.isBlank()) {
            request.setAttribute("requestCookie", lastSearchTerm);
        }
    }

    private Cookie getCookieWithKey(HttpServletRequest request, String key) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null)
            return null;
        for (Cookie cookie : cookies
        ) {
            if (cookie.getName().equals(key))
                return cookie;
        }
        return null;
    }

    private String resetLogbook(HttpServletRequest request) {
        request.getSession().invalidate();
        return goLogbook(request);
    }

    public void destroy() {
    }
}
