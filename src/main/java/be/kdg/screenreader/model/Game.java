package be.kdg.screenreader.model;

public class Game {
    Board boardH;
    Board boardC;
    AI ai;
    private boolean isBiggerBoard = false;
    private String username;

    public Game() {
        reset(isBiggerBoard);
    }

    public void reset(boolean isBiggerBoard){
        if(!isBiggerBoard){
            boardH = new Board();
            boardC = new Board();
            ai = new AI(this);
        }else{
            boardH = new Board(true);
            boardC = new Board(true);
            ai = new AI(this);
        }

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
        } else {
            win = boardH.checkWin(guessPerson);
        }
        return win;
    }

    public AI getAi() {
        return ai;
    }

    public void setUsername(String username) {
        if (username.isBlank()){
            throw new InvalidInputException("Username can't be blank!");
        } else {
            this.username = username;
        }
    }
}

