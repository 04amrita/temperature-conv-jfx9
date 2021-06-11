package com.adhikari.amrita.temperature_conv;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MyMain extends Application {

    public static void main(String[] args) {
        System.out.println("main");
        launch(args);
    }

    @Override
    public void init() throws Exception {
        System.out.println("init"); // Initialize your application
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        System.out.println("start");    // Starts an application

        FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
        VBox rootNode = loader.load();

        MenuBar menuBar = createMenu();
        rootNode.getChildren().add(0, menuBar);

        Scene scene = new Scene(rootNode);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Temperature Converter Tool");
        primaryStage.show();
    }

    private MenuBar createMenu() {

        // File Menu
        Menu fileMenu = new Menu("File");
        MenuItem newMenuItem = new MenuItem("New");

        newMenuItem.setOnAction(event -> {
            System.out.println("New Menu Item Clicked");
            // More code....
        });

        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        MenuItem quitMenuItem = new MenuItem("Quit");

        quitMenuItem.setOnAction(event -> {
            Platform.exit();
            System.exit(0);
        });

        fileMenu.getItems().addAll(newMenuItem, separatorMenuItem, quitMenuItem);

        // Help Menu
        Menu helpMenu = new Menu("Help");
        MenuItem aboutApp = new MenuItem("About");

        aboutApp.setOnAction(event -> aboutApp());

        helpMenu.getItems().addAll(aboutApp);

        // Menu Bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, helpMenu);

        return menuBar;
    }

    public static void aboutApp() {

        Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle("Temperature Converter Tool");
        alertDialog.setHeaderText("Made by \nAmrita Adhikari");
        alertDialog.setContentText("Simple JAVA fx App which converts Temperature\n"+"made in 2021\n"+
                "with JAVA 9.0.1 and JAVA Fx\n"+
                "Roll : 10800317123\n"+
                "Asansol Engineering College\n"+
                "Electronics and Communication Engg. : 8th Sem\n");

        ButtonType yesBtn = new ButtonType("Ok");
        //ButtonType noBtn = new ButtonType("No");

        alertDialog.getButtonTypes().setAll(yesBtn);

        Optional<ButtonType> clickedBtn = alertDialog.showAndWait();

        if (clickedBtn.isPresent() && clickedBtn.get() == yesBtn) {
            System.out.println("Yes Button Clicked !");
        } //else {
        System.out.println("No Button Clicked !");
        //}
    }

    @Override
    public void stop() throws Exception {

        System.out.println("stop"); // Called when application is stopped and is about to shut down
        super.stop();
    }
}
