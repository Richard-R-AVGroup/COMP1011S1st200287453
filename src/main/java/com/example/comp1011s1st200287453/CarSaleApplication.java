package com.example.comp1011s1st200287453;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class CarSaleApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CarSaleApplication.class.getResource("application-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Car Lot");
        String imgUrl = "img/car.png";
        Image imageLogo = new Image(String.valueOf(CarSaleApplication.class.getResource(imgUrl)));
        stage.getIcons().add(imageLogo);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}