package com.example.gradovisvijeta;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class DrzavaController {
    public ChoiceBox choiceGrad;
    public Button btnOk;
    public Button btnCancel;
    public TextField fieldNaziv;

    public void initialize(){
        fieldNaziv.getStyleClass().add("neispravnaBoja");
        fieldNaziv.textProperty().addListener((obs,oldValue,newValue)->{
            if(fieldNaziv.getText().isEmpty()) {
                fieldNaziv.getStyleClass().removeAll("ispravnaBoja");
                fieldNaziv.getStyleClass().add("neispravnaBoja");
            }
            else {
                fieldNaziv.getStyleClass().removeAll("neispravnaBoja");
                fieldNaziv.getStyleClass().add("ispravnaBoja");
            }
        });
    }
}
