package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;

public class Meny {
    private Tekstgrensesnitt tekstgr;
    private FilmarkivADT filmarkiv;
    public Meny(FilmarkivADT filmarkiv){
        tekstgr = new Tekstgrensesnitt();
        this.filmarkiv = filmarkiv;
    }
    public void start(){
    // legg inn en del forhåndsdefinerte filmer for å teste metodene
    // ..
    boolean endProgram = false;
    while (!endProgram){
        System.out.println("*************************************************");
        System.out.println("Film arkiv:");
        int metode = tekstgr.velgMetode();
        switch (metode){
            case 1:
                Film nyFilm = tekstgr.lesFilm();
                if(nyFilm != null){
                    filmarkiv.leggTilFilm(nyFilm);
                }
                break;
            case 2:
                tekstgr.skrivUtFilmDelstrengITittel(filmarkiv, tekstgr.inputTittelDelstreng());
                break;
            case 3:
                tekstgr.skrivUtFilmProdusent(filmarkiv, tekstgr.inputProdusentDelstreng());
                break;
            case 4:
                tekstgr.skrivUtStatistikk(filmarkiv);
                break;
            case 5:
                endProgram =  true;
                break;
            case -1:
                System.out.println("Feil tall");
                break;
        }
    }

    }
}
