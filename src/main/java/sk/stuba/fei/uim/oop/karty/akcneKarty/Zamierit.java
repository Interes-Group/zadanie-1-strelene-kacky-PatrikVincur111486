package sk.stuba.fei.uim.oop.karty.akcneKarty;

import sk.stuba.fei.uim.oop.hra.Hrac;
import sk.stuba.fei.uim.oop.karty.Karta;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;

public class Zamierit extends Karta{

    public Zamierit(String nazovKarty) {
        super(nazovKarty);
    }

    @Override
    public void zahrajKartu(int hracNaRade, int zvolenaKarta, boolean[] zamierene, ArrayList<Karta> rybnik, ArrayList<Hrac> poleHracov, ArrayList<Karta> balikKarietRybnik) {
        int pocetZamierenych=0;
        for(int i=0;i<6;i++){
            if(zamierene[i]){
            pocetZamierenych++;
            }

        }
        if(pocetZamierenych==6){
            System.out.println("Všetky políčka už sú zamierené, použi inú kartu");
        }
        else {
            int indexKacky = ZKlavesnice.readInt("Zadaj číslo v rybníku, na ktoré chceš zamieriť");

            while (indexKacky < 0 || indexKacky > 5 || zamierene[indexKacky]) {
                if (indexKacky < 0 || indexKacky > 5) {
                    indexKacky = ZKlavesnice.readInt("Zadal si zlé číslo,zadaj nové číslo (0-5)");
                } else {
                    indexKacky = ZKlavesnice.readInt("Toto políčko už je zamierené, zadaj iné políčko");
                }
                poleHracov.get(hracNaRade).getKarty().remove(zvolenaKarta);
                zamierene[indexKacky] = true;
            }
        }
    }
}
