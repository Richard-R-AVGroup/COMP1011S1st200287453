package com.example.comp1011s1st200287453;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CarSaleController implements Initializable {


    @FXML
    private TableColumn<CarSold, Integer> carID;

    @FXML
    private TableColumn<CarSold, LocalDate> dateSold;

    @FXML
    private TableColumn<CarSold, String> make;

    @FXML
    private TableColumn<CarSold, String> model;

    @FXML
    private TableColumn<CarSold, Integer> modelYear;

    @FXML
    private TableColumn<CarSold, Float> price;

    @FXML
    private TableView<CarSold> table;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        carID.setCellValueFactory(new PropertyValueFactory<>("carID"));
        modelYear.setCellValueFactory(new PropertyValueFactory<>("modelYear"));
        make.setCellValueFactory(new PropertyValueFactory<>("make"));
        model.setCellValueFactory(new PropertyValueFactory<>("model"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        dateSold.setCellValueFactory(new PropertyValueFactory<>("dateSold"));

        //ArrayList<CarSold> carSolds = DbUtility.getCarsSold();
        table.getItems().addAll(DbUtility.getCarsSold());
    }
}
