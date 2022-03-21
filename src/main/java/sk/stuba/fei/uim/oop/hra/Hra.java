package sk.stuba.fei.uim.oop.hra;
import sk.stuba.fei.uim.oop.karty.Kacka;
import sk.stuba.fei.uim.oop.karty.Karta;
import sk.stuba.fei.uim.oop.karty.Voda;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Hra  {
    private int pocetHracov;
    private ArrayList<Hrac> poleHracov;
    private ArrayList<Karta> balikKariet;


    public Hra() {
        this.pocetHracov=ZKlavesnice.readInt("pocet hracov:");
    }


    private void VytvorBalikRybnik(){
        this.balikKariet=new ArrayList<Karta>();
        for(int i=1;i<=this.pocetHracov;i++) {
        for(int j=0;j<5;i++) {
                this.balikKariet.add(new Kacka(i));
            }
        balikKariet.add(new Voda());
        }
        Collections.shuffle(balikKariet);
    }
    //zameriavace
}
