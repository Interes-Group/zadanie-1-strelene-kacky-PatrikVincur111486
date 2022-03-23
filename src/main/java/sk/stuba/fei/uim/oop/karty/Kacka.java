package sk.stuba.fei.uim.oop.karty;

import sk.stuba.fei.uim.oop.hra.Hrac;

import java.util.ArrayList;

public class Kacka extends Karta {
    protected int indexHraca;
    private boolean jeZamierena;

    public Kacka(int indexHraca) {
        this.indexHraca = indexHraca;
    }

    public int getIndexHraca() {
        return indexHraca;
    }

    @Override
    public void zahrajKartu(boolean[] zamierene, ArrayList<Karta> rybnik, ArrayList<Hrac> poleHracov, ArrayList<Karta> balikKarietRybnik) {

    }
}
