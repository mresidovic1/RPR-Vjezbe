package com.example.forma;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class FormaController {

    public ListView<Korisnik> listView;
    public TextField prezime;
    public TextField email;
    public TextField username;
    public PasswordField lozinka;
    public TextField ime;

    private KorisniciModel model=new KorisniciModel();

    public FormaController(){
        model.ispuni();
    }

    public void Kraj(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void Dodaj(ActionEvent actionEvent) {
        Korisnik novi=new Korisnik("","","","","");
        model.getKorisnici().add(novi);
        model.setTrenutni(novi);
        listView.refresh();
    }

    public String getEmail() { return email.getText(); }

    public String getUsername() { return username.getText(); }

    public String getLozinka() { return lozinka.getText(); }

    @FXML
    public void initialize(){
        listView.setItems(model.getKorisnici());
        model.trenutniProperty().addListener((obs,oldKorisnik,newKorisnik)->{
            if(oldKorisnik!=null){
                ime.textProperty().unbindBidirectional(oldKorisnik.imeProperty());
                prezime.textProperty().unbindBidirectional(oldKorisnik.prezimeProperty());
                username.textProperty().unbindBidirectional(oldKorisnik.usernameProperty());
                email.textProperty().unbindBidirectional(oldKorisnik.emailProperty());
                lozinka.textProperty().unbindBidirectional(oldKorisnik.lozinkaProperty());
            }
            if(newKorisnik==null){
                ime.setText("");
            }
            else{
                ime.textProperty().bindBidirectional(newKorisnik.imeProperty());
                prezime.textProperty().bindBidirectional(newKorisnik.prezimeProperty());
                username.textProperty().bindBidirectional(newKorisnik.usernameProperty());
                email.textProperty().bindBidirectional(newKorisnik.emailProperty());
                lozinka.textProperty().bindBidirectional(newKorisnik.lozinkaProperty());
            }
        });
    }

    public void promjenaKorisnika(MouseEvent actionEvent){
        Korisnik selektovani=listView.getSelectionModel().getSelectedItem();
        model.setTrenutni(selektovani);
    }
}