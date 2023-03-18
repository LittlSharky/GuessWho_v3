package be.kdg.screenreader.view.home;

import be.kdg.screenreader.model.Game;
import be.kdg.screenreader.view.game.GamePresenter;
import be.kdg.screenreader.view.game.GameView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

    private  HomeView view;
    private  Game model;
    private GameView gameView;
    private Popup choosePopup = new Popup();
    private Label choosePerson = new Label("Choose your character!");
    Button okButton;

    public HomePresenter(HomeView view) {
        this.view = view;
        this.model = model;

        this.addEventHandlers();
        this.updateView();
    }


    // eventhandler = code die een event gaat ophalen door dat er iets gebeurt met view en daar iets mee gaat doen (bv. op knop drukken)
    // update view, als er een event gebeurt dan moet er daarna iets gebeuren om het te updaten en dat is updateview
    private void addEventHandlers() {
        // hieronder is een anonimous interclass (eventhandler = interface, methodes hiervan ook implementeren)(gereplaced met lamba)
        // als je meerdere keren deze eventhandler nodig hebt dan moet je hiervoor een aparte klasse aanmaken

        this.view.getButton().setOnAction(actionEvent -> {
            gameView = new GameView();
            model = new Game();
            new GamePresenter(gameView, model);

            this.view.getScene().setRoot(gameView);
            //je vraagt het scherm op (de stage), pas het aan naar gelang de content op het scherm
            gameView.getScene().getWindow().sizeToScene();

            //modelGuesswho.setUsernameOne((view.getConfirmName()).getText());
            //choosePerson.setStyle("-fx-background-color: pink; -fx-padding: 100px; -fx-alignment: top-right");

            // create a layout container for the buttons
            VBox buttonBox = new VBox();
            buttonBox.setSpacing(10);

            // create the buttons and add them to the layout container
            okButton = new Button("OK");
            buttonBox.getChildren().addAll(choosePerson, okButton);
            buttonBox.setAlignment(Pos.CENTER);
            //add content to the popup
            choosePopup.getContent().addAll(buttonBox);
            choosePopup.show(this.gameView.getScene().getWindow());

            String username = view.getConfirmName().getText();
            Label usernameLabel = new Label(username);


            this.okButton.setOnAction(event -> {
                choosePopup.hide();
            });
        });


    }


    private void updateView() {

    }

    public Game getModel() {
        return model;
    }

}