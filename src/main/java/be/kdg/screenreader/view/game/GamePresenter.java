package be.kdg.screenreader.view.game;

import be.kdg.screenreader.model.Game;
import be.kdg.screenreader.model.Question;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;

public class GamePresenter {
    // elke view/scene heeft zijn eigen presenter (home met homepresenter, game met gamepresenter)
    // bij grote applicaties -> per view en presenter een package aanmaken
    // moet ook weten van het model

    private final GameView view;
    private GameQuestionView gameQuestionView = new GameQuestionView();
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
                    // to eliminate / de-eliminate characters
                } else {
                    view.setConfirmedPerson(person.getPhoto());
                    model.getHumanBoard().setChosenPerson(person.getCOORD_X(), person.getCOORD_Y());
                    // if a character is not chosen yet as chosenPerson
                }
            });
        });

        this.view.getConfirmPerson().setOnAction(actionEvent -> {
            try {
                model.getHumanBoard().setPersonConfirmed();
                this.view.getConfirmPerson().setDisable(true);
                model.getComputerBoard().computerChoosePerson();
            } catch (Exception e) {
                Alert alertNotChosen = new Alert(Alert.AlertType.ERROR);
                alertNotChosen.setTitle("ERROR");
                alertNotChosen.setContentText(e.getMessage());
                alertNotChosen.showAndWait();
            }
        });
       /* this.gameQuestionView.getComboBoxQuestion().setOnAction(actionEvent -> {
            ComboBox<String> comboBox = gameQuestionView.getComboBoxQuestion();
            comboBox.getParent().requestFocus();
            gameQuestionView.getComboBoxQuestion().getSelectionModel().getSelectedIndex();
            model.getHumanBoard().isChosenQuestion(gameQuestionView.getComboBoxQuestion().getSelectionModel().getSelectedIndex());
            comboBox.getParent().getParent().requestFocus();
        });*/

        this.view.getGameQuestionView().getComboBoxQuestion().setOnAction(actionEvent -> {
            ComboBox<String> comboBox = this.view.getGameQuestionView().getComboBoxQuestion();
            comboBox.getParent().requestFocus();
            this.view.getGameQuestionView().getComboBoxQuestion().getSelectionModel().getSelectedIndex();
        });


        this.view.getConfirmQuestion().setOnAction(actionEvent -> {
            int questionIndex = this.view.getGameQuestionView().getComboBoxQuestion().getSelectionModel().getSelectedIndex();

            //No question selected
            if (questionIndex != -1) {
                this.view.getGameQuestionView().setChosenQuestion(model.getQuestionH().isChosenQuestion(gameQuestionView.getIndex()));
            }
        });
    }

    private void updateView() {
        this.view.getGameGrid().getChildren().forEach(node -> {
            GamePersonView person = (GamePersonView) node;
            person.setEliminated((model.getBoard(true).isEliminated(person.getCOORD_X(), person.getCOORD_Y())));
        });
     /*   this.view.getGameQuestionView().getComboBoxQuestion().getItems().forEach(item -> {
            GameQuestionView questionView = (GameQuestionView) item;
            questionView.setChosenQuestion(model.getQuestionH().isChosenQuestion(questionView.getIndex()));
        });*/
    }

}

