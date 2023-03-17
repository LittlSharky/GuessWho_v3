package be.kdg.screenreader;

import be.kdg.screenreader.model.Game;
import be.kdg.screenreader.view.game.GamePresenter;
import be.kdg.screenreader.view.game.GameView;
import be.kdg.screenreader.view.home.HomePresenter;
import be.kdg.screenreader.view.home.HomeView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        // scenes in het begin mag hier maar naarmate de app groter wordt moet dat in de presenter

        HomeView homeView = new HomeView();
        // de scene zit in de view

        // in de scene zitten nodes (buttons, text, ...)
        //scene.getStylesheets().add("/stylesheets/stylesheet.css");

        new HomePresenter(homeView, new Game());


       // BorderPane.setMargin(homeView, new Insets(10));
       // BorderPane.setAlignment(homeView, Pos.CENTER);
        //BorderPane.setMargin(homeView, new Insets(10,0,10,0));

        Scene scene = new Scene(homeView);
        stage.setScene(scene);
        stage.setTitle("JavaFX Application");
        stage.setHeight(800);
        stage.setWidth(1000);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}