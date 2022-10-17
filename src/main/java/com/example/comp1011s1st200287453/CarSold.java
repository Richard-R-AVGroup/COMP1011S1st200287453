package com.example.comp1011s1st200287453;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CarSold {

    private int carId;
    private int modelYear;
    private String make;
    private String model;
    private float price;
    private LocalDate dateSold;

    public CarSold(int carId, int modelYear, String make, String model, float price, LocalDate dateSold) {
        this.carId = carId;
        this.modelYear = modelYear;
        this.make = make;
        this.model = model;
        this.price = price;
        this.dateSold = dateSold;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        if (carId > 0)
            this.carId = carId;
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
        return make;
    }

    public void setMake(String make) {
        if (make.length() > 1)
            this.make = make;
        else
            throw new IllegalArgumentException("You must enter a make");
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
        if (dateSold.getYear() <= LocalDateTime.now().getYear() && dateSold.getDayOfYear() <= LocalDateTime.now().getDayOfYear())
            this.dateSold = dateSold;
        else
            throw new IllegalArgumentException("The date must be either today or in the past ");
    }
}
