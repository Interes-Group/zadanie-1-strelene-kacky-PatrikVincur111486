package sk.stuba.fei.uim.oop.karty.akcneKarty;

import sk.stuba.fei.uim.oop.hra.Hrac;
import sk.stuba.fei.uim.oop.karty.Karta;

import java.util.ArrayList;
import java.util.Collections;

public class Rosambo extends Karta {
    public Rosambo(String nazovKarty) {
        super(nazovKarty);
    }

    @Override
    public void zahrajKartu(int hracNaRade, int zvolenaKarta, boolean[] zamierene, ArrayList<Karta> rybnik, ArrayList<Hrac> poleHracov, ArrayList<Karta> balikKarietRybnik, ArrayList<Karta> balikAkcnychKariet) {
        Collections.shuffle(rybnik);
        balikAkcnychKariet.add(poleHracov.get(hracNaRade).getKarty().get(zvolenaKarta));
        poleHracov.get(hracNaRade).getKarty().remove(zvolenaKarta);
    }
}
