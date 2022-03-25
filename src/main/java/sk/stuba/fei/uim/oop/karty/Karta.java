package sk.stuba.fei.uim.oop.karty;


import sk.stuba.fei.uim.oop.hra.Hrac;

import java.util.ArrayList;

public abstract class Karta {
    protected String nazovKarty;

    public Karta(String nazovKarty) {
        this.nazovKarty = nazovKarty;
    }

    public String vratNazovKarty() {
        return nazovKarty;
    }

    public abstract void zahrajKartu(int hracNaRade,int zvolenaKarta, boolean zamierene[], ArrayList<Karta> rybnik, ArrayList<Hrac> poleHracov, ArrayList<Karta> balikKarietRybnik,ArrayList<Karta> balikAkcnychKariet);

}
