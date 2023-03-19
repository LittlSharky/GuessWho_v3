package be.kdg.screenreader.view.game;

import be.kdg.screenreader.model.Game;
import javafx.collections.FXCollections;
import javafx.scene.control.*;

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
        this.view.getConfirmQuestion().setDisable(true);
        this.view.getGuessButton().setDisable(true);
        this.view.getEndTurn().setDisable(true);

    }

    // eventhandler = code die een event gaat ophalen door dat er iets gebeurt met view en daar iets mee gaat doen (bv. op knop drukken)
    // update view, als er een event gebeurt dan moet er daarna iets gebeuren om het te updaten en dat is updateview
    private void addEventHandlers() {
        // hieronder is een anonimous interclass (eventhandler = interface, methodes hiervan ook implementeren)(gereplaced met lamba)
        // als je meerdere keren deze eventhandler nodig hebt dan moet je hiervoor een aparte klasse aanmaken
        this.view.getHowToPlay().setOnAction(actionEvent -> {
            Dialog<String> dialog = new Dialog<>();
            dialog.getDialogPane().getScene().getStylesheets().add(getClass().getResource("/stylesheet/dialog.css").toExternalForm());
            dialog.setTitle("How To Play");
            dialog.setHeaderText("Instruction");
            dialog.setContentText("This is a game where you have to guess the character of your opponent.\n" +
                    "1. The  player and the computer chooses a character.\n"+
                    "2. The computer and the player has to guess the character of each other.\n"+
                    "3. The questions are only yes or no answers.\n"+
                    "4. The player is always going to start with a question. The computer will answer with Yes or No.\n"+
                    "5. Then the player can click on the images to eliminate the characters.\n"+
                    "6. Ending your turn by clicking on the button 'End Turn'.\n"+
                    "7. The Computer will ask you a question. A popup will show with the question that has been asked and you have to answer it with Yes or No by clicking on the button.\n"+
                    "8. The player can take a guess whenever he or she wants.\n"+
                    "9. You can win the game by guessing right or the computer guesses wrong.\n\n"+
                    "NOTE: You can only guess when it is your turn. When you guess wrong, the computer will win the game. The same goes for the computer.");


            dialog.getDialogPane();

            ButtonType okButton = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().add(okButton);
            dialog.showAndWait();
        });
        this.view.getExit().setOnAction(actionEvent -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Exit");
            alert.setContentText("Are you sure you want to exit?");
            ButtonType yesButton = new ButtonType("Yes");
            ButtonType cancelButton = new ButtonType("Cancel");
            alert.getButtonTypes().setAll(yesButton, cancelButton);
            alert.showAndWait().ifPresent(response -> {
                if (response == yesButton) {
                    System.exit(0);
                }
            });
        });

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
            this.view.getConfirmQuestion().setDisable(false);
            this.view.getGuessButton().setDisable(false);
            this.view.getEndTurn().setDisable(false);
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
            this.view.getConfirmQuestion().setDisable(true);
            this.view.getGuessButton().setDisable(true);
        });

        this.view.getEndTurn().setOnAction(actionEvent -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Question computer:");
            alert.setContentText(model.getAi().askQuestion());
            ButtonType trueButton = new ButtonType("True");
            ButtonType falseButton = new ButtonType("False");
            alert.getButtonTypes().setAll(trueButton, falseButton);
            alert.showAndWait().ifPresent(response -> {
                model.getAi().setAnswerHumanQuestion(response == trueButton);
            });
            model.checkQuestion(false,model.getAi().getRandomquestion());

            model.getAi().play();
            this.view.getConfirmQuestion().setDisable(false);
            this.view.getGuessButton().setDisable(false);
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
                            if (model.checkWin(true, model.getBoard(true).getGuessPerson())) {
                                Alert alertWin = new Alert(Alert.AlertType.INFORMATION);
                                alertWin.setTitle("You win!");
                                alertWin.setContentText("You guessed the right person! Congrats! You won the game.");
                                alertWin.showAndWait();
                                //return to rootscene
                            } else{
                            Alert alertLose = new Alert(Alert.AlertType.INFORMATION);
                            alertLose.setTitle("You lose!");
                            alertLose.setContentText("You guessed the wrong person! Unfortunately you did not win this game...");
                            alertLose.showAndWait();
                            //return to rootscene
                        }
                    }
                } else{
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

