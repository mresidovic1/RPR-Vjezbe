package com.example.digitron;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DigitronController {

    @FXML
    public Label display;

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
    private Button dotBtn;

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
    private void calculation(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();

        if (clickedButton == dotBtn && point == 0) {
            display.setText(display.getText() + ".");
            point = 1;
        } else if (isDigitButton(clickedButton)) {
            handleDigitButton(clickedButton.getText());
        } else if (isOperatorButton(clickedButton)) {
            n1 = Double.parseDouble(display.getText());
            display.setText("");
            op = clickedButton.getText().charAt(0);
            point = 0;
        } else if (clickedButton == equalsBtn) {
            n2 = Double.parseDouble(display.getText());
            switch (op) {
                case '+': rs = n1 + n2; break;
                case '-': rs = n1 - n2; break;
                case '%': rs = n1 % n2; break;
                case '/': rs = n1 / n2; break;
                case '*': rs = n1 * n2; break;
                default: display.setText("Error");
            }
            display.setText(String.valueOf(rs));
        }
    }

    private boolean isDigitButton(Button button) {
        return button == btn0 || button == btn1 || button == btn2 ||
                button == btn3 || button == btn4 || button == btn5 ||
                button == btn6 || button == btn7 || button == btn8 || button == btn9;
    }

    private void handleDigitButton(String digit) {
        String currentText = display.getText();

        if (currentText.equals("0")) {
            display.setText(digit);
        } else {
            display.setText(currentText + digit);
        }
    }

    private boolean isOperatorButton(Button button) {
        return button == plusBtn || button == minusBtn || button == modBtn ||
                button == multBtn || button == divBtn;
    }


}