package no.hvl.data102.filmarkiv.adt;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public interface FilmarkivADT {
    /**
     * Hente en film med gitt nummer fra arkivet
     * @param nummer nummer på film som skal hentes.
     * @return film med gitt nummer. Om nummeret ikke finnes, returneres null.
     */
    Film finnFilm(int nummer);
    /**
     * Legger til en ny film.
     * @param nyFilm
     */
    void leggTilFilm(Film nyFilm);
    /**
     * Sletter en fil med gitt nr
     * @param filmnr nr på film som skal slettes
     * @return true dersom filmen ble slettet, false ellers
     */
    boolean slettFilm(int filmnr);
    /**
     * Søker og henter Filmer med en gitt delstreng i tittelen.
     * @param delstreng som må være i tittel
     * @return tabell med filmer som har delstreng i tittel
     */
    Film[] soekTittel(String delstreng);
    /**
     * Søker og henter filmer med en gitt delstreng i filmprodusent
     * @param delstreng
     * @return tabell med filmer som har delstreng i filmprodusent
     */
    Film[] soekProdusent(String delstreng);
    /**
     * Finner antall filmer med gitt sjanger
     * @param sjanger
     * @return antall filmer av gitt sjanger.
     */
    int antall(Sjanger sjanger);
    /**
     * @return antall filmer i arkivet
     */
    int antall();
}
