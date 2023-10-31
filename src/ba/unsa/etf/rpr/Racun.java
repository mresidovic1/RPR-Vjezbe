package ba.unsa.etf.rpr;

public class Racun {
    private long brojRacuna;
    private Osoba korisnikRacuna;
    private boolean odobrenjePrekoracenja;
    private double stanjeRacuna;
    private double prekoracenje;
    public Racun(long br_racuna, Osoba korisnik){
        korisnikRacuna=korisnik;
        brojRacuna=br_racuna;
    }
    public boolean provjeriOdobrenjePrekoracenja(double iznos) {return prekoracenje>iznos;}
    public void izvrsiUplatu(double iznos){
        stanjeRacuna+=iznos;
    }
    public boolean IzvrsiIsplatu(double iznos){
        if(stanjeRacuna+prekoracenje<iznos){
            return false;
        }
        else{
            stanjeRacuna-=iznos;
            return true;
        }
    }
    public void odobriPrekoracenje(double iznos) {prekoracenje=iznos;}

    public long dajBrojRacuna() {
        return brojRacuna;
    }

    public void postaviBrojRacuna(long brojRacuna) {
        this.brojRacuna = brojRacuna;
    }

    public Osoba dajKorisnikRacuna() {
        return korisnikRacuna;
    }

    public void postaviKorisnikRacuna(Osoba korisnikRacuna) {
        this.korisnikRacuna = korisnikRacuna;
    }

    public boolean JeLiOdobrenjePrekoracenja() {
        return odobrenjePrekoracenja;
    }

    public void postaviOdobrenjePrekoracenja(boolean odobrenjePrekoracenja) {
        this.odobrenjePrekoracenja = odobrenjePrekoracenja;
    }

    public double dajStanjeRacuna() {
        return stanjeRacuna;
    }

    public void postaviStanjeRacuna(double stanjeRacuna) {
        this.stanjeRacuna = stanjeRacuna;
    }

    public double dajPrekoracenje() {
        return prekoracenje;
    }

    public void postaviPrekoracenje(double prekoracenje) {
        this.prekoracenje = prekoracenje;
    }
}
