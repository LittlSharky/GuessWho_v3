package be.kdg.screenreader;

import be.kdg.screenreader.model.Game;
import be.kdg.screenreader.view.game.GamePresenter;
import be.kdg.screenreader.view.game.GameView;
import be.kdg.screenreader.view.home.HomePresenter;
import be.kdg.screenreader.view.home.HomeView;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        // scenes in het begin mag hier maar naarmate de app groter wordt moet dat in de presenter

        HomeView homeView = new HomeView();
        // de scene zit in de view

        Scene scene = new Scene(homeView);
        // in de scene zitten nodes (buttons, text, ...)
        String cssMainFile = this.getClass().getResource("/stylesheet/main.css").toExternalForm();
        scene.getStylesheets().addAll(cssMainFile);
        new HomePresenter(homeView);

        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Guess Who?");
        stage.setHeight(600);
        stage.setWidth(800);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}