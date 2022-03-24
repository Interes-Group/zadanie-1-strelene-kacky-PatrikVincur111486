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
    public void zahrajKartu(int hracNaRade, int zvolenaKarta, boolean[] zamierene, ArrayList<Karta> rybnik, ArrayList<Hrac> poleHracov, ArrayList<Karta> balikKarietRybnik) {
        int indexKacky= ZKlavesnice.readInt("Zadaj číslo v rybníku, na ktoré chceš vystreliť");
        while(indexKacky<0 || indexKacky>5){
            indexKacky= ZKlavesnice.readInt("Zadal si zlé číslo,zadaj nové číslo (0-5)");
        }
        if(rybnik.get(indexKacky) instanceof Kacka) {
            int indexHraca=((Kacka) rybnik.get(indexKacky)).getIndexHraca();
            poleHracov.get(indexHraca).zastrelKacku();
            System.out.println("Zastrelil si kačku hráča č."+indexHraca+1);
            rybnik.add(balikKarietRybnik.get(0));
        }
        else{
            System.out.println("Trafil si vodu");
        }

    zamierene[indexKacky]=false;
    }
}
