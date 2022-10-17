package com.example.comp1011s1st200287453;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;

import java.net.URL;
import java.util.ResourceBundle;

public class CarSaleController implements Initializable {

    @FXML
    private TableColumn<?, ?> carID;

    @FXML
    private TableColumn<?, ?> dateSold;

    @FXML
    private TableColumn<?, ?> make;

    @FXML
    private TableColumn<?, ?> model;

    @FXML
    private TableColumn<?, ?> modelYear;

    @FXML
    private TableColumn<?, ?> price;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
