package domain.db;

import domain.model.Film;

import java.util.ArrayList;

public class FilmDB {
    private int sequence = 0;
    private ArrayList<Film> filmlist;

    //add findfilm
    //add removefilm

    public FilmDB() {
        filmlist = new ArrayList<>();
        Film dune = new Film("Dune", 155, 2021, 9);
        Film inception = new Film("Inception", 148, 2010, 9.5);
        Film tenet = new Film("Tenet", 150, 2021, 10);
        Film lotr1 = new Film("The Lord of the Rings: The Fellowship of the Ring", 178, 2001, 8);
        filmlist.add(dune);
        filmlist.add(inception);
        filmlist.add(tenet);
        filmlist.add(lotr1);
    }

    public ArrayList<Film> getFilmList() {
        return filmlist;
    }

    public void add(Film film) {
        for (Film f : filmlist) {
            if (f.getTitel().equals(film.getTitel())) {
                throw new IllegalArgumentException("Film is al in lijst");
            }
        }
        this.sequence++;
        film.setId(sequence);
        filmlist.add(film);
    }

    public void vervangTitel(String titel, Film film) {
        for (Film f : filmlist) {
            if (f.getTitel().equals(film.getTitel())) {
                f.setTitel(titel);
            }
        }
    }

    public Film vindFilm(Film film) {
        if (film == null) throw new IllegalArgumentException("film mag niet leeg zijn");
        for (Film f : filmlist) {
            if (f.getTitel().equals(film.getTitel())) {
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
        Film max = new Film("max", 0, 0, 0);
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
        Film max = new Film("max", 0, 0, 0);
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
