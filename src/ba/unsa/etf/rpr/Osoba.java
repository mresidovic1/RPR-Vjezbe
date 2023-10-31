package ba.unsa.etf.rpr;

import java.util.Objects;

public class Osoba {
    private String ime;
    private String prezime;
    public String DajIme() { return ime; }
    public String DajPrezime() { return prezime; }
    public void PostaviIme(String ime) {this.ime=ime; }
    public void PostaviPrezime(String prezime) {this.prezime=prezime; }
    public Osoba(String ime, String prezime){
        this.ime=ime;
        this.prezime=prezime;
    }
    public String toString(){
        return ime + " " + prezime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Osoba osoba = (Osoba) o;
        return Objects.equals(ime, osoba.ime) && Objects.equals(prezime, osoba.prezime);
    }

}
