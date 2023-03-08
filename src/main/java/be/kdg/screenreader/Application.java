package be.kdg.screenreader;

import be.kdg.screenreader.model.Model;
import be.kdg.screenreader.view.game.GamePresenter;
import be.kdg.screenreader.view.game.GameView;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        // scenes in het begin mag hier maar naarmate de app groter wordt moet dat in de presenter

        GameView dicteeView = new GameView();
        // de scene zit in de view

        Scene scene = new Scene(dicteeView);
        // in de scene zitten nodes (buttons, text, ...)

        new GamePresenter(dicteeView,new Model());


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