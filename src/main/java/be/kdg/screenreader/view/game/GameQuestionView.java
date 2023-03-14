package be.kdg.screenreader.view.game;

import be.kdg.screenreader.model.Question;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class GameQuestionView {
    private Question question;
    private ComboBox comboBoxQuestion;
    private ObservableList<String> questionObservable;
    private int index;

    public GameQuestionView() {
        this.question = new Question();
        this.comboBoxQuestion = new ComboBox<>();
        this.questionObservable = FXCollections.observableArrayList(question.getListQuestion());
        this.comboBoxQuestion.setItems(questionObservable);
    }

    public ComboBox getComboBoxQuestion() {
        return comboBoxQuestion;
    }
    public boolean checkedQuestion(int index){
        this.index = index;
        question.checkedQuestion(this.index);
        return false;
    }
}
