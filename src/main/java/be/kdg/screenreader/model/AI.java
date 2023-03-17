package be.kdg.screenreader.model;

import be.kdg.screenreader.model.enums.*;

import java.util.Random;

public class AI {
    private final Game GAME;
    private boolean answerHuman;
    private int randomquestion;
    private int counter;

    public AI(Game game) {
        GAME = game;
        resetCounter();
        this.computerChoosePerson(GAME.boardC.getCOLUMNS(), GAME.boardC.getROWS());
        resetCounter();
    }

    public void computerChoosePerson(int rows, int columns) {
        Random random = new Random();
        int x = random.nextInt(columns - 1);
        int y = random.nextInt(rows - 1);

        GAME.boardC.setChosenPerson(x, y);
        GAME.boardC.setPersonConfirmed();
        System.out.println("Computer chose: " + GAME.boardC.getChosenPerson().getName());
    }

    public void resetCounter() {
        counter = 0;
    }

    public void play() {
        askQuestion();
        removeQuestion(this.randomquestion);
        makeGuess(counter);
        for (Person person : GAME.boardC.getPEOPLE()) {
            if (!person.isEliminated()) {
                counter++;
            }
        }
        makeGuess(this.counter);
    }

    public String askQuestion() {
        Random random = new Random();
        randomquestion = random.nextInt(GAME.boardC.getQuestions().size() - 1);
        return GAME.boardC.getQuestion().getQuestions().get(randomquestion);


    }
    public void removeQuestion(int question){
        GAME.boardC.getQuestions().remove(question);
    }

    public void eliminate() {
        for (Person person : GAME.boardC.getPEOPLE()) {
            if (!person.isEliminated()) {
                for (int index : GAME.boardC.getQuestion().getQuestionsMap().values()) {
                    switch (index) {
                        case 0:
                            if (isAnswerHuman()) {
                                if (person.getSex().equals(Sex.MALE)) {
                                    person.setEliminated(true);
                                }
                            } else {
                                if (person.getSex().equals(Sex.FEMALE)) {
                                    person.setEliminated(true);
                                }
                            }

                        case 1:
                            if (isAnswerHuman()) {
                                if (!person.getAccessories().equals(Accessories.GLASSES)) {
                                    person.setEliminated(true);
                                }
                            } else {
                                if (person.getAccessories().equals(Accessories.GLASSES)) {
                                    person.setEliminated(true);
                                }
                            }
                        case 2:
                            if (isAnswerHuman()) {
                                if (!person.getEyeColor().equals(EyeColor.BLUE)) {
                                    person.setEliminated(true);
                                }
                            } else {
                                if (person.getEyeColor().equals(EyeColor.BLUE)) {
                                    person.setEliminated(true);
                                }
                            }
                        case 3:
                            if (isAnswerHuman()) {
                                if (!person.getEyeColor().equals(EyeColor.BROWN)) {
                                    person.setEliminated(true);
                                }
                            } else {
                                if (person.getEyeColor().equals(EyeColor.BROWN)) {
                                    person.setEliminated(true);
                                }
                            }
                        case 4:
                            if (isAnswerHuman()) {
                                if (!person.getEyeColor().equals(EyeColor.GREY)) {
                                    person.setEliminated(true);
                                }
                            } else {
                                if (person.getEyeColor().equals(EyeColor.GREY)) {
                                    person.setEliminated(true);
                                }
                            }
                        case 5:
                            if (isAnswerHuman()) {
                                if (!person.getFacialHair().equals(FacialHair.BEARD)) {
                                    person.setEliminated(true);
                                }

                            } else {
                                if (person.getFacialHair().equals(FacialHair.BEARD)) {
                                    person.setEliminated(true);
                                }
                            }
                        case 6:
                            if (isAnswerHuman()) {
                                if (!person.getFacialHair().equals(FacialHair.MOUSTACHE)) {
                                    person.setEliminated(true);
                                }
                            } else {
                                if (person.getFacialHair().equals(FacialHair.MOUSTACHE)) {
                                    person.setEliminated(true);
                                }
                            }
                        case 7:
                            if (isAnswerHuman()) {
                                if (!person.getHairColor().equals(HairColor.BALD)) {
                                    person.setEliminated(true);
                                }
                            } else {
                                if (person.getHairColor().equals(HairColor.BALD)) {
                                    person.setEliminated(true);
                                }
                            }
                        case 8:
                            if (isAnswerHuman()){
                                if (!person.getHairColor().equals(HairColor.BLOND)) {
                                    person.setEliminated(true);
                                }
                            }
                             else {
                                if (person.getHairColor().equals(HairColor.BLOND)) {
                                    person.setEliminated(true);
                                }
                            }
                        case 9:
                            if (isAnswerHuman()){
                                if (!person.getHairColor().equals(HairColor.BLACK)) {
                                    person.setEliminated(true);
                                }
                            }
                             else {
                                if (person.getHairColor().equals(HairColor.BLACK)) {
                                    person.setEliminated(true);
                                }
                            }
                        case 10:
                            if (isAnswerHuman()){
                                if (!person.getHairColor().equals(HairColor.BROWN)) {
                                    person.setEliminated(true);
                                }
                            }
                             else {
                                if (person.getHairColor().equals(HairColor.BROWN)) {
                                    person.setEliminated(true);
                                }
                            }
                        case 11:
                            if (isAnswerHuman()){
                                if (!person.getAccessories().equals(Accessories.HAT)){
                                    person.setEliminated(true);
                                }
                            }
                            else {
                                if (person.getAccessories().equals(Accessories.HAT)){
                                    person.setEliminated(true);
                                }
                            }
                    }
                }
            }
        }
    }
    public Person makeGuess(int counter){
        if (counter == 1) {
            for (Person person : GAME.boardC.getPEOPLE()) {
                if (!person.isEliminated()) {
                    return person;
                }
            }
        }
        return null;
    }

    public boolean isAnswerHuman() {
        return answerHuman;
    }

    public void setAnswerHuman(boolean answerHuman) {
        this.answerHuman = answerHuman;
        // in view an alert when the human must answer the question about their character -> true or false
    }
}