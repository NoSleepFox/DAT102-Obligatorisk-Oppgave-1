package no.hvl.data102.filmarkiv.impl;
import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT {
    private int antall;
    private LinearNode<Film> start;


    public Filmarkiv2(){
        this.antall = 0;
        this.start = null;

    }

    @Override
    public Film finnFilm(int nr){
        LinearNode<Film> aktuell = start;
        while (aktuell != null){
            if(aktuell.data.getFilmnr() == nr){
                return aktuell.data;
            }
            aktuell = aktuell.neste;
        }
        return null;
    }
    @Override
    public void leggTilFilm(Film nyFilm){
        LinearNode<Film> nyNode = new LinearNode<>(nyFilm);
        nyNode.neste = start;
        start = nyNode;
        antall++;
    }
    @Override
    public boolean slettFilm(int filmNr){
        if(start ==null) return false;
        //Hvis filmen er den første i kjeden

        if (start.data.getFilmnr()==filmNr){
            start = start.neste;
            antall--;
            return true;
        }
        LinearNode<Film> forrige = start;
        LinearNode<Film> aktuell = start.neste;

        while (aktuell !=null){
            if(aktuell.data.getFilmnr()==filmNr){
                forrige.neste = aktuell.neste;
                antall--;
                return true;
            }
            forrige = aktuell;
            aktuell = aktuell.neste;
        }
        return false;
    }
    @Override
    public Film[] soekTittel (String delstreng){
        return finnVedKriterium (f->f.getTittel().toLowerCase().contains(delstreng.toLowerCase()));
    }
    @Override
    public Film[] soekProdusent(String delstreng){
        return finnVedKriterium (f->f.getProdusent().toLowerCase().contains(delstreng.toLowerCase()));
    }
    @Override
    public int antall(Sjanger sjanger){
        int teller = 0;
        LinearNode<Film> aktuell = start;
        while (aktuell !=null){
            if(aktuell.data.getSjanger() == sjanger){
                teller++;
            }
          aktuell = aktuell.neste;
        }
        return teller;
    }

    @Override
    public int antall(){
        return antall;
    }
    private Film[] finnVedKriterium(java.util.function.Predicate<Film> kriterium){
        Film[] midlertidig = new Film[antall];
        int treffCount = 0;
        LinearNode<Film> aktuell = start;
        while (aktuell != null){
            if(kriterium.test(aktuell.data)){
                midlertidig[treffCount++]= aktuell.data;
            }
            aktuell = aktuell.neste;
        }
        return trimTab(midlertidig, treffCount);
    }
    private Film[] trimTab(Film[] tab,int n){
        Film[] nyTab = new Film[n];
        System.arraycopy(tab, 0,nyTab,0,n);
        return nyTab;
    }
}
