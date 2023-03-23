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
import javafx.scene.text.Font;
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
       // Font myfont = Font.loadFont(getClass().getResourceAsStream("/Fonts/Roboto-Regular.ttf"), 20);

        new HomePresenter(homeView);

        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Guess Who?");
        stage.setHeight(850);
        stage.setWidth(1200);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}