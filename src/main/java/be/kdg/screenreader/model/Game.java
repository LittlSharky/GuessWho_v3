package be.kdg.screenreader.model;

import java.util.Random;

public class Game {
    Board boardH;
    Board boardC;
    AI ai;

    public Game() {
        reset();
    }

    public void reset() {
        boardH = new Board();
        boardC = new Board();
        ai = new AI(this);
    }

    public Board getBoard(boolean human) {
        if (human)
            return boardH;
        return boardC;
    }

    public boolean checkQuestion(boolean human, int questionIndex) {
        boolean answer;
        if (human) {
            answer = boardC.checkQuestion(questionIndex);
            boardH.removeQuestion(questionIndex);
        } else {
            answer = boardH.checkQuestion(questionIndex);
            boardC.removeQuestion(questionIndex);
        }
        return answer;
    }

    public AI getAi() {
        return ai;
    }
}

