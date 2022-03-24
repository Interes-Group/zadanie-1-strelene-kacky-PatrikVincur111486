package sk.stuba.fei.uim.oop.karty.akcneKarty;

import sk.stuba.fei.uim.oop.hra.Hrac;
import sk.stuba.fei.uim.oop.karty.Karta;

import java.util.ArrayList;

public class KacaciPochod extends Karta {

    public KacaciPochod(String nazovKarty) {
        super(nazovKarty);
    }
    @Override
    public void zahrajKartu(int hracNaRade, int zvolenaKarta, boolean[] zamierene, ArrayList<Karta> rybnik, ArrayList<Hrac> poleHracov, ArrayList<Karta> balikKarietRybnik) {
        Karta prvaKarta=rybnik.get(0);
        rybnik.remove(0);
        balikKarietRybnik.add(prvaKarta);
        rybnik.add(balikKarietRybnik.get(0));
        balikKarietRybnik.remove(0);
    }
}
