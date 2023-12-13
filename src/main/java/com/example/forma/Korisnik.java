package com.example.forma;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;

public class Korisnik{
    private SimpleStringProperty ime;
    private SimpleStringProperty prezime;
    private SimpleStringProperty username;
    private SimpleStringProperty email;
    private SimpleStringProperty lozinka;

    public Korisnik(){
        this("","","","","");
    }

    public Korisnik(String ime, String prezime, String username, String email, String lozinka){
        this.ime=new SimpleStringProperty(ime);
        this.prezime=new SimpleStringProperty(prezime);
        this.username=new SimpleStringProperty(username);
        this.email=new SimpleStringProperty(email);
        this.lozinka=new SimpleStringProperty(lozinka);
    }

    public final String getIme(){
        return ime.get();
    }
    public final String getPrezime(){
        return prezime.get();
    }
    public final String getUsername(){
        return username.get();
    }
    public final String getEmail(){
        return email.get();
    }
    public final String getLozinka(){
        return lozinka.get();
    }

    public void setIme(String ime){
        this.ime.set(ime);
    }
    public void setPrezime(String ime){
        this.prezime.set(ime);
    }
    public void setUsername(String ime){
        this.username.set(ime);
    }
    public void setEmail(String ime){
        this.email.set(ime);
    }
    public void setLozinka(String ime){
        this.lozinka.set(ime);
    }
    public SimpleStringProperty imeProperty(){
        return ime;
    }
    public SimpleStringProperty prezimeProperty(){
        return prezime;
    }
    public SimpleStringProperty usernameProperty(){
        return username;
    }
    public SimpleStringProperty emailProperty(){
        return email;
    }
    public SimpleStringProperty lozinkaProperty(){
        return lozinka;
    }

    @Override
    public String toString() {
        return ime.get() + " " + prezime.get();
    }

}
