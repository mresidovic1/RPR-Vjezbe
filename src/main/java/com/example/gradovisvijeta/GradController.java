package com.example.gradovisvijeta;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GradController {
    public Button btnOk;
    public Button btnCancel;
    public TextField fieldNaziv;
    public TextField fieldBrojStanovnika;
    public ChoiceBox choiceDrzava;

    public void initialize(){
        for(Drzava d : GeografijaDAO.getInstanca().drzave()){
            choiceDrzava.getItems().add(d.toString());
        }

        fieldNaziv.getStyleClass().add("neispravnaBoja");
        fieldBrojStanovnika.getStyleClass().add("neispravnaBoja");
        fieldNaziv.textProperty().addListener((obs,oldValue,newValue)->{
            if(fieldNaziv.getText().isEmpty()) {
                fieldNaziv.getStyleClass().removeAll("ispravnaBoja");
                fieldNaziv.getStyleClass().add("neispravnaBoja");
            }
            else{
                fieldNaziv.getStyleClass().removeAll("neispravnaBoja");
                fieldNaziv.getStyleClass().add("ispravnaBoja");
            }
        });
        fieldBrojStanovnika.textProperty().addListener((obs,oldValue,newValue)->{
            if(fieldBrojStanovnika.getText().isEmpty()) {
                fieldBrojStanovnika.getStyleClass().removeAll("ispravnaBoja");
                fieldBrojStanovnika.getStyleClass().add("neispravnaBoja");
            }
            else{
                fieldBrojStanovnika.getStyleClass().removeAll("neispravnaBoja");
                fieldBrojStanovnika.getStyleClass().add("ispravnaBoja");
            }
        });
    }


    public void okAction(ActionEvent actionEvent) {
        String naziv=fieldNaziv.getText().trim();
        int brojStanovnika= Integer.parseInt(fieldBrojStanovnika.getText().trim());
        String drzava=choiceDrzava.getValue().toString();
        if(naziv.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Neispravan unos");
            alert.setHeaderText(null);
            alert.setContentText("Niste unijeli naziv države!");
            alert.showAndWait();
        }
        GeografijaDAO.getInstanca().dodajGrad(new Grad(naziv,brojStanovnika,drzava));
        zatvoriProzor();
    }

    private void zatvoriProzor() {
        Stage stage=(Stage) btnCancel.getScene().getWindow();
        stage.close();
    }

    public void cancelAction(ActionEvent actionEvent) {
        zatvoriProzor();
    }
}
