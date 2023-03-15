package be.kdg.screenreader.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    Board newBoardH;
    Board newBoardC;
    Question questionH;
    List<String> notAskedQuestionHuman;


    public Game() {
        reset();
    }

    public void reset() {
        newBoardH = new Board();
        newBoardC = new Board();
        questionH = new Question();
    }

    public Board getHumanBoard() {
        return newBoardH;
    }

    public Board getComputerBoard() {
        return newBoardC;
    }

    public Question getQuestionH() {
        return questionH;
    }
}

