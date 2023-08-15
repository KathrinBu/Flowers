package com.example.flowers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;

public class HelloController {
    @FXML
    Label x;
    @FXML
    Label y;
    @FXML
    Label z;
    @FXML
    Button masha;
    @FXML
    Button tanya;
    @FXML
    Button day;
    @FXML
    TextArea result;
    @FXML
    Slider slider;
    int k;

    public void initialize(){
        slider.valueProperty().addListener((observableValue, number, t1) -> {
            k= t1.intValue();
            result.setText(move()+" - "+k);
        });
    }

    public void changeK() {
        slider.adjustValue(k);
    }

    public void doMasha(){
        String s=z.getText();
        z.setText(y.getText());
        y.setText(s);
    }
    public void doTanya(){
        String s=y.getText();
        y.setText(x.getText());
        x.setText(s);

    }

    public void doDay(){
        doMasha();
        doTanya();
        k++;
        changeK();

    }

    @FXML
    protected String move() {
        if(k % 3 == 0){
            return "GCV";}
        if(k % 3 == 1) {
            return "VGC";
        }
        if(k % 3 == 2) {
            return "CVG";
        }

        return null;
    }
}