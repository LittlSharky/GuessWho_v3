package be.kdg.screenreader.model;

import java.util.Random;

public class Game {
    Board boardH;
    Board boardC;

    public Game() {
        reset();
    }

    public void reset() {
        boardH = new Board();
        boardC = new Board();
    }

    public Board getBoard(boolean human) {
        if (human)
            return boardH;
        return boardC;
    }

    public boolean checkQuestion(boolean human, int questionIndex) {
        if (human)
            return boardC.checkQuestion(questionIndex);
        return boardH.checkQuestion(questionIndex);
    }

    //TODO move to AI class
    public void computerChoosePerson() {
        Random random = new Random();
        int x = random.nextInt(this.boardC.getCOLUMNS() - 1);
        int y = random.nextInt(this.boardC.getROWS() - 1);

        this.boardC.setChosenPerson(x, y);
        this.boardC.setPersonConfirmed();
    }
}

