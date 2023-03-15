package be.kdg.screenreader.view.game;

import be.kdg.screenreader.model.Question;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

import java.util.concurrent.atomic.AtomicInteger;

public class GameQuestionView {
    private Question question;
    private ComboBox<String> comboBoxQuestion;
    private ObservableList<String> questionObservable;
    private int index;

    public GameQuestionView() {
        this.question = new Question();
        this.comboBoxQuestion = new ComboBox<>();
        this.questionObservable = FXCollections.observableArrayList(question.getListQuestion());
        this.comboBoxQuestion.setItems(questionObservable);
    }

    public ComboBox<String> getComboBoxQuestion() {
        return comboBoxQuestion;
    }
    public boolean checkedQuestion(AtomicInteger index){
        this.index = index.get();
        return question.checkedQuestion(this.index);
    }
}
