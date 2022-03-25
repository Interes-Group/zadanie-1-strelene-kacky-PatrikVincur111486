package sk.stuba.fei.uim.oop.karty.akcneKarty;

import sk.stuba.fei.uim.oop.hra.Hrac;
import sk.stuba.fei.uim.oop.karty.Kacka;
import sk.stuba.fei.uim.oop.karty.Karta;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;

public class Vystrelit extends Karta {
    public Vystrelit(String nazovKarty) {
        super(nazovKarty);
    }

    @Override
    public void zahrajKartu(int hracNaRade, int zvolenaKarta, boolean[] zamierene, ArrayList<Karta> rybnik, ArrayList<Hrac> poleHracov, ArrayList<Karta> balikKarietRybnik, ArrayList<Karta> balikAkcnychKariet) {
        ArrayList<Integer>vypis=new ArrayList<>();
        for(int i=0;i<6;i++){
            if(zamierene[i]){
                vypis.add(i);
            }
        }
        if(vypis.isEmpty()) {
            System.out.println("Nemáš zamierené na žiadnu kačku,použi inú kartu");
        }
        else{
            int indexVystrelenia = ZKlavesnice.readInt("Vyber si zamierené políčko: ");

            while(indexVystrelenia<0 || indexVystrelenia>5 || !zamierene[indexVystrelenia]){
                indexVystrelenia= ZKlavesnice.readInt("Zadal si zlé číslo kačky,zadaj nové číslo (0-5)");
            }
            if(rybnik.get(indexVystrelenia)instanceof Kacka){
                int indexHraca=((Kacka) rybnik.get(indexVystrelenia)).getIndexHraca();
                poleHracov.get(indexHraca).zastrelKacku();
                rybnik.remove(indexVystrelenia);
                System.out.println("Zastrelil si kačku hráča č."+indexHraca);
                rybnik.add(balikKarietRybnik.get(0));
            }
            else{
                System.out.println("Trafil si vodu");
            }
            balikAkcnychKariet.add(poleHracov.get(hracNaRade).getKarty().get(zvolenaKarta));
            poleHracov.get(hracNaRade).getKarty().remove(zvolenaKarta);
            zamierene[indexVystrelenia]=false;
        }

    }
}
