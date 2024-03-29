package be.kdg.screenreader.view.home;

import be.kdg.screenreader.model.Game;
import be.kdg.screenreader.model.InvalidInputException;
import be.kdg.screenreader.view.game.GamePresenter;
import be.kdg.screenreader.view.game.GameView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.PopupWindow;
import javafx.stage.Screen;
import javafx.stage.Window;

public class HomePresenter {
    // elke view/scene heeft zijn eigen presenter (home met homepresenter, game met gamepresenter)
    // bij grote applicaties -> per view en presenter een package aanmaken
    // moet ook weten van het model

    private HomeView view;
    private Game model;
    private GameView gameView;
    private Dialog<String> dialogChooseCharacter;
    private String username;
    private Dialog<String> dialog;

    public HomePresenter(HomeView view) {
        this.view = view;

        this.addEventHandlers();
        this.updateView();
    }


    // eventhandler = code die een event gaat ophalen door dat er iets gebeurt met view en daar iets mee gaat doen (bv. op knop drukken)
    // update view, als er een event gebeurt dan moet er daarna iets gebeuren om het te updaten en dat is updateview
    private void addEventHandlers() {
        // hieronder is een anonimous interclass (eventhandler = interface, methodes hiervan ook implementeren)(gereplaced met lamba)
        // als je meerdere keren deze eventhandler nodig hebt dan moet je hiervoor een aparte klasse aanmaken

        this.view.getButton().setOnAction(actionEvent -> {
            try {
                this.username = view.getConfirmName().getText();
                gameView = new GameView(this.username,false);
                model = new Game(false);
                model.setUsername(this.username);
                this.view.getScene().setRoot(gameView);
                gameView.getScene().getWindow().sizeToScene();
                //je vraagt het scherm op (de stage), pas het aan naar gelang de content op het scherm

                new GamePresenter(gameView, model).howToPlayDialog();
                //When showing the new scene, dialog of How To Play is shown as well.
                dialogChooseCharacter = new Dialog<>();
                dialogChooseCharacter.getDialogPane().getScene().getStylesheets().add(getClass().getResource("/stylesheet/dialog.css").toExternalForm());
                dialogChooseCharacter.setTitle("TO DO!");
                dialogChooseCharacter.setHeaderText("Choose your character!");
                dialogChooseCharacter.getDialogPane();
                ButtonType okButton = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
                dialogChooseCharacter.getDialogPane().getButtonTypes().add(okButton);
                dialogChooseCharacter.showAndWait();

            } catch (InvalidInputException e) {
                Alert alertBlank = new Alert(Alert.AlertType.ERROR);
                alertBlank.setTitle("Blank username!");
                alertBlank.setContentText(e.getMessage());
                alertBlank.showAndWait();
            }
        });
    }

    private void updateView() {

    }
}