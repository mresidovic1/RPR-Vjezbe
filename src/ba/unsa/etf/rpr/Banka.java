package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Banka {
    private List<Korisnik> korisnici;
    private List<Uposlenik>uposlenici;
    private long brojRacuna;
    public Banka(){
        korisnici=new ArrayList<Korisnik>();
        uposlenici=new ArrayList<Uposlenik>();
    }
    public Korisnik kreirajNovogKorisnika(String ime, String prezime){
        Korisnik novi=new Korisnik(ime,prezime);
        korisnici.add(novi);
        return novi;
    }
    public Uposlenik kreirajNovogUposlenika(String ime, String prezime){
        Uposlenik novi=new Uposlenik(ime,prezime);
        uposlenici.add(novi);
        return novi;
    }
    public Racun kreirajRacunZaKorisnika(Korisnik korisnik){
        Racun pom=null;
        for(int i=0;i<korisnici.size();i++){
            if(korisnici.get(i).equals(korisnik)){
                Long brojRacuna=(new Random()).nextLong();
                pom=new Racun(brojRacuna,korisnici.get(i));
                break;
            }
        }
        return pom;
    }
}
