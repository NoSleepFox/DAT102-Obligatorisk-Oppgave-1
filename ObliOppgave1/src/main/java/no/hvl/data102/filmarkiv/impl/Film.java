package no.hvl.data102.filmarkiv.impl;

public class Film {
    private int filmnr;
    private String produsent;
    private String tittel;
    private Sjanger sjanger;
    private String filmselskap;

    public Film() {

    }

    public Film(int filmnr, String produsent, String tittel, Sjanger sjanger, String filmselskap) {
        this.filmnr = filmnr;
        this.produsent = produsent;
        this.tittel = tittel;
        this.sjanger = sjanger;
        this.filmselskap = filmselskap;
    }

    public int getFilmnr() {
        return filmnr;
    }

    public Sjanger getSjanger() {
        return sjanger;
    }

    public String getFilmselskap() {
        return filmselskap;
    }

    public String getProdusent() {
        return produsent;
    }

    public String getTittel() {
        return tittel;
    }

    public void setFilmnr(int filmnr) {
        this.filmnr = filmnr;
    }

    public void setFilmselskap(String filmselskap) {
        this.filmselskap = filmselskap;
    }

    public void setProdusent(String produsent) {
        this.produsent = produsent;
    }

    public void setSjanger(Sjanger sjanger) {
        this.sjanger = sjanger;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Film film = (Film) obj;

        if (film.getFilmnr() != this.filmnr) {
            return false;
        }
        if (film.getFilmselskap() != this.filmselskap) {
            return false;
        }
        if (film.getProdusent() != this.produsent) {
            return false;
        }
        if (film.getTittel() != this.tittel) {
            return false;
        }
        if (film.getSjanger() != this.sjanger) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(filmnr);
    }

}
