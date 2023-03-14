package be.kdg.screenreader.model;

import java.util.Arrays;
import java.util.List;

public class Question {
    private Game game = new Game();
    private Board boardH = game.getHumanBoard();
    String[] questions = {"Is he/she female?","Does the person wear glasses?", "Are their eyes blue?",
            "Does the person have brown eyes?", "Are their eyes grey?","Does he have beard?",
            "Does he have a moustache?", "Is the person bald?", "Does the person have blond hair?",
            "Does the person have black hair?", "Is their hair color brown?", "Does the person wear something on their head?"};

    List<String> listQuestion = Arrays.asList(questions);

    public List<String> getListQuestion() {
        return listQuestion;
    }

    public String getQuestion(int index) {
        return listQuestion.get(index);
    }


}
