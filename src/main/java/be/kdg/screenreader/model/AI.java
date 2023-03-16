package be.kdg.screenreader.model;

import java.util.Random;

public class AI {
    private final Game GAME;
    private boolean answerHuman;

    public AI(Game game) {
        GAME = game;
        this.computerChoosePerson(GAME.boardC.getCOLUMNS(),GAME.boardC.getROWS());
    }

    public void computerChoosePerson(int rows, int columns) {
        Random random = new Random();
        int x = random.nextInt(columns - 1);
        int y = random.nextInt(rows - 1);

        GAME.boardC.setChosenPerson(x, y);
        GAME.boardC.setPersonConfirmed();
    }
    public void play(){

    }
    public String askQuestion(){
        Random random = new Random();
        return GAME.boardC.getQuestion().getQuestions().get(random.nextInt(GAME.boardC.getQuestions().size() - 1));
    }
    public void eliminate(){
        for (Person person: GAME.boardC.getPEOPLE()){
            if(!person.isEliminated()){
                for (int index : GAME.boardC.getQuestion().getQuestionsMap().values()){
                    if(index == 0){

                    }
                }
            }
        }
    }

    public boolean isAnswerHuman() {
        return answerHuman;
    }

    public void setAnswerHuman(boolean answerHuman) {
        this.answerHuman = answerHuman;
        // in view an alert when the human must answer the question about their character -> true or false
    }
}
