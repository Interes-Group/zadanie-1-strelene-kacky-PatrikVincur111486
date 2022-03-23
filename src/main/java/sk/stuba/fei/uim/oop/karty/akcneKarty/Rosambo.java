package sk.stuba.fei.uim.oop.karty.akcneKarty;

import sk.stuba.fei.uim.oop.hra.Hrac;
import sk.stuba.fei.uim.oop.karty.Karta;

import java.util.ArrayList;
import java.util.Collections;

public class Rosambo extends Karta {
    String nazovKarty;

    public Rosambo() {
        this.nazovKarty = "Rošambo";
    }
    @Override
    public void zahrajKartu(boolean[] zamierene, ArrayList<Karta> rybnik, ArrayList<Hrac> poleHracov, ArrayList<Karta> balikKarietRybnik) {
        Collections.shuffle(rybnik);
    }
}
