package sk.stuba.fei.uim.oop.karty.akcneKarty;

import sk.stuba.fei.uim.oop.hra.Hrac;
import sk.stuba.fei.uim.oop.karty.Karta;

import java.util.ArrayList;
import java.util.Collections;

public class KacaciTanec extends Karta {
    public KacaciTanec(String nazovKarty) {
        super(nazovKarty);
    }

    @Override
    public void zahrajKartu(int hracNaRade, int zvolenaKarta, boolean[] zamierene, ArrayList<Karta> rybnik, ArrayList<Hrac> poleHracov, ArrayList<Karta> balikKarietRybnik, ArrayList<Karta> balikAkcnychKariet) {
        balikKarietRybnik.addAll(rybnik);
        Collections.shuffle(balikKarietRybnik);
        rybnik.removeAll(rybnik);
        for(int i=0;i<6;i++){
            rybnik.add(balikKarietRybnik.get(0));
            balikKarietRybnik.remove(0);
        }
        balikAkcnychKariet.add(poleHracov.get(hracNaRade).getKarty().get(zvolenaKarta));
        poleHracov.get(hracNaRade).getKarty().remove(zvolenaKarta);
    }
}
