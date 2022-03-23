package sk.stuba.fei.uim.oop.karty;


import sk.stuba.fei.uim.oop.hra.Hrac;

import java.util.ArrayList;

public abstract class Karta {
    String nazovKarty;

    public abstract void zahrajKartu(boolean zamierene[], ArrayList<Karta> rybnik,ArrayList<Hrac> poleHracov,ArrayList<Karta> balikKarietRybnik);
    public abstract void vypisNazovKarty(boolean zamierene[], ArrayList<Karta> rybnik,ArrayList<Hrac> poleHracov,ArrayList<Karta> balikKarietRybnik);

}
