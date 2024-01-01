package com.example.gradovisvijeta;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class GradController {
    public Button btnOk;
    public Button btnCancel;
    public TextField fieldNaziv;
    public TextField fieldBrojStanovnika;
    public ChoiceBox choiceDrzava;

    public void initialize(){
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


}
