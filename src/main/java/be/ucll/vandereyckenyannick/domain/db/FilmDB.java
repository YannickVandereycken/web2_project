package be.ucll.vandereyckenyannick.domain.db;

import be.ucll.vandereyckenyannick.domain.model.Film;

import java.util.ArrayList;

public class FilmDB {
    private int sequence;
    private ArrayList<Film> filmlist;

    public ArrayList<Film> getFilmList(){
        return filmlist;
    }

    public void add(Film film){
        this.sequence++;
        film.setId(sequence);
        filmlist.add(film);
    }

    public void vervangTitel(String titel, Film film){
        for (Film f : filmlist) {
            if(f==film){
                f.setTitel(titel);
            }
        }
    }

}
