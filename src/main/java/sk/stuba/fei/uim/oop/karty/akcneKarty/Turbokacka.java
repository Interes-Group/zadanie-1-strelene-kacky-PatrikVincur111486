package sk.stuba.fei.uim.oop.karty.akcneKarty;

import sk.stuba.fei.uim.oop.hra.Hrac;
import sk.stuba.fei.uim.oop.karty.Kacka;
import sk.stuba.fei.uim.oop.karty.Karta;
import sk.stuba.fei.uim.oop.karty.Voda;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;

public class Turbokacka extends Karta {
    public Turbokacka(String nazovKarty) {
        super(nazovKarty);
    }

    @Override
    public void zahrajKartu(int hracNaRade, int zvolenaKarta, boolean[] zamierene, ArrayList<Karta> rybnik, ArrayList<Hrac> poleHracov, ArrayList<Karta> balikKarietRybnik) {
        int indexVRybniku = ZKlavesnice.readInt("Vyber si kačku: ");
        while ((indexVRybniku < 0 || indexVRybniku > 5) || (rybnik.get(indexVRybniku) instanceof Voda)) {
            indexVRybniku = ZKlavesnice.readInt("Zadal si zlé číslo,zadaj nové číslo (0-5)");
        }
        Kacka vybranaKacka= (Kacka) rybnik.get(indexVRybniku);
        rybnik.remove(indexVRybniku);
        rybnik.add(0,vybranaKacka);
        poleHracov.get(hracNaRade).getKarty().remove(zvolenaKarta);
    }
}
