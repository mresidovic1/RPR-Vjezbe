package com.example.forma;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class KorisniciModel {
    private ObservableList<Korisnik> korisnici= FXCollections.observableArrayList();
    private SimpleObjectProperty<Korisnik> trenutni=new SimpleObjectProperty<>();

    public void ispuni(){
        korisnici.add(new Korisnik("Mahir","Residovic","mresidovic1","mresidovic1@etf.unsa.ba","blabla"));
        korisnici.add(new Korisnik("Abdullah","Iseric","aiseric1","aiseric1@etf.unsa.ba","lablabla"));
        korisnici.add(new Korisnik("Ibrahim","Tabakovic","itabakovic1","itabakovic1@etf.unsa.ba","blablabla"));
        korisnici.add(new Korisnik("Umihana","Secunovic","usecunovic1","usecunovic1@etf.unsa.ba","hohoohoho"));
        trenutni.set(null);
    }

    public ObservableList<Korisnik> getKorisnici() {
        return korisnici;
    }

    public void setKorisnici(ObservableList<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }

    public Korisnik getTrenutni() {
        return trenutni.get();
    }

    public SimpleObjectProperty<Korisnik> trenutniProperty() {
        return trenutni;
    }

    public void setTrenutni(Korisnik trenutni) {
        this.trenutni.set(trenutni);
    }
}
