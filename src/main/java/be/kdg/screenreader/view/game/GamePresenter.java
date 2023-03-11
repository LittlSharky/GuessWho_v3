package be.kdg.screenreader.view.game;

import be.kdg.screenreader.model.Game;
import javafx.scene.control.Alert;

public class GamePresenter {
    // elke view/scene heeft zijn eigen presenter (home met homepresenter, game met gamepresenter)
    // bij grote applicaties -> per view en presenter een package aanmaken
    // moet ook weten van het model

    private final GameView view;
    private final Game model;

    public GamePresenter(GameView view, Game model) {
        this.view = view;
        this.model = model;

        this.addEventHandlers();
    }

    // eventhandler = code die een event gaat ophalen door dat er iets gebeurt met view en daar iets mee gaat doen (bv. op knop drukken)
    // update view, als er een event gebeurt dan moet er daarna iets gebeuren om het te updaten en dat is updateview
    private void addEventHandlers() {
        // hieronder is een anonimous interclass (eventhandler = interface, methodes hiervan ook implementeren)(gereplaced met lamba)
        // als je meerdere keren deze eventhandler nodig hebt dan moet je hiervoor een aparte klasse aanmaken

        this.view.getGameGrid().getChildren().forEach(node -> {
            node.setOnMouseClicked(mouseEvent -> {
                GamePersonView person = (GamePersonView) node;
                if (model.getHumanBoard().isPersonConfirmed()) {
                    model.getHumanBoard()
                            .setEliminated(person.getCOORD_X(), person.getCOORD_Y(),
                                    !model.getHumanBoard().isEliminated(person.getCOORD_X(), person.getCOORD_Y()));
                    updateView();
                } else {
                    view.setConfirmedPerson(person.getPhoto());
                    model.getHumanBoard().setChosenPerson(person.getCOORD_X(), person.getCOORD_Y());
                }
            });
        });

        this.view.getConfirmPerson().setOnAction(actionEvent -> {
            try {
                model.getHumanBoard().setPersonConfirmed();
                this.view.getConfirmPerson().setDisable(true);
            } catch (Exception e) {
                Alert alertNotChosen = new Alert(Alert.AlertType.ERROR);
                alertNotChosen.setTitle("ERROR");
                alertNotChosen.setContentText(e.getMessage());
                alertNotChosen.showAndWait();
            }
        });
    }

    private void updateView() {
        this.view.getGameGrid().getChildren().forEach(node -> {
            GamePersonView person = (GamePersonView) node;
            person.setEliminated((model.getHumanBoard().isEliminated(person.getCOORD_X(), person.getCOORD_Y())));
        });
    }
};
