package be.ucll.vandereyckenyannick.domain.model;

public class Film {
    private String titel;
    private int speelduur;
    private double rating;
    public Film(){

    }

    public Film(String titel, int speelduur, double rating){
        this.titel=titel;
        this.speelduur=speelduur;
        this.rating=rating;
    }

    public String getTitel() {
        return titel;
    }

    public int getSpeelduur() {
        return speelduur;
    }

    public double getRating() {
        return rating;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }
}
