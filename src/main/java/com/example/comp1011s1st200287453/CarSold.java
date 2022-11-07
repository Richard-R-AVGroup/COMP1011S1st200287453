package com.example.comp1011s1st200287453;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CarSold {

    private int carID;
    private int modelYear;
    private String make;
    private String model;
    private float price;
    private LocalDate dateSold;

    public CarSold(int carID, int modelYear, String make, String model, float price, LocalDate dateSold) {
        setCarID(carID);
        setModelYear(modelYear);
        setMake(make);
        setModel(model);
        setPrice(price);
        setDateSold(dateSold);
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carId) {
        if (carId > 0)
            this.carID = carId;
        else
            throw new IllegalArgumentException("The car Id must be greater than 0");
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        if (modelYear > 1850 && modelYear < LocalDate.now().getYear() + 1)
            this.modelYear = modelYear;
        else
            throw new IllegalArgumentException("The model year must be greater than 1850 and less than 2 years from now");
    }

    public String getMake() {
        return this.make;
    }

    public void setMake(String make) {
        if (make.length() > 1)
            switch(make.toLowerCase())
            {
                case "acura":
                case "ford":
                case "honda":
                case "nissan":
                case "tesla":
                    this.make = make;
                    break;
                default:
                    break;
            }
        else
            throw new IllegalArgumentException("The model must be Acura, Ford, Honda, Nissan or Tesla");
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model.length() > 2)
            this.model = model;
        else
            throw new IllegalArgumentException("The model must have at least 2 characters");
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        if (price > 0)
            this.price = price;
        else
            throw new IllegalArgumentException("The price must be greater than 0");
    }

    public LocalDate getDateSold() {
        return dateSold;
    }

    public void setDateSold(LocalDate dateSold) {
        if (dateSold.getYear() <= LocalDateTime.now().getYear())
            this.dateSold = dateSold;
        else
        {
            System.out.println("Year:" + dateSold.getYear() + ", Locale " + LocalDateTime.now().getYear());
            throw new IllegalArgumentException("The date must be either today or in the past ");
        }
    }
}
