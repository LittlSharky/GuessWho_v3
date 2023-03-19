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
        String cssDialogFile = this.getClass().getResource("/stylesheet/dialog.css").toExternalForm();
        scene.getStylesheets().addAll(cssMainFile, cssDialogFile);
        new HomePresenter(homeView);


        URL cssFile = getClass().getResource("/stylesheet/dialog.css");
        if (cssFile == null) {
            System.err.println("Error loading CSS file");
        } else {
            System.out.println("Loaded CSS file: " + cssFile.toExternalForm());
        }

        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("JavaFX Application");
        stage.setHeight(600);
        stage.setWidth(800);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}