package sk.stuba.fei.uim.oop.hra;
import sk.stuba.fei.uim.oop.karty.Kacka;
import sk.stuba.fei.uim.oop.karty.Karta;
import sk.stuba.fei.uim.oop.karty.Voda;
import sk.stuba.fei.uim.oop.karty.akcneKarty.*;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

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
        priebehHry();
    }
    private void priebehHry(){
        int hracNaRade=0;
        while(skontrolujKackyHracov()){

            vypisStavHry();
            System.out.println("\nNa rade je hráč č."+hracNaRade+"\nTvoje karty: ");
            poleHracov.get(hracNaRade).vypisKarty();
            if(spocitajZamieravace()==0 && spocitajVystrelit(hracNaRade)==3 || spocitajZamieravace()==6 && spocitajZamierit(hracNaRade)==3){
                int vyhodenaKarta=ZKlavesnice.readInt("Nemôžeš zahrať žiadnu zo svojich kariet, vyber si jednu, ktorú vyhodíš");
                balikKarietRybnik.add(poleHracov.get(hracNaRade).getKarty().get(vyhodenaKarta));
                poleHracov.get(hracNaRade).getKarty().remove(vyhodenaKarta);
                poleHracov.get(hracNaRade).vezmiKarty(balikAkcnychKariet,1);
                continue;
            }
            int zvolenaKarta=ZKlavesnice.readInt("Zvoľ si číslo karty (0-2)");
            ArrayList<Karta> kartyHracaNaRade=poleHracov.get(hracNaRade).getKarty();
            if(zvolenaKarta>2 || zvolenaKarta<0){
                while(zvolenaKarta>2 || zvolenaKarta<0){
                zvolenaKarta=ZKlavesnice.readInt("Zadal si kartu mimo rozsahu, vyber si inú kartu");
                }
            }
            kartyHracaNaRade.get(zvolenaKarta).zahrajKartu(hracNaRade, zvolenaKarta, zamierene, rybnik, poleHracov, balikKarietRybnik, balikAkcnychKariet);
            while(kartyHracaNaRade.size()==3) {
                zvolenaKarta=ZKlavesnice.readInt("Vyber si inú kartu");
                while(zvolenaKarta>2 || zvolenaKarta<0){
                    zvolenaKarta=ZKlavesnice.readInt("Zadal si kartu mimo rozsahu, vyber si inú kartu");
                }
                kartyHracaNaRade.get(zvolenaKarta).zahrajKartu(hracNaRade, zvolenaKarta, zamierene, rybnik, poleHracov, balikKarietRybnik, balikAkcnychKariet);
            }

            poleHracov.get(hracNaRade).vezmiKarty(balikAkcnychKariet,1);
            if(poleHracov.size()-1==hracNaRade){
                hracNaRade=0;
                continue;
            }
            hracNaRade++;
        }

        for(int i=0;i<this.pocetHracov;i++){
            if(this.poleHracov.get(i).getPocetKaciek()>0){
                System.out.println("Hráč č."+i+" vyhral!");
            }
        }
    }

    private boolean skontrolujKackyHracov(){
        int pocetZivychHracov=0;
        for(int i=0;i<pocetHracov;i++){
            if(poleHracov.get(i).getPocetKaciek()>0){
                pocetZivychHracov++;
            }
            else{
                balikAkcnychKariet.addAll(poleHracov.get(i).getKarty());
            }
        }
        return pocetZivychHracov > 1;
    }

    private void vytvorHracov() {
        this.poleHracov=new ArrayList<Hrac>();
        for(int i=0;i<this.pocetHracov;i++){
            this.poleHracov.add(new Hrac(i));
        }
    }

    private void vytvorBalikRybnikKariet(){
        this.balikKarietRybnik=new ArrayList<Karta>();
        for(int i=0;i<this.pocetHracov;i++) {
        for(int j=0;j<5;j++) {
            if(j==0){
                this.balikKarietRybnik.add(new Voda("Voda"));
            }
            this.balikKarietRybnik.add(new Kacka("Kačka",i));
            }
        }
        Collections.shuffle(this.balikKarietRybnik);
    }

    private void vypisStavHry(){
        for(int i=0;i<6;i++) {
            if(!this.zamierene[i]) System.out.print(i+". Nezamierene - ");
            else System.out.print(i+". Zamierene - ");
            if(this.rybnik.get(i) instanceof Kacka) System.out.println("Kačka hráča "+((Kacka) this.rybnik.get(i)).getIndexHraca());
            else System.out.println("Voda");
        }
    }

    private void vytvorRybnik(){
        this.rybnik=new ArrayList<Karta>();
        for(int i=0;i<6;i++){
            this.rybnik.add(this.balikKarietRybnik.get(0));
            this.balikKarietRybnik.remove(0);
        }
    }
    private int spocitajZamieravace(){
        int pocetZamiereni=0;
        for(int i=0;i<6;i++) {
            if (zamierene[i]) {
                pocetZamiereni++;
            }
        }
        return pocetZamiereni;
    }
    private int spocitajZamierit(int hracNaRade){
        int pocetKarietZamierit=0;
        for(int i=0;i<3;i++){
            if(poleHracov.get(hracNaRade).getKarty().get(i).vratNazovKarty().equals("Zamieriť")){
                pocetKarietZamierit++;
            }
        }
        return pocetKarietZamierit;
    }
    private int spocitajVystrelit(int hracNaRade){
        int pocetKarietVystrelit=0;
        for(int i=0;i<3;i++){
            if(poleHracov.get(hracNaRade).getKarty().get(i).vratNazovKarty().equals("Vystreliť")){
                pocetKarietVystrelit++;
            }
        }
        return pocetKarietVystrelit;
    }

    private void vytvorBalikAkcnychKariet(){
        this.balikAkcnychKariet=new ArrayList<Karta>();
        for(int i=0;i<10;i++){
            this.balikAkcnychKariet.add(new Zamierit("Zamieriť"));
        }
        for(int i=0;i<12;i++){
            this.balikAkcnychKariet.add(new Vystrelit("Vystreliť"));
        }
        for(int i=0;i<2;i++){
            this.balikAkcnychKariet.add(new DivokyBill("Divoký Bill"));
        }
        for(int i=0;i<6;i++){
            this.balikAkcnychKariet.add(new KacaciPochod("Kačací pochod"));
        }
        for(int i=0;i<2;i++){
            this.balikAkcnychKariet.add(new Rosambo("Rošambo"));
        }
        this.balikAkcnychKariet.add(new KacaciTanec("Kačací Tanec"));
        this.balikAkcnychKariet.add(new Turbokacka("Turbokačka"));
        Collections.shuffle(this.balikAkcnychKariet);
    }
    private void rozdajKarty(){
        for(int i=0;i<pocetHracov;i++){
            poleHracov.get(i).vezmiKarty(balikAkcnychKariet,3);
        }
    }
}
