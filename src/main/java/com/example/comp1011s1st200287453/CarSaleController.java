package com.example.comp1011s1st200287453;

import javafx.collections.ObservableArray;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CarSaleController implements Initializable {

    @FXML
    private BarChart<String, Integer> barChart;

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

    @FXML
    private ComboBox<Integer> yearComboBox;

    @FXML
    private Label totalSalesLabel;

    @FXML
    private Label unitsSoldLabel;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        carID.setCellValueFactory(new PropertyValueFactory<>("carID"));
        modelYear.setCellValueFactory(new PropertyValueFactory<>("modelYear"));
        make.setCellValueFactory(new PropertyValueFactory<>("make"));
        model.setCellValueFactory(new PropertyValueFactory<>("model"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        dateSold.setCellValueFactory(new PropertyValueFactory<>("dateSold"));

        table.getItems().addAll(DbUtility.getCarsSold());
        ArrayList<CarSold> carsSold = new ArrayList<>();

        for(int i = 0; i < table.getItems().size(); i++)
        {
            carsSold.add(table.getItems().get(i));
        }

        ArrayList<Integer> yearList = new ArrayList<>();
        for (CarSold car : carsSold)
        {
            if (!yearList.contains(car.getDateSold().getYear()))
                yearList.add(car.getDateSold().getYear());
        }

        updateChart();

        yearComboBox.getItems().addAll(yearList);
    }

    @FXML
    public int getCarsByManufacturer(String type, ArrayList<CarSold> list)
    {
        int total = 0;

        for (CarSold car : list)
        {
            if (car.getMake().equals(type))
            total++;
        }

        return total;
    }

    @FXML
    public int getCarsByYear(String type, ArrayList<CarSold> list, int year)
    {
        int total = 0;

        for (CarSold car : list)
        {
            if (car.getMake().equals(type) && car.getDateSold().getYear() == year)
                total++;
        }

        return total;
    }


    @FXML
    public void updateChart()
    {
        ArrayList<CarSold> list = new ArrayList<>();

        for(int i = 0; i < table.getItems().size(); i++)
        {
            list.add(table.getItems().get(i));
        }

        if(yearComboBox.getValue() != null )
        {
            barChart.getData().clear();
            XYChart.Series<String, Integer> numbersByMenu = new XYChart.Series<>();
            numbersByMenu.getData().add(new XYChart.Data<>("Acura", getCarsByYear("Acura", list, yearComboBox.getValue())));
            numbersByMenu.getData().add(new XYChart.Data<>("Ford", getCarsByYear("Ford", list, yearComboBox.getValue())));
            numbersByMenu.getData().add(new XYChart.Data<>("Honda", getCarsByYear("Honda", list, yearComboBox.getValue())));
            numbersByMenu.getData().add(new XYChart.Data<>("Nissan", getCarsByYear("Nissan", list, yearComboBox.getValue())));
            numbersByMenu.getData().add(new XYChart.Data<>("Tesla", getCarsByYear("Tesla", list, yearComboBox.getValue())));
            barChart.setLegendVisible(false);
            barChart.getData().addAll(numbersByMenu);

            NumberFormat formatter1 = NumberFormat.getCurrencyInstance();
            String finalSales = formatter1.format(getTotalSaleByYear(yearComboBox.getValue()));
            unitsSoldLabel.setText("Units Sold: " + getTotalUnitsSoldByYear(yearComboBox.getValue()));
            totalSalesLabel.setText("Total Sales: " + finalSales);
        }
        else
        {
            barChart.getData().clear();
            XYChart.Series<String, Integer> numbersByMenu = new XYChart.Series<>();
            numbersByMenu.getData().add(new XYChart.Data<>("Acura", getCarsByManufacturer("Acura", list)));
            numbersByMenu.getData().add(new XYChart.Data<>("Ford", getCarsByManufacturer("Ford", list)));
            numbersByMenu.getData().add(new XYChart.Data<>("Honda", getCarsByManufacturer("Honda", list)));
            numbersByMenu.getData().add(new XYChart.Data<>("Nissan", getCarsByManufacturer("Nissan", list)));
            numbersByMenu.getData().add(new XYChart.Data<>("Tesla", getCarsByManufacturer("Tesla", list)));
            barChart.setLegendVisible(false);
            barChart.getData().addAll(numbersByMenu);

            NumberFormat formatter1 = NumberFormat.getCurrencyInstance();
            String finalSales = formatter1.format(getTotalSaleByYear(0));
            unitsSoldLabel.setText("Units Sold: " + getTotalUnitsSoldByYear(0));
            totalSalesLabel.setText("Total Sales: " + finalSales);
        }

    }

    @FXML
    public int getTotalUnitsSoldByYear(int year)
    {
        ArrayList<CarSold> list = new ArrayList<>();

        for(int i = 0; i < table.getItems().size(); i++)
        {
            list.add(table.getItems().get(i));
        }

        int total = 0;
        if(year != 0)
        {
            for (CarSold car : list)
            {
                if (car.getDateSold().getYear() == year)
                    total++;
            }
        }
        else
        {
            for (CarSold car : list)
            {
                total++;
            }
        }

        return total;
    }

    @FXML
    public int getTotalSaleByYear(int year)
    {
        ArrayList<CarSold> list = new ArrayList<>();

        for(int i = 0; i < table.getItems().size(); i++)
        {
            list.add(table.getItems().get(i));
        }

        int total = 0;
        if(year != 0)
        {
            for (CarSold car : list)
            {
                if (car.getDateSold().getYear() == year)
                    total += car.getPrice();
            }
        }
        else
        {
            for (CarSold car : list)
            {
                total += car.getPrice();
            }
        }

        return total;
    }
}
