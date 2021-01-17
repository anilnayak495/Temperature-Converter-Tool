package com.internshala.javafxapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MyMain extends Application {

    public static void main (String [] args ){
        System.out.println("Main");
        launch(args);

    }

    // JavaFX life cycle(method when code exist )
    @Override
    public void init() throws Exception {
        System.out.println("init");  // initialize your application
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {   // Stage is outer most container of our application

        System.out.println("Starts");  // Start your application (it make visible to user )

        FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));  // this line will connect both file(FXML File and MyMain.java file) internally
        VBox rootNode = loader.load();  // loeader.load(); method :- it simply load rootNode of our FXML file (in our case pane is a RootNode )

        MenuBar menuBar = createMenu();
        rootNode.getChildren().add ( 0 , menuBar);

        Scene scene = new Scene(rootNode); // Scene :- it is contain all the button

        primaryStage.setScene(scene);
        primaryStage.setTitle("Temperature Converter Tool");

       // primaryStage.setResizable(false);  // this will make your application non resizable

        primaryStage.show();  // Stage.show(); method is important to make our application visible

    }

    // BELOW is method for create menu bar
    private MenuBar createMenu(){

        // File menu
        Menu fileMenu = new Menu("File");
        MenuItem newMenuItem  = new MenuItem("New");

        newMenuItem.setOnAction(event -> {
            System.out.println("New menu item clicked ");
            // here we can write more code
        });

        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem(); // it will separate menu item means it will give line b/w two menu
        MenuItem quitMenuItem = new MenuItem("Quit");

        quitMenuItem.setOnAction(event -> {
            Platform.exit(); // this statement shutDown current application
            System.exit(0);  // this statement will shutDown current virtual machine

        });


        fileMenu.getItems().addAll(newMenuItem , separatorMenuItem , quitMenuItem);

        // Help menu
        Menu helpMenu = new Menu("Help");
        MenuItem aboutApp = new MenuItem("About");

        aboutApp.setOnAction(event -> aboutApp());

        helpMenu.getItems().addAll(aboutApp);

        // Menu bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu , helpMenu);

        return menuBar;

    }

    private void aboutApp() {

        Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle(" My First Java App");
        alertDialog.setHeaderText("Learning JavaFX");
        alertDialog.setContentText(" I am a just beginner but soon i will be pro and start developing aswesome java games");

        ButtonType yesBtn = new ButtonType("Yes");
        ButtonType noBtn = new ButtonType("No");

        alertDialog.getButtonTypes().setAll(yesBtn , noBtn);

        Optional<ButtonType> clickedBtn = alertDialog.showAndWait();
        //alertDialog.show();

        if( clickedBtn.isPresent() && clickedBtn.get() == yesBtn ){
            System.out.println(" yes button clicked ");
        }
        else{
            System.out.println(" No button clicked ");
        }

    }

    // JavaFX life Cycle ( When we shut down  application exist another method)
    @Override
    public void stop() throws Exception {
        System.out.println("stop");  // Called when application is stopped and is about to shutdown
        super.stop();
    }
}
