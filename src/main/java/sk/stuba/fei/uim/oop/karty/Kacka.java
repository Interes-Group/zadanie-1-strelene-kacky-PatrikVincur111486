package sk.stuba.fei.uim.oop.karty;

import sk.stuba.fei.uim.oop.hra.Hrac;

import java.util.ArrayList;

public class Kacka extends Karta {
    protected int indexHraca;

    public Kacka(String nazovKarty, int indexHraca) {
        super(nazovKarty);
        this.indexHraca = indexHraca;
    }

    public int getIndexHraca() {
        return indexHraca;
    }

    @Override
    public void zahrajKartu(int hracNaRade, int zvolenaKarta, boolean[] zamierene, ArrayList<Karta> rybnik, ArrayList<Hrac> poleHracov, ArrayList<Karta> balikKarietRybnik, ArrayList<Karta> balikAkcnychKariet) {

    }
}
