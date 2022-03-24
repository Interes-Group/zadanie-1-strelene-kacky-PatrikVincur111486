package sk.stuba.fei.uim.oop.hra;
import sk.stuba.fei.uim.oop.karty.Karta;
import java.util.ArrayList;

public class Hrac {
    private int pocetKaciek=5;
    private ArrayList<Karta>karty;
    public int cisloHraca;

    public Hrac(int cisloHraca) {
        this.cisloHraca = cisloHraca;this.karty=new ArrayList<>();
    }

    /*public void vezmiKartu(String NazovZobranejKarty) {
        this.karty.remove();*/
    //}

    public ArrayList<Karta> getKarty() {
        return karty;
    }

    public void zastrelKacku(){
        pocetKaciek--;
    }

    public int getPocetKaciek() {
        return this.pocetKaciek;
    }

    public void vezmiKarty(ArrayList<Karta> balikAkcnychKariet,int pocetKariet) {
        for (int i = 0; i < pocetKariet; i++) {
            this.karty.add(balikAkcnychKariet.get(0));
            balikAkcnychKariet.remove(0);
        }
    }

    public void vypisKarty(){
        for(int i = 0; i < 3; i++ ){        //tu je chyba
            System.out.println(i+". "+karty.get(i).vratNazovKarty());
        }
    }

}
