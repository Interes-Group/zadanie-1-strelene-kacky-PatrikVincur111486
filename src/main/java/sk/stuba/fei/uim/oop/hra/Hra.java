package sk.stuba.fei.uim.oop.hra;
import sk.stuba.fei.uim.oop.karty.Kacka;
import sk.stuba.fei.uim.oop.karty.Karta;
import sk.stuba.fei.uim.oop.karty.Voda;
import sk.stuba.fei.uim.oop.karty.akcneKarty.*;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class Hra  {
    private final int pocetHracov;
    private ArrayList<Hrac> poleHracov;
    private boolean zamierene[]={false,false,false,false,false,false};
    private ArrayList<Karta> balikKarietRybnik;
    private ArrayList<Karta> balikAkcnychKariet;
    private ArrayList<Karta> rybnik;



    public Hra() {
        this.pocetHracov=ZKlavesnice.readInt("Zadaj pocet hracov:");
        vytvorHracov();
        vytvorBalikRybnikKariet();
        vytvorRybnik();
        vytvorBalikAkcnychKariet();
        rozdajKarty();
        vypisStavHry();
        priebehHry();
    }
    private void priebehHry(){
        while(skontrolujKackyHracov()){
            int hracNaRade=0;
            System.out.println("Tvoje karty: ");
            poleHracov.get(0).vypisKarty();break;
        }
    }

    private boolean skontrolujKackyHracov(){
        int pocetZivychHracov=0;
        for(int i=0;i<pocetHracov;i++){
            if(poleHracov.get(i).getPocetKaciek()>0){
                pocetZivychHracov++;
            }
        }
        return pocetZivychHracov > 2;
    }

    private void vytvorHracov() {
        this.poleHracov=new ArrayList<Hrac>();
        for(int i=1;i<=this.pocetHracov;i++){
            this.poleHracov.add(new Hrac(i));
        }
    }

    private void vytvorBalikRybnikKariet(){
        this.balikKarietRybnik=new ArrayList<Karta>();
        for(int i=1;i<=this.pocetHracov;i++) {
        for(int j=0;j<5;j++) {
            this.balikKarietRybnik.add(new Kacka(i));}
        this.balikKarietRybnik.add(new Voda());
        }
        Collections.shuffle(this.balikKarietRybnik);
    }

    private void vypisStavHry(){
        for(int i=0;i<this.pocetHracov;i++) {
            if(!this.zamierene[i]) System.out.print(i+1+". Nezamierene - ");
            else System.out.print(i+". Zamierene - ");
            if(this.rybnik.get(i) instanceof Kacka) System.out.println("Kačka hráča "+(i+1));
            else System.out.println("Voda");
        }
    }

    private void vytvorRybnik(){
        this.rybnik=new ArrayList<Karta>();
        for(int i=0;i<this.pocetHracov;i++){
            this.rybnik.add(this.balikKarietRybnik.get(i));
            this.balikKarietRybnik.remove(0);
        }
    }

    private void vytvorBalikAkcnychKariet(){
        this.balikAkcnychKariet=new ArrayList<Karta>();
        for(int i=0;i<10;i++){
            this.balikAkcnychKariet.add(new Zamierit());
        }
        for(int i=0;i<12;i++){
            this.balikAkcnychKariet.add(new Vystrelit());
        }
        for(int i=0;i<2;i++){
            this.balikAkcnychKariet.add(new DivokyBill());
        }
        for(int i=0;i<6;i++){
            this.balikAkcnychKariet.add(new KacaciPochod());
        }
        for(int i=0;i<2;i++){
            this.balikAkcnychKariet.add(new Rosambo());
        }
        this.balikAkcnychKariet.add(new KacaciTanec());
        this.balikAkcnychKariet.add(new Turbokacka());
        Collections.shuffle(this.balikAkcnychKariet);
    }
    private void rozdajKarty(){
        for(int i=0;i<pocetHracov;i++){
            poleHracov.get(i).vezmiKarty(balikAkcnychKariet);
        }
    }
}
