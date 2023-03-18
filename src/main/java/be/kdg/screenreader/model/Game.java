package be.kdg.screenreader.model;

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
            answer = boardH.checkQuestion(questionIndex,boardC.getChosenPerson());
            boardH.removeQuestion(questionIndex);
        } else {
            answer = boardC.checkQuestion(questionIndex, boardH.getChosenPerson());
            boardC.removeQuestion(questionIndex);
        }
        return answer;
    }

    public boolean checkWin(boolean human, Person guessPerson) {
        boolean win;
        if (human) {
            win = boardC.checkWin(guessPerson);
            System.out.println(guessPerson.getName());
        } else {
            win = boardH.checkWin(guessPerson);
            System.out.println(guessPerson.getName());
        }
        return win;
    }

    public AI getAi() {
        return ai;
    }
}

