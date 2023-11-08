package ba.unsa.etf.rpr.predavanje;

import java.util.*;

public class Imenik {
    private Map<String, TelefonskiBroj> imenik;

    /**
     * veoma jednostavna provjera da li je zadani broj iz grada zadanog parametrom
     * ne zaboraviti konverziju iz TelefonskiBroj u FiksniBroj, downcasting
     * @param broj
     * @param g
     * @return
     */

    private boolean jeLiIzGrada(TelefonskiBroj broj, Grad g){
        if(broj instanceof FiksniBroj){
            return g.equals(((FiksniBroj)broj).getGrad());
        }
        else return false;
    }
    public Imenik(Map<String, TelefonskiBroj> imenik) {
        this.imenik = imenik;
    }
    public Imenik(){
        imenik=new HashMap<String, TelefonskiBroj>();
    }
    public Map<String, TelefonskiBroj> getImenik() {
        return imenik;
    }
    public void setImenik(Map<String, TelefonskiBroj> imenik) {
        this.imenik = imenik;
    }
    public void Dodaj(String ime, TelefonskiBroj broj){
        imenik.put(ime,broj);
    }

    /**
     * metode dajBroj i dajBroj su vrlo jednostavne, te samo provjeravaju da li uopste
     * postoji broj ili ime uz vrijednost zadanog parametra
     * u metodi dajIme se mogla implementirati vlastita metoda equals koja bi radila slicnu stvar
     * @param ime
     * @return
     */
    String dajBroj(String ime){
        TelefonskiBroj broj=imenik.get(ime);
        if(broj==null) return null;
        else
            return broj.ispisi();
    }
    String dajIme(TelefonskiBroj broj){
        for(Map.Entry<String, TelefonskiBroj> entry : imenik.entrySet()){
            if(entry.getValue().ispisi().equals(broj.ispisi())){
                return entry.getKey();
            }
        }
        return null;
    }

    /**
     * koristiti StringBuilder za pravljenje stringova jer je najlakse
     * @param c
     * @return
     */
    String naSlovo(char c){
        StringBuilder rijec = new StringBuilder();
        int brojac=1;
        for(Map.Entry<String, TelefonskiBroj> entry : imenik.entrySet()){
            if(entry.getKey().startsWith(String.valueOf(c))){
                rijec.append(brojac);
                rijec.append(". ");
                rijec.append(entry.getKey());
                rijec.append(" - ");
                rijec.append(entry.getValue().ispisi());
                rijec.append(System.lineSeparator());
            }
            brojac++;
        }
        return rijec.toString();
    }
    Set<String> izGrada(Grad g){
        Set<String> imena=new TreeSet<String>();
        for(Map.Entry<String, TelefonskiBroj> entry : imenik.entrySet()){
            if(jeLiIzGrada(entry.getValue(),g)){
                imena.add(entry.getKey());
            }
        }
        return imena;
    }

    /**
     * iskoristena mogucnost TreeSeta za generisanje vlastitog uslova redoslijeda
     * @param g
     * @return
     */
    public Set<TelefonskiBroj> izGradaBrojevi(Grad g){
        Set<TelefonskiBroj> brojevi=new TreeSet<>(new Comparator<TelefonskiBroj>() {
        @Override
        public int compare(TelefonskiBroj br1, TelefonskiBroj br2) {return br1.ispisi().compareTo(br2.ispisi());}
        });

        for(Map.Entry<String, TelefonskiBroj> entry : imenik.entrySet()){
            if(jeLiIzGrada(entry.getValue(), g)){
                brojevi.add(entry.getValue());
            }
        }
        return brojevi;
    }

    @Override
    public String toString() {
        StringBuilder ispis=new StringBuilder();
        int brojac=1;
        for(Map.Entry<String, TelefonskiBroj> entry : imenik.entrySet()) {
            ispis.append(brojac);
            ispis.append(". ");
            ispis.append(entry.getKey());
            ispis.append(" - ");
            ispis.append(entry.getValue().ispisi());
            ispis.append(System.lineSeparator());
            brojac++;
        }
        return ispis.toString();
    }
}
