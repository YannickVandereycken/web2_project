package domain.model;

public class Film {
    private int id, speelduur, jaar;
    private String titel;
    private double rating;

    public Film(String titel, int speelduur, int jaar, double rating) {
        setTitel(titel);
        setSpeelduur(speelduur);
        setJaar(jaar);
        setRating(rating);
    }

    public Film() {
    }

    public String getTitel() {
        return titel;
    }

    public int getSpeelduur() {
        return speelduur;
    }

    public int getJaar() {
        return jaar;
    }

    public double getRating() {
        return rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitel(String titel) {
        if (titel == null || titel.isBlank()) throw new IllegalArgumentException("Titel mag niet leeg zijn");
        this.titel = titel;
    }

    public void setSpeelduur(int speelduur) {
        if (speelduur <= 0) throw new IllegalArgumentException("Speelduur moet positief zijn");
        this.speelduur = speelduur;
    }

    public void setJaar(int jaar) {
        if (jaar < 1870) throw new IllegalArgumentException("Releasejaar moet na 1870 zijn");
        this.jaar = jaar;
    }

    public void setRating(double rating) {
        if (rating < 0 || rating > 10) throw new IllegalArgumentException("Rating moet tussen 0 en 10 zijn");
        this.rating = rating;
    }

    public String getSpeelduurHours() {
        return speelduur / 60 + "u " + speelduur % 60 + "m";
    }
}
