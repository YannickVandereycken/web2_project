package domain.model;

public class Film {
    private int id, speelduur, jaar;
    private String titel;
    private double rating;

    public Film(String titel, int speelduur, int jaar, double rating) {
        if (titel == null || titel.isBlank()) throw new IllegalArgumentException("Titel mag niet leeg zijn");
        this.titel = titel;
        if (speelduur <= 0) throw new IllegalArgumentException("Speelduur moet positief zijn");
        this.speelduur = speelduur;
        if (jaar < 1985) throw new IllegalArgumentException("Releasejaar moet na 1985 zijn");
        this.jaar = jaar;
        if (rating < 0 || rating > 10) throw new IllegalArgumentException("Rating moet tussen 0 en 10 zijn");
        this.rating = rating;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getSpeelduurHours() {
        return speelduur / 60 + "u " + speelduur % 60 + "m";
    }
}
