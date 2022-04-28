package domain.db;

import domain.model.Film;

import java.util.ArrayList;

public class FilmDB {
    private int sequence;
    private ArrayList<Film> filmlist;

    public FilmDB() {
        this.sequence = 0;
        filmlist = new ArrayList<>();
        Film dune = new Film("Dune", 155, 2021, 9);
        Film inception = new Film("Inception", 148, 2010, 9.5);
        Film tenet = new Film("Tenet", 150, 2021, 10);
        Film lotr1 = new Film("The Lord of the Rings: The Fellowship of the Ring", 178, 2001, 8.5);
        this.add(dune);
        this.add(inception);
        this.add(tenet);
        this.add(lotr1);
    }

    public ArrayList<Film> getFilmList() {
        return filmlist;
    }

    public void add(Film film) {
        for (Film f : filmlist) {
            if (f.getTitel().equalsIgnoreCase(film.getTitel())) {
                throw new IllegalArgumentException("Film is al in lijst");
            }
        }
        this.sequence++;
        film.setId(sequence);
        this.filmlist.add(film);
    }

    public void wijzigFilm(Film film, int id) {
        Film wijzig = vindId(id);
        wijzig.setTitel(film.getTitel());
        wijzig.setSpeelduur(film.getSpeelduur());
        wijzig.setJaar(film.getJaar());
        wijzig.setRating(film.getRating());
    }

    public Film vindFilm(String titel) {
        if (titel == null || titel.isBlank()) throw new IllegalArgumentException("film mag niet leeg zijn");
        for (Film f : filmlist) {
            if (f.getTitel().equalsIgnoreCase(titel)) {
                return f;
            }
        }
        return null;
    }

    public Film vindId(int id) {
        //if (id < 0) throw new IllegalArgumentException("id mag niet negatief zijn");
        for (Film f : this.filmlist) {
            if (f.getId()==id) {
                return f;
            }
        }
        return null;
    }
    public void verwijderFilm(Film film) {
        if (film == null) throw new IllegalArgumentException("film mag niet leeg zijn");
        filmlist.remove(film);
    }

    public int gemiddeldeSpeelduur() {
        int totaal = 0;
        int aantal = 0;
        for (Film f : filmlist) {
            if (f != null) {
                totaal += f.getSpeelduur();
                aantal++;
            }
        }
        return totaal / aantal;
    }

    public double gemiddeldeRating() {
        double totaal = 0;
        int aantal = 0;
        for (Film f : filmlist) {
            if (f != null) {
                totaal += f.getRating();
                aantal++;
            }
        }
        return totaal / aantal;
    }

    public Film MaxSpeelduur() {
        Film max = new Film("max", 1, 1985, 0);
        for (Film f : filmlist) {
            if (f != null) {
                if (f.getSpeelduur() > max.getSpeelduur()) {
                    max = f;
                }
            }
        }
        return max;
    }

    public Film MaxRating() {
        Film max = new Film("max", 1, 1985, 0);
        for (Film f : filmlist) {
            if (f != null) {
                if (f.getRating() > max.getRating()) {
                    max = f;
                }
            }
        }
        return max;
    }
}
