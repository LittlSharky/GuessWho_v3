package be.kdg.screenreader.view.game;

import be.kdg.screenreader.model.Game;
import be.kdg.screenreader.model.Question;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;

import java.lang.reflect.Type;

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
        this.updateView();
    }

    // eventhandler = code die een event gaat ophalen door dat er iets gebeurt met view en daar iets mee gaat doen (bv. op knop drukken)
    // update view, als er een event gebeurt dan moet er daarna iets gebeuren om het te updaten en dat is updateview
    private void addEventHandlers() {
        // hieronder is een anonimous interclass (eventhandler = interface, methodes hiervan ook implementeren)(gereplaced met lamba)
        // als je meerdere keren deze eventhandler nodig hebt dan moet je hiervoor een aparte klasse aanmaken

        this.view.getGameGrid().getChildren().forEach(node -> {
            node.setOnMouseClicked(mouseEvent -> {
                GamePersonView person = (GamePersonView) node;
                if (model.getBoard(true).isPersonConfirmed()) {
                    model.getBoard(true)
                            .setEliminated(person.getCOORD_X(), person.getCOORD_Y(),
                                    !model.getBoard(true).isEliminated(person.getCOORD_X(), person.getCOORD_Y()));
                    updateView();
                    // to eliminate / de-eliminate characters
                } else {
                    view.setConfirmedPerson(person.getPhoto());
                    model.getBoard(true).setChosenPerson(person.getCOORD_X(), person.getCOORD_Y());
                    // if a character is not chosen yet as chosenPerson
                }
            });
        });

        this.view.getConfirmPerson().setOnAction(actionEvent -> {
            try {
                model.getBoard(true).setPersonConfirmed();
                this.view.getConfirmPerson().setDisable(true);
            } catch (Exception e) {
                Alert alertNotChosen = new Alert(Alert.AlertType.ERROR);
                alertNotChosen.setTitle("ERROR");
                alertNotChosen.setContentText(e.getMessage());
                alertNotChosen.showAndWait();
            }
        });

        this.view.getConfirmQuestion().setOnAction(actionEvent -> {
            int questionIndex = this.view.getComboBoxQuestion().getSelectionModel().getSelectedIndex();
            //No question selected
            if (questionIndex != -1) {
                boolean answer = this.model.checkQuestion(true, questionIndex);

                Alert answerAlert = new Alert(Alert.AlertType.INFORMATION);
                answerAlert.setTitle("Answer");
                answerAlert.setContentText("Het antwoord op uw vraag is: " + (answer ? "Ja" : "Nee"));
                answerAlert.showAndWait();

                this.updateView();
            }
        });

        this.view.getEndTurn().setOnAction(actionEvent -> {
            model.getAi().play();
        });
        this.view.getGuessButton().setOnAction(actionEvent -> {
            this.view.getGameGrid().getChildren().forEach(node -> {
                GamePersonView person = (GamePersonView) node;
                node.setOnMouseClicked(mouseEvent -> {
                    if (this.view.getGuessButton().isSelected()) {
                        if (model.getBoard(true).isEliminated(person.getCOORD_X(), person.getCOORD_Y())) {
                            Alert alertNotAvailble = new Alert(Alert.AlertType.ERROR);
                            alertNotAvailble.setTitle("ERROR");
                            alertNotAvailble.setContentText("This person has been eliminated and can't be chose as a guess. Please choose another, uneliminate it or end your turn.");
                            alertNotAvailble.showAndWait();
                        } else {
                            model.getBoard(true).setGuessPerson(person.getCOORD_X(), person.getCOORD_Y());
                            if (model.checkWin(true, model.getBoard(true).getGuessPerson())){
                                Alert alertWin = new Alert(Alert.AlertType.INFORMATION);
                                alertWin.setTitle("You win!");
                                alertWin.setContentText("You guessed the right person!");
                                alertWin.showAndWait();
                            } else {
                                Alert alertLose = new Alert(Alert.AlertType.INFORMATION);
                                alertLose.setTitle("You lose!");
                                alertLose.setContentText("You guessed the wrong person!");
                                alertLose.showAndWait();
                            }
                        }
                    } else {
                        model.getBoard(true)
                                .setEliminated(person.getCOORD_X(), person.getCOORD_Y(),
                                        !model.getBoard(true).isEliminated(person.getCOORD_X(), person.getCOORD_Y()));
                        updateView();
                    }
                });
            });
        });
    }

    private void updateView() {
        this.view.getGameGrid().getChildren().forEach(node -> {
            GamePersonView person = (GamePersonView) node;
            person.setEliminated((model.getBoard(true).isEliminated(person.getCOORD_X(), person.getCOORD_Y())));
        });
        this.view.getComboBoxQuestion().setItems(
                FXCollections.observableArrayList(model.getBoard(true).getQuestions())
        );
    }
}

