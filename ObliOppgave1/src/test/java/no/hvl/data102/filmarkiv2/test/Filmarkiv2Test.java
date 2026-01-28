package test.java.no.hvl.data102.filmarkiv2.test;

import no.hvl.data102.filmarkiv.impl.Filmarkiv2;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Sjanger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Filmarkiv2Test {
    private FilmarkivADT arkiv;
    private Film film1;
    private Film film2;
    private Film film3;

    @BeforeEach
    void setup(){

        arkiv = new Filmarkiv2();

        film1 = new Film(1, "George Lucas", "Star Wars", Sjanger.SCIFI, "Fox");
        film2 = new Film(2, "Peter Jackson", "Ringenes Herre", Sjanger.FANTASY, "New Line");
        film3 = new Film(3, "George Lucas", "Indiana Jones", Sjanger.ACTION, "Paramount");

        arkiv.leggTilFilm(film1);
        arkiv.leggTilFilm(film2);
        arkiv.leggTilFilm(film3);

    }
    @Test
    void testLeggTilFilmOgAntall(){
        assertEquals(3, arkiv.antall());

    }
    @Test
    void testFinnFilm(){
        Film funnet = arkiv.finnFilm(2);
        assertNotNull(funnet);
        assertEquals("Ringenes Herre", funnet.getTittel());

    }
    @Test
    void testSlettFilm(){
        boolean slettet = arkiv.slettFilm(1);
        assertTrue(slettet);
        assertEquals(2, arkiv.antall());
        assertNull(arkiv.finnFilm(1));
    }
    @Test
    void testSoekTittel(){
        Film[] tabell = arkiv.soekTittel("Star");
        assertNotNull(tabell);
        assertEquals(1,tabell.length);
        assertEquals("Star Wars",tabell[0].getTittel());
    }
    @Test
    void testAntallSjanger(){
        assertEquals(1,arkiv.antall(Sjanger.SCIFI));
        assertEquals(1,arkiv.antall(Sjanger.FANTASY));
        assertEquals(1,arkiv.antall(Sjanger.ACTION));
        assertEquals(0,arkiv.antall(Sjanger.DRAMA));
    }
}
