package be.kdg.screenreader.view.game;

import be.kdg.screenreader.model.Game;
import be.kdg.screenreader.model.Question;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;

public class GameQuestionView {
    private Question question;
    private ComboBox<String> comboBoxQuestion;
    private ObservableList<String> questionObservable;
    private int index;
    private boolean chosenQuestion;

    public GameQuestionView() {
        this.question = new Question();
        this.comboBoxQuestion = new ComboBox<String>();
        this.questionObservable =  FXCollections.observableArrayList(question.getListQuestion());
        this.comboBoxQuestion.setItems(questionObservable);
        this.chosenQuestion = false;

    }
    public ComboBox<String> getComboBoxQuestion() {
        return comboBoxQuestion;
    }

    public boolean checkedQuestion(int index) {
        this.index = index;
        return question.checkedQuestion(index);
    }

    public int getIndex() {
        return index;
    }
    public void setChosenQuestion(boolean chosenQuestion) {
        this.chosenQuestion = chosenQuestion;
        Alert alertNotChosen = new Alert(Alert.AlertType.INFORMATION);
        alertNotChosen.setTitle("INFO");
        if (chosenQuestion) {
            alertNotChosen.setContentText("True");
            alertNotChosen.showAndWait();
        } else {
            alertNotChosen.setContentText("False");
            alertNotChosen.showAndWait();
        }
    }
}
