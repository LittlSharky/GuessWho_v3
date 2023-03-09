package be.kdg.screenreader.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    // modelklasse = domme klasse die alleen maar weet waarmee hij bezig is
    Board newBoardH;
    Board newBoardC;

    List<String> notAskedQuestionHuman;


    public Game() {
        reset();
    }

    public void reset() {
        newBoardH = new Board();
        newBoardC = new Board();
    }

    public Board getHumanBoard() {
        return newBoardH;
    }

    public Board getComputerBoard() {
        return newBoardC;
    }
}

