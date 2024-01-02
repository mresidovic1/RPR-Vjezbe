package com.example.gradovisvijeta;

public class Drzava {
    private String naziv;

    public Drzava(String naziv){
        this.naziv=naziv;
    }

    public String getNaziv(){
        return naziv;
    }

    @Override
    public String toString() {
        return naziv;
    }
}
