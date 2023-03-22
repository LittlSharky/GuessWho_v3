package be.kdg.screenreader.view.game;

import be.kdg.screenreader.model.Game;
import javafx.collections.FXCollections;
import javafx.scene.Node;
import javafx.scene.control.*;

public class GamePresenter {
    private final GameView view;
    private final Game model;
    private Dialog<String> dialog;

    public GamePresenter(GameView view, Game model) {
        this.view = view;
        this.model = model;

        this.addEventHandlers();
        this.updateView();
        this.view.getConfirmQuestion().setDisable(true);
        this.view.getGuessButton().setDisable(true);
        this.view.getEndTurn().setDisable(true);

    }

    private void addEventHandlers() {
        //NEW GAME
        this.view.getNewGame().setOnAction(actionEvent -> {
            this.model.reset(false);
            this.view.getConfirmPerson().setDisable(false);
            this.view.getConfirmQuestion().setDisable(true);
            this.view.getGuessButton().setDisable(true);
            this.view.getEndTurn().setDisable(true);
            this.updateView();
        });
        //LOAD GAME
        this.view.getLoadGame().setOnAction(actionEvent -> {
            //loadgamelogic
        });
        //SAVE GAME
        this.view.getSaveGame().setOnAction(actionEvent -> {
            //savegamelogic
        });
        //EXIT ALERT
        this.view.getExit().setOnAction(actionEvent -> {
            Alert alertExit = new Alert(Alert.AlertType.CONFIRMATION);
            alertExit.setTitle("Exit");
            alertExit.setContentText("Are you sure you want to exit?");
            ButtonType yesButton = new ButtonType("Yes");
            ButtonType cancelButton = new ButtonType("Cancel");
            alertExit.getButtonTypes().setAll(yesButton, cancelButton);
            alertExit.showAndWait().ifPresent(response -> {
                if (response == yesButton) {
                    System.exit(0);
                }
            });
        });
        //HOW TO PLAY DIALOG
        this.view.getHowToPlay().setOnAction(actionEvent -> {
            this.dialog = new Dialog<>();
            this.dialog.getDialogPane().getScene().getStylesheets().add(getClass().getResource("/stylesheet/dialog.css").toExternalForm());
            this.dialog.setTitle("How To Play");
            this.dialog.setHeaderText("Instruction");
            this.dialog.setContentText("This is a game where you have to guess the character of your opponent.\n" +
                    "1. The  player and the computer chooses a character.\n" +
                    "2. The computer and the player has to guess the character of each other.\n" +
                    "3. The questions are only yes or no answers.\n" +
                    "4. The player is always going to start with a question. The computer will answer with Yes or No.\n" +
                    "5. Then the player can click on the images to eliminate the characters.\n" +
                    "6. Ending your turn by clicking on the button 'End Turn'.\n" +
                    "7. The Computer will ask you a question. A popup will show with the question that has been asked and you have to answer it with Yes or No by clicking on the button.\n" +
                    "8. The player can take a guess whenever he or she wants.\n" +
                    "9. You can win the game by guessing right or the computer guesses wrong.\n\n" +
                    "NOTE: You can only guess when it is your turn. When you guess wrong, the computer will win the game. The same goes for the computer.");
            this.dialog.getDialogPane();
            ButtonType okButton = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
            this.dialog.getDialogPane().getButtonTypes().add(okButton);
            this.dialog.showAndWait();
        });
        //RULES DIALOG
        this.view.getRules().setOnAction(actionEvent -> {
            this.dialog = new Dialog<>();
            this.dialog.getDialogPane().getScene().getStylesheets().add(getClass().getResource("/stylesheet/dialog.css").toExternalForm());
            this.dialog.setTitle("Rules");
            this.dialog.setHeaderText("Rules");
            this.dialog.setContentText("1. You need to choose a character!\n" +
                    "2. You either choose a question or you take a guess!\n" +
                    "3. You cannot take a guess when it is not your turn!\n");
            this.dialog.getDialogPane();
            ButtonType okButton = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
            this.dialog.getDialogPane().getButtonTypes().add(okButton);
            this.dialog.showAndWait();
        });
        //INFO DIALOG
        this.view.getInfo().setOnAction(actionEvent -> {
            this.dialog = new Dialog<>();
            this.dialog.getDialogPane().getScene().getStylesheets().add(getClass().getResource("/stylesheet/dialog.css").toExternalForm());
            this.dialog.setTitle("About");
            this.dialog.setHeaderText("INFO");
            this.dialog.setContentText("This game is made by:\n" +
                    "Emma Bogaerts & Sharon Chung\n" +
                    "For the course 'JavaFX' at Karel de Grote Hogeschool for an oral exam presentation \n" +
                    "Made in the year 2023.");
            this.dialog.getDialogPane();
            ButtonType okButton = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
            this.dialog.getDialogPane().getButtonTypes().add(okButton);
            this.dialog.showAndWait();
        });
        //BIGGER BOARD
        this.view.getBiggerBoard().setOnAction(actionEvent -> {
            this.view.reset(true);
            this.model.reset(true);
            this.view.getBiggerBoard().setSelected(true);
            this.view.getConfirmPerson().setDisable(false);
            this.view.getConfirmQuestion().setDisable(false);
            this.view.getGuessButton().setDisable(false);
            this.view.getEndTurn().setDisable(false);
            this.addEventHandlers();
            this.view.getScene().getWindow().sizeToScene();
            updateView();
        });

        //ELIMINATE OR DE-ELIMINATE CHARACTERS OR CHOOSE A CHARACTER
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
        //CONFIRM PERSON
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
        //CONFIRM QUESTION
        this.view.getConfirmQuestion().setOnAction(actionEvent -> {
            int questionIndex = this.view.getComboBoxQuestion().getSelectionModel().getSelectedIndex();
            //No question selected
            if (questionIndex != -1) {
                boolean answer = this.model.checkQuestion(true, questionIndex);
                Alert answerAlert = new Alert(Alert.AlertType.INFORMATION);
                answerAlert.setTitle("Answer");
                answerAlert.setContentText("The answer to your question is: " + (answer ? "Yes" : "No"));
                answerAlert.showAndWait();
                this.updateView();
                this.view.getConfirmQuestion().setDisable(true);
                this.view.getGuessButton().setDisable(true);
            } else {
                Alert alertNotChosen = new Alert(Alert.AlertType.ERROR);
                alertNotChosen.setTitle("ERROR");
                alertNotChosen.setContentText("You need to choose a question!");
                alertNotChosen.showAndWait();
            }
        });
        //END TURN
        this.view.getEndTurn().setOnAction(actionEvent -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Question computer:");
            if (!model.isBiggerBoard()) {
                model.getAi().checkCounter();
                if (model.getAi().getCounter() == 20) {
                    alert.setContentText(model.getBoard(false).getQuestion().getQuestions().get(0));
                    //^ will always be the first question that is going to be asked to make him less stupid
                    ButtonType trueButton = new ButtonType("True");
                    ButtonType falseButton = new ButtonType("False");
                    alert.getButtonTypes().setAll(trueButton, falseButton);
                    alert.showAndWait().ifPresent(response -> {
                        model.getAi().setAnswerHumanQuestion(response == trueButton);
                        // ^ simplified if that sets trueButton true on setAnswerHuman
                    });
                    model.checkQuestion(false, 0);
                    model.getAi().play();
                } else if (model.getAi().getCounter() > 1) {
                    alert.setContentText(model.getAi().askQuestion());
                    ButtonType trueButton = new ButtonType("True");
                    ButtonType falseButton = new ButtonType("False");
                    alert.getButtonTypes().setAll(trueButton, falseButton);
                    alert.showAndWait().ifPresent(response -> {
                        model.getAi().setAnswerHumanQuestion(response == trueButton);
                        // ^ simplified if that sets trueButton true on setAnswerHuman
                    });
                    model.checkQuestion(false, model.getAi().getRandomquestion());
                    // ^ removes question (doesn't use answer)
                    model.getAi().play();
                } else {
                    model.getAi().makeGuess();
                    if (model.checkWin(false, model.getAi().getGuessPerson())) {
                        Alert alertLose = new Alert(Alert.AlertType.INFORMATION);
                        alertLose.setTitle("The computer wins by guessing " + model.getAi().getGuessPerson().getName() + "!");
                        alertLose.setContentText(" You lose, you snooze. The computer guessed the right person");
                        alertLose.showAndWait();
                    } else {
                        Alert alertWin = new Alert(Alert.AlertType.INFORMATION);
                        alertWin.setTitle("You win! The person guessed: " + model.getAi().getGuessPerson().getName());
                        alertWin.setContentText(" The computer guessed the wrong person! AI isn't that far yet sorry");
                        alertWin.showAndWait();
                    }
                }
            } else {
                if (model.getAi().getCounter() == 25) {
                    alert.setContentText(model.getBoard(false).getQuestion().getQuestions().get(0));
                    //^ will always be the first question that is going to be asked to make him less stupid
                    ButtonType trueButton = new ButtonType("True");
                    ButtonType falseButton = new ButtonType("False");
                    alert.getButtonTypes().setAll(trueButton, falseButton);
                    alert.showAndWait().ifPresent(response -> {
                        model.getAi().setAnswerHumanQuestion(response == trueButton);
                        // ^ simplified if that sets trueButton true on setAnswerHuman
                    });
                    model.checkQuestion(false, 0);
                    model.getAi().play();
                } else if (model.getAi().getCounter() > 1) {
                    alert.setContentText(model.getAi().askQuestion());
                    ButtonType trueButton = new ButtonType("True");
                    ButtonType falseButton = new ButtonType("False");
                    alert.getButtonTypes().setAll(trueButton, falseButton);
                    alert.showAndWait().ifPresent(response -> {
                        model.getAi().setAnswerHumanQuestion(response == trueButton);
                        // ^ simplified if that sets trueButton true on setAnswerHuman
                    });
                    model.checkQuestion(false, model.getAi().getRandomquestion());
                    // ^ removes question (doesn't use answer)
                    model.getAi().play();
                } else {
                    model.getAi().makeGuess();
                    if (model.checkWin(false, model.getAi().getGuessPerson())) {
                        Alert alertLose = new Alert(Alert.AlertType.INFORMATION);
                        alertLose.setTitle("The computer wins by guessing " + model.getAi().getGuessPerson().getName() + "!");
                        alertLose.setContentText(" You lose, you snooze. The computer guessed the right person");
                        alertLose.showAndWait();
                    } else {
                        Alert alertWin = new Alert(Alert.AlertType.INFORMATION);
                        alertWin.setTitle("You win! The person guessed: " + model.getAi().getGuessPerson().getName());
                        alertWin.setContentText(" The computer guessed the wrong person! AI isn't that far yet sorry");
                        alertWin.showAndWait();
                    }
                }
            }
            this.view.getConfirmQuestion().setDisable(false);
            this.view.getGuessButton().setDisable(false);
        });
        //GUESS BUTTON
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
                                alertWin.setContentText("You chose: " + model.getBoard(true).getGuessPerson().getName() +
                                        " You guessed the right person! Congrats! You won the game.");
                                alertWin.showAndWait();
                                //return to rootscene
                            } else {
                                Alert alertLose = new Alert(Alert.AlertType.INFORMATION);
                                alertLose.setTitle("You lose!");
                                alertLose.setContentText("You chose: " + model.getBoard(true).getGuessPerson().getName() +
                                        " You guessed the wrong person! Unfortunately you did not win this game...");
                                alertLose.showAndWait();
                                //return to rootscene
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
                // ^ fills combobox with questions with list
        );

    }
}

