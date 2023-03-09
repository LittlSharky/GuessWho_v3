package be.kdg.screenreader;

import be.kdg.screenreader.model.Game;
import be.kdg.screenreader.view.game.GamePresenter;
import be.kdg.screenreader.view.game.GameView;
import be.kdg.screenreader.view.home.HomePresenter;
import be.kdg.screenreader.view.home.HomeView;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        // scenes in het begin mag hier maar naarmate de app groter wordt moet dat in de presenter

        HomeView homeView = new HomeView();
        // de scene zit in de view

        Scene scene = new Scene(homeView);
        // in de scene zitten nodes (buttons, text, ...)

        new HomePresenter(homeView,new Game());


        stage.setScene(scene);
        stage.setTitle("JavaFX Application");
        stage.setWidth(300);
        stage.setHeight(500);
        stage.show();
        // dit gaat het venster geven (venster = stage)
    }

    public static void main(String[] args) {
        launch();
    }
}