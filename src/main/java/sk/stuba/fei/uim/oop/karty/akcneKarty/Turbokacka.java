package sk.stuba.fei.uim.oop.karty.akcneKarty;

import sk.stuba.fei.uim.oop.hra.Hrac;
import sk.stuba.fei.uim.oop.karty.Kacka;
import sk.stuba.fei.uim.oop.karty.Karta;
import sk.stuba.fei.uim.oop.karty.Voda;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;

public class Turbokacka extends Karta {
    String nazovKarty;

    public Turbokacka() {
        this.nazovKarty = "Turbokačka";
    }
    @Override
    public void zahrajKartu(boolean[] zamierene, ArrayList<Karta> rybnik, ArrayList<Hrac> poleHracov, ArrayList<Karta> balikKarietRybnik) {
        int indexKacky = ZKlavesnice.readInt("Vyber si kačku: ");
        while ((indexKacky < 0 || indexKacky > 5) || (rybnik.get(indexKacky) instanceof Voda)) {
            indexKacky = ZKlavesnice.readInt("Zadal si zlé číslo,zadaj nové číslo (0-5)");
        }
        Kacka vybranaKacka= (Kacka) rybnik.get(indexKacky);
        rybnik.remove(indexKacky);
        rybnik.add(0,vybranaKacka);
    }
}
