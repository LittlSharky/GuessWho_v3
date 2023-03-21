package be.kdg.screenreader.model;

import be.kdg.screenreader.model.enums.*;

import java.util.Random;

public class AI {
    private final Game GAME;
    private boolean answerHumanQuestion;
    private int randomquestion;
    private int counter;
    private Person guessPerson;

    public AI(Game game) {
        GAME = game;
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

    public int getRandomquestion() {
        return randomquestion;
    }

    public void play() {
        eliminate(GAME.boardC.getQuestion().getIndex());
    }

    public String askQuestion() {
        Random random = new Random();
        this.randomquestion = random.nextInt(GAME.boardC.getQuestions().size() - 1);
        return GAME.boardC.getQuestion().getQuestions().get(randomquestion);
    }

    public void eliminate(int index) {
        for (Person person : GAME.boardC.getPEOPLE()) {
            switch (index) {
                case 0 -> {
                    if (isAnswerHumanQuestion()) {
                        if (person.getSex().equals(Sex.MALE)) {
                            person.setEliminated(true);
                        }
                    } else {
                        if (person.getSex().equals(Sex.FEMALE)) {
                            person.setEliminated(true);
                        }
                    }
                }
                case 1 -> {
                    if (isAnswerHumanQuestion()) {
                        if (!person.getAccessories().equals(Accessories.GLASSES)) {
                            person.setEliminated(true);
                        }
                    } else {
                        if (person.getAccessories().equals(Accessories.GLASSES)) {
                            person.setEliminated(true);
                        }
                    }
                }
                case 2 -> {
                    if (isAnswerHumanQuestion()) {
                        if (!person.getEyeColor().equals(EyeColor.BLUE)) {
                            person.setEliminated(true);
                        }
                    } else {
                        if (person.getEyeColor().equals(EyeColor.BLUE)) {
                            person.setEliminated(true);
                        }
                    }
                }
                case 3 -> {
                    if (isAnswerHumanQuestion()) {
                        if (!person.getEyeColor().equals(EyeColor.BROWN)) {
                            person.setEliminated(true);
                        }
                    } else {
                        if (person.getEyeColor().equals(EyeColor.BROWN)) {
                            person.setEliminated(true);
                        }
                    }
                }
                case 4 -> {
                    if (isAnswerHumanQuestion()) {
                        if (!person.getEyeColor().equals(EyeColor.GREY)) {
                            person.setEliminated(true);
                        }
                    } else {
                        if (person.getEyeColor().equals(EyeColor.GREY)) {
                            person.setEliminated(true);
                        }
                    }
                }
                case 5 -> {
                    if (isAnswerHumanQuestion()) {
                        if (!person.getExtraFacialHair().equals(FacialHair.BEARD)
                                || (!person.getFacialHair().equals(FacialHair.MOUSTACHE) && !person.getExtraFacialHair().equals(FacialHair.BEARD))) {
                            person.setEliminated(true);
                        }
                    } else {
                        if (person.getExtraFacialHair().equals(FacialHair.BEARD)
                                || (person.getFacialHair().equals(FacialHair.MOUSTACHE) && person.getExtraFacialHair().equals(FacialHair.BEARD))) {
                            person.setEliminated(true);
                        }
                    }
                }
                case 6 -> {
                    if (isAnswerHumanQuestion()) {
                        if (!person.getFacialHair().equals(FacialHair.MOUSTACHE)
                                || (!person.getFacialHair().equals(FacialHair.MOUSTACHE) && !person.getExtraFacialHair().equals(FacialHair.BEARD))) {
                            person.setEliminated(true);
                        }
                    } else {
                        if (person.getFacialHair().equals(FacialHair.MOUSTACHE)
                                || (person.getFacialHair().equals(FacialHair.MOUSTACHE) && person.getExtraFacialHair().equals(FacialHair.BEARD))) {
                            person.setEliminated(true);
                        }
                    }
                }
                case 7 -> {
                    if (isAnswerHumanQuestion()) {
                        if (!person.getHairColor().equals(HairColor.BALD)) {
                            person.setEliminated(true);
                        }
                    } else {
                        if (person.getHairColor().equals(HairColor.BALD)) {
                            person.setEliminated(true);
                        }
                    }
                }
                case 8 -> {
                    if (isAnswerHumanQuestion()) {
                        if (!person.getHairColor().equals(HairColor.BLOND)) {
                            person.setEliminated(true);
                        }
                    } else {
                        if (person.getHairColor().equals(HairColor.BLOND)) {
                            person.setEliminated(true);
                        }
                    }
                }
                case 9 -> {
                    if (isAnswerHumanQuestion()) {
                        if (!person.getHairColor().equals(HairColor.BLACK)) {
                            person.setEliminated(true);
                        }
                    } else {
                        if (person.getHairColor().equals(HairColor.BLACK)) {
                            person.setEliminated(true);
                        }
                    }
                }
                case 10 -> {
                    if (isAnswerHumanQuestion()) {
                        if (!person.getHairColor().equals(HairColor.BROWN)) {
                            person.setEliminated(true);
                        }
                    } else {
                        if (person.getHairColor().equals(HairColor.BROWN)) {
                            person.setEliminated(true);
                        }
                    }
                }
                case 11 -> {
                    if (isAnswerHumanQuestion()) {
                        if (!person.getExtraAccessories().equals(Accessories.HAT)) {
                            person.setEliminated(true);
                        }
                    } else {
                        if (person.getExtraAccessories().equals(Accessories.HAT)) {
                            person.setEliminated(true);
                        }
                    }
                }
            }
        }
    }

    public void checkCounter() {
        resetCounter();
        for (Person person : GAME.boardC.getPEOPLE()) {
            if (!person.isEliminated()) {
                this.counter++;
            }
        }
    }

    public void makeGuess() {
        checkCounter();
        for (Person person : GAME.boardC.getPEOPLE()) {
            if (!person.getEliminated()) {
                this.guessPerson = person;
            }
        }
    }

    public boolean isAnswerHumanQuestion() {
        return answerHumanQuestion;
    }
    // ^ True or false from human about questions computer (getter for model)

    public void setAnswerHumanQuestion(boolean answerHumanQuestion) {
        this.answerHumanQuestion = answerHumanQuestion;
        // in presenter an alert when the human must answer the question about their character -> true or false
    }

    public int getCounter() {
        return counter;
    }

    public Person getGuessPerson() {
        return guessPerson;
    }
}