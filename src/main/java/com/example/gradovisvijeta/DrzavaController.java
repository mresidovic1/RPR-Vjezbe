package com.example.gradovisvijeta;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DrzavaController {
    public ChoiceBox choiceGrad;
    public Button btnOk;
    public Button btnCancel;
    public TextField fieldNaziv;

    public void initialize(){
        for(Grad g : GeografijaDAO.getInstanca().gradovi()){
            choiceGrad.getItems().add(g.toString());
        }
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

    public void okAction(ActionEvent actionEvent) {
        String naziv=fieldNaziv.getText().trim();
        if(naziv.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Neispravan unos");
            alert.setHeaderText(null);
            alert.setContentText("Niste unijeli naziv države!");
            alert.showAndWait();
        }
        GeografijaDAO.getInstanca().dodajDrzavu(new Drzava(naziv));
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
