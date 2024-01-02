package com.example.gradovisvijeta;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class GlavnaController {

    public Button btnDodajGrad;
    public Button btnDodajDrzavu;
    public Button btnIzmijeniGrad;
    public Button btnObrisiGrad;
    public TableView tableViewGradovi;
    public TableColumn colGradId;
    public TableColumn colGradNaziv;
    public TableColumn colGradStanovnika;
    public TableColumn colGradDrzava;

    public void initialize(){
            ArrayList<Grad> gradovi = GeografijaDAO.getInstanca().gradovi();
            colGradId.setCellValueFactory(new PropertyValueFactory<>("id"));
            colGradNaziv.setCellValueFactory(new PropertyValueFactory<>("naziv"));
            colGradStanovnika.setCellValueFactory(new PropertyValueFactory<>("brojStanovnika"));
            colGradDrzava.setCellValueFactory(new PropertyValueFactory<>("drzava"));
            tableViewGradovi.getItems().addAll(gradovi);
    }

    public void dodajGrad(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("grad.fxml"));
        Stage stage=new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 300, 150);
        stage.setTitle("Grad");
        stage.setScene(scene);
        stage.show();
    }

    public void dodajDrzavu(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("drzava.fxml"));
        Stage stage=new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 300, 120);
        stage.setTitle("Država");
        stage.setScene(scene);
        stage.show();
    }

    public void izmijeniGrad(ActionEvent actionEvent) {
    }

    public void obrisiGrad(ActionEvent actionEvent) {
    }
}
