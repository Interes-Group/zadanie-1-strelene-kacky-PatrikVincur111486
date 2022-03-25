package sk.stuba.fei.uim.oop.karty.akcneKarty;

import sk.stuba.fei.uim.oop.hra.Hrac;
import sk.stuba.fei.uim.oop.karty.Kacka;
import sk.stuba.fei.uim.oop.karty.Karta;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;

public class DivokyBill extends Karta {

    public DivokyBill(String nazovKarty) {
        super(nazovKarty);
    }

    @Override
    public void zahrajKartu(int hracNaRade, int zvolenaKarta, boolean[] zamierene, ArrayList<Karta> rybnik, ArrayList<Hrac> poleHracov, ArrayList<Karta> balikKarietRybnik, ArrayList<Karta> balikAkcnychKariet) {
        int indexVystrelenia = ZKlavesnice.readInt("Zadaj číslo v rybníku, na ktoré chceš vystreliť");
        while(indexVystrelenia <0 || indexVystrelenia >5){
            indexVystrelenia = ZKlavesnice.readInt("Zadal si zlé číslo,zadaj nové číslo (0-5)");
        }
        if(rybnik.get(indexVystrelenia) instanceof Kacka) {
            int indexZasiahnutehoHraca =((Kacka) rybnik.get(indexVystrelenia)).getIndexHraca();
            poleHracov.get(indexZasiahnutehoHraca).zastrelKacku();
            System.out.println("Zastrelil si kačku hráča č."+ indexZasiahnutehoHraca);
            rybnik.remove(indexVystrelenia);
            rybnik.add(balikKarietRybnik.get(0));
            balikKarietRybnik.remove(0);
        }
        else{
            System.out.println("Trafil si vodu");
        }
        balikAkcnychKariet.add(poleHracov.get(hracNaRade).getKarty().get(zvolenaKarta));
        poleHracov.get(hracNaRade).getKarty().remove(zvolenaKarta);
        zamierene[indexVystrelenia]=false;
    }
}
