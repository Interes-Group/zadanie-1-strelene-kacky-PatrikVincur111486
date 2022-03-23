package sk.stuba.fei.uim.oop.karty.akcneKarty;

import sk.stuba.fei.uim.oop.hra.Hrac;
import sk.stuba.fei.uim.oop.karty.Karta;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;

public class Zamierit extends Karta{

    String nazovKarty;

    public Zamierit() {
        this.nazovKarty = "Zamieriť";
    }
    @Override
    public void zahrajKartu(boolean[] zamierene, ArrayList<Karta> rybnik, ArrayList<Hrac> poleHracov, ArrayList<Karta> balikKarietRybnik) {
        int indexKacky= ZKlavesnice.readInt("Zadaj číslo v rybníku, na ktoré chceš zamieriť");
        while(indexKacky<0 || indexKacky>5 || zamierene[indexKacky]){
            if(zamierene[indexKacky]) {
                System.out.println("Toto políčko už je zamierené");
            }
            indexKacky= ZKlavesnice.readInt("Zadal si zlé číslo,zadaj nové číslo (0-5)");
        }
        zamierene[indexKacky]=true;
    }
}
