package sk.stuba.fei.uim.oop.karty.akcneKarty;

import sk.stuba.fei.uim.oop.hra.Hrac;
import sk.stuba.fei.uim.oop.karty.Kacka;
import sk.stuba.fei.uim.oop.karty.Karta;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;

public class Vystrelit extends Karta {
    String nazovKarty;

    public Vystrelit() {
        this.nazovKarty = "Vystreliť";
    }
    @Override
    public void zahrajKartu(boolean[] zamierene, ArrayList<Karta> rybnik, ArrayList<Hrac> poleHracov, ArrayList<Karta> balikKarietRybnik) {
        ArrayList<Integer>vypis=new ArrayList<>();
        for(int i=1;i<7;i++){
            if(zamierene[i]){
                vypis.add(i);
            }
        }
        int indexKacky = ZKlavesnice.readInt("Vyber si kačku: ");
        if(vypis.size()==0) {
            System.out.println("Nemáš zamierené na žiadnu kačku");
        }
        else{
            System.out.println("Máš zamierené na "+vypis.toString()+"kačky");
            while(indexKacky<0 || indexKacky>5){
                indexKacky= ZKlavesnice.readInt("Zadal si zlé číslo kačky,zadaj nové číslo (0-5)");
            }
        }
        if(indexKacky!=-1) {
            if(rybnik.get(indexKacky) instanceof Kacka) {
                int indexHraca=((Kacka) rybnik.get(indexKacky)).getIndexHraca();
                poleHracov.get(indexHraca).zastrelKacku();
                System.out.println("Zastrelil si kačku hráča č."+indexHraca);
                rybnik.add(balikKarietRybnik.get(0));
            }
            else{
                System.out.println("Trafil si vodu");
            }
        }
    zamierene[indexKacky]=false;
    }
}
