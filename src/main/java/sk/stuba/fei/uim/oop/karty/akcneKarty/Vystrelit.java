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
    public void zahrajKartu(int hracNaRade, int zvolenaKarta, boolean[] zamierene, ArrayList<Karta> rybnik, ArrayList<Hrac> poleHracov, ArrayList<Karta> balikKarietRybnik) {
        ArrayList<Integer>vypis=new ArrayList<>();
        for(int i=0;i<6;i++){
            if(zamierene[i]){
                System.out.println(i+". Zamierené");
                vypis.add(i);
            }
            else{
                System.out.println(i+". Nezamierené");
            }
        }
        int indexKacky = ZKlavesnice.readInt("Vyber si kačku: ");
        if(vypis.size()==0) {
            System.out.println("Nemáš zamierené na žiadnu kačku,použi inú kartu");
        }
        else{

            while(indexKacky<0 || indexKacky>5){
                indexKacky= ZKlavesnice.readInt("Zadal si zlé číslo kačky,zadaj nové číslo (0-5)");
            }
            int indexHraca=((Kacka) rybnik.get(indexKacky)).getIndexHraca();
            if(rybnik.get(indexKacky) instanceof Kacka) {
                poleHracov.get(indexHraca).zastrelKacku();
                System.out.println("Zastrelil si kačku hráča č."+indexHraca);
                rybnik.add(balikKarietRybnik.get(0));
            }
            else{
                System.out.println("Trafil si vodu");
            }
            poleHracov.get(indexHraca).getKarty().remove(zvolenaKarta);
            zamierene[indexKacky]=false;
        }

    }
}
