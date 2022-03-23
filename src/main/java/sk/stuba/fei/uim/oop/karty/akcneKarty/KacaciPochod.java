package sk.stuba.fei.uim.oop.karty.akcneKarty;

import sk.stuba.fei.uim.oop.hra.Hrac;
import sk.stuba.fei.uim.oop.karty.Karta;

import java.util.ArrayList;

public class KacaciPochod extends Karta {
    String nazovKarty;

    public KacaciPochod() {
        this.nazovKarty = "Kačací pochod";
    }

    @Override
    public void zahrajKartu(boolean[] zamierene, ArrayList<Karta> rybnik, ArrayList<Hrac> poleHracov, ArrayList<Karta> balikKarietRybnik) {
        Karta prvaKarta=rybnik.get(0);
        rybnik.remove(0);
        balikKarietRybnik.add(prvaKarta);
        rybnik.add(balikKarietRybnik.get(0));
        balikKarietRybnik.remove(0);
    }
}
