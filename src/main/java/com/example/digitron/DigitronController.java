package com.example.digitron;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class DigitronController {
    @FXML
    private Button btn0;

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private Button btn4;

    @FXML
    private Button btn5;

    @FXML
    private Button btn6;

    @FXML
    private Button btn7;

    @FXML
    private Button btn8;

    @FXML
    private Button btn9;

    @FXML
    private Button BtnDot;

    @FXML
    private TextField display;

    @FXML
    private Button divBtn;

    @FXML
    private Button equalsBtn;

    @FXML
    private Button minusBtn;

    @FXML
    private Button modBtn;

    @FXML
    private Button multBtn;

    @FXML
    private Button plusBtn;

    double rs=0;
    double n1;
    double n2;
    char op;
    int point;

    @FXML
    private void calculation(ActionEvent event){
        if(event.getSource()== btn1){
            display.appendText("1");
        }
        else if(event.getSource()== btn2){
            display.appendText("2");
        }
        else if(event.getSource()== btn3){
            display.appendText("3");
        }
        else if(event.getSource()== btn4){
            display.appendText("4");
        }
        else if(event.getSource()== btn5){
            display.appendText("5");
        }
        else if(event.getSource()== btn6){
            display.appendText("6");
        }
        else if(event.getSource()== btn7){
            display.appendText("7");
        }
        else if(event.getSource()== btn8){
            display.appendText("8");
        }
        else if(event.getSource()== btn9){
            display.appendText("9");
        }
        else if(event.getSource()== btn0){
            display.appendText("0");
        }
        else if(event.getSource()==BtnDot && point==0){
            display.appendText(".");
            point=1;
        }
        else if(event.getSource()==plusBtn){
            n1=Double.parseDouble(display.getText());
            display.setText("");
            op='+';
            point=0;
        }
        else if(event.getSource()==minusBtn){
            n1=Double.parseDouble(display.getText());
            display.setText("");
            op='-';
            point=0;
        }
        else if(event.getSource()==modBtn){
            n1=Double.parseDouble(display.getText());
            display.setText("");
            op='%';
            point=0;
        }
        else if(event.getSource()==multBtn){
            n1=Double.parseDouble(display.getText());
            display.setText("");
            op='*';
            point=0;
        }
        else if(event.getSource()==divBtn){
            n1=Double.parseDouble(display.getText());
            display.setText("");
            op='/';
            point=0;
        }
        else if(event.getSource()==equalsBtn){
            n2=Double.parseDouble(display.getText());
            switch(op) {
                case '+' : rs=n1+n2; break;
                case '-' : rs=n1-n2; break;
                case '%' : rs=n1%n2; break;
                case '/' : rs=n1/n2; break;
                case '*' : rs=n1*n2; break;
                default : display.setText("Error");
            }
            display.setText(String.valueOf(rs));
        }


    }


}