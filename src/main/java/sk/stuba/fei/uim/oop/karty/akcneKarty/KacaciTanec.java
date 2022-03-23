package sk.stuba.fei.uim.oop.karty.akcneKarty;

import sk.stuba.fei.uim.oop.hra.Hrac;
import sk.stuba.fei.uim.oop.karty.Karta;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;
import java.util.Collections;

public class KacaciTanec extends Karta {
    String nazovKarty;

    public KacaciTanec() {
        this.nazovKarty = "Kačací Tanec";
    }
    @Override
    public void zahrajKartu(boolean[] zamierene, ArrayList<Karta> rybnik, ArrayList<Hrac> poleHracov, ArrayList<Karta> balikKarietRybnik) {
        balikKarietRybnik.addAll(rybnik);
        Collections.shuffle(balikKarietRybnik);
        rybnik.clear();
        for(int i=0;i<6;i++){
            rybnik.add(balikKarietRybnik.get(0));
        }
    }
}
