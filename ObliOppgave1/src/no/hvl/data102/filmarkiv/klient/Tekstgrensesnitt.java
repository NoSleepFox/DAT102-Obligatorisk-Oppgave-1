package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

import java.util.Scanner;

public class Tekstgrensesnitt {

    private Scanner input = new Scanner(System.in);

    // Leser inn opplysninger om en film fra tastatur og returnere et Film-objekt
    public Film lesFilm(){
        String tittel;
        int filmnr;
        String produsent;
        String inputSjanger;
        String filmselskap;
        Sjanger sjanger;

        
        System.out.print("Skriv inn film tittelen: ");
        tittel = input.nextLine();

        try {
            System.out.print("Skriv inn film nummer: ");
            filmnr = input.nextInt();
            input.nextLine();
        } catch (Exception e) {
            
            return null;
        }

        System.out.print("Skriv inn film produsenten: ");
        produsent = input.nextLine();

        System.out.print("Skriv inn film sjangeren: ");
        inputSjanger = input.nextLine();

        System.out.print("Skriv inn film filmselskapet: ");
        filmselskap = input.nextLine();

        sjanger = Sjanger.finnSjanger(inputSjanger);

        if (sjanger == null) {
            return null;
        }

        return new Film(filmnr, produsent, tittel, sjanger, filmselskap);
    }
    // Skriver ut en film med alle opplysninger på skjerm (husk tekst for sjanger)
    public void skrivUtFilm(Film film) {
        System.out.println(film.toString());
        System.out.println();
    }
    // Skriver ut alle filmer med en spesiell delstreng i tittelen
    public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {
        Film[] tabFilm = arkiv.soekTittel(delstreng);
        for (Film film : tabFilm) {
            skrivUtFilm(film);
        }
    }
    public String inputTittelDelstreng() {
        System.out.print("Skriv inn tittelen: ");
        String returnString = input.nextLine();
        return returnString;
    }
    // Skriver ut alle Filmer av en produsent (produsent er delstreng)
    public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
        Film[] tabFilm = arkiv.soekProdusent(delstreng);
        for (Film film : tabFilm) {
            skrivUtFilm(film);
        }
    }
    public String inputProdusentDelstreng() {
        System.out.print("Skriv inn produsenten: ");
        String returnString = input.nextLine();
        return returnString;
    }
    // Skriver ut en enkel statistikk som inneholder antall filmer totalt
    // og hvor mange det er i hver sjanger.
    public void skrivUtStatistikk(FilmarkivADT arkiv) {
        System.out.println("Antall filmer: " + arkiv.antall());
        int antallSjaner = 0;
        for (Sjanger sjanger : Sjanger.values()) {
            antallSjaner += arkiv.antall(sjanger);
        }
        System.out.println("Antall sjangere: " + antallSjaner);
        System.out.println();
    }
    // osv ... andre metoder

    public int velgMetode() {
        int tall;

        try {
            System.out.print("Mulige metoder:\n 1) Les in film\n 2) Skriv ut film basert på tittelen\n 3) Skriv ut film basert på produsenten\n 4) Skriv ut statistikk\n 5) Exit program\nSkriv tallet på en av metodene: ");
            tall = input.nextInt();
            input.nextLine();
            System.out.println();
            
            if (tall > 5 || tall < 1) {
                return -1;
            } else {
                return tall;
            }

        } catch (Exception e) {
            return -1;
        }
    }
}
