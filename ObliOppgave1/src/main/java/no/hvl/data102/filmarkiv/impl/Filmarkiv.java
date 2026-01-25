package no.hvl.data102.filmarkiv.impl;
import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import java.util.Arrays;

public class Filmarkiv implements FilmarkivADT {

    private Film[] films;
    private int antall;

    public Filmarkiv(int plass) {
        this.films = new Film[plass];
        this.antall = 0;
    }

    @Override
    public Film finnFilm(int nummer) {
        if (antall == 0) {
            return null;
        }
        for (int i = 0; i < antall; i++) {
            if (films[i].getFilmnr() == nummer) {
                return films[i];
            }
        }
        return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        if (antall >= films.length) {
            films = Arrays.copyOf(films, antall * 2);
        }

        films[antall] = nyFilm;
        antall++;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        if (antall == 0) {
            return false;
        }
        for (int i = 0; i < antall; i++) {
            if (films[i].getFilmnr() == filmnr) {
                films[i] = films[antall - 1];
                films[antall - 1] = null;
                antall--;
                return true;
            }
        }

        return false;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        Film[] soekFilm = new Film[antall];
        int soekAntall = 0;

        for (int i = 0; i < antall; i++) {
            String film = films[i].getTittel().toUpperCase();
            if (film.contains(delstreng.toUpperCase())) {
                soekFilm[soekAntall] = films[i];
                soekAntall++;
            }
        }

        if (soekAntall > 0) {
            return Arrays.copyOf(soekFilm, soekAntall);
        } else {
            return null;
        }

    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        Film[] soekFilm = new Film[antall];
        int soekAntall = 0;

        for (int i = 0; i < antall; i++) {
            String film = films[i].getProdusent().toUpperCase();
            if (film.contains(delstreng.toUpperCase())) {
                soekFilm[soekAntall] = films[i];
                soekAntall++;
            }
        }

        if (soekAntall > 0) {
            return Arrays.copyOf(soekFilm, soekAntall);
        } else {
            return null;
        }
    }


    @Override
    public int antall(Sjanger sjanger) {
        int soekAntall = 0;

        for (int i = 0; i < antall; i++) {
            if (films[i].getSjanger().equals(sjanger)) {
                soekAntall++;
            }
        }

        return soekAntall;
    }

    @Override
    public int antall() {
        return antall;
    }
}
