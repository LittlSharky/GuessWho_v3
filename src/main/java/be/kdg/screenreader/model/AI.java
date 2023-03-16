package be.kdg.screenreader.model;

import be.kdg.screenreader.model.enums.*;

import java.util.Random;

public class AI {
    private final Game GAME;
    private boolean answerHuman;
    private int counter;

    public AI(Game game) {
        GAME = game;
        resetCounter();
        this.computerChoosePerson(GAME.boardC.getCOLUMNS(), GAME.boardC.getROWS());

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
        eliminate();
        resetCounter();
        for (Person person : GAME.boardC.getPEOPLE()) {
            if (!person.isEliminated()) {
                counter++;
            }
        }
        makeGuess(counter);
    }

    public String askQuestion() {
        Random random = new Random();
        return GAME.boardC.getQuestion().getQuestions().get(random.nextInt(GAME.boardC.getQuestions().size() - 1));
    }

    public void eliminate() {
        for (Person person : GAME.boardC.getPEOPLE()) {
            if (!person.isEliminated()) {
                for (int index : GAME.boardC.getQuestion().getQuestionsMap().values()) {
                    switch (index) {
                        case 0:
                            if (answerHuman) {
                                if (person.getSex().equals(Sex.MALE)) {
                                    person.setEliminated(true);
                                }
                            } else {
                                if (person.getSex().equals(Sex.FEMALE)) {
                                    person.setEliminated(true);
                                }
                            }

                        case 1:
                            if (answerHuman) {
                                if (!person.getAccessories().equals(Accessories.GLASSES)) {
                                    person.setEliminated(true);
                                }
                            } else {
                                if (person.getAccessories().equals(Accessories.GLASSES)) {
                                    person.setEliminated(true);
                                }
                            }
                        case 2:
                            if (answerHuman) {
                                if (!person.getEyeColor().equals(EyeColor.BLUE)) {
                                    person.setEliminated(true);
                                }
                            } else {
                                if (person.getEyeColor().equals(EyeColor.BLUE)) {
                                    person.setEliminated(true);
                                }
                            }
                        case 3:
                            if (answerHuman) {
                                if (!person.getEyeColor().equals(EyeColor.BROWN)) {
                                    person.setEliminated(true);
                                }
                            } else {
                                if (person.getEyeColor().equals(EyeColor.BROWN)) {
                                    person.setEliminated(true);
                                }
                            }
                        case 4:
                            if (answerHuman) {
                                if (!person.getEyeColor().equals(EyeColor.GREY)) {
                                    person.setEliminated(true);
                                }
                            } else {
                                if (person.getEyeColor().equals(EyeColor.GREY)) {
                                    person.setEliminated(true);
                                }
                            }
                        case 5:
                            if (answerHuman) {
                                if (!person.getFacialHair().equals(FacialHair.BEARD)) {
                                    person.setEliminated(true);
                                }

                            } else {
                                if (person.getFacialHair().equals(FacialHair.BEARD)) {
                                    person.setEliminated(true);
                                }
                            }
                        case 6:
                            if (answerHuman) {
                                if (!person.getFacialHair().equals(FacialHair.MOUSTACHE)) {
                                    person.setEliminated(true);
                                }
                            } else {
                                if (person.getFacialHair().equals(FacialHair.MOUSTACHE)) {
                                    person.setEliminated(true);
                                }
                            }
                        case 7:
                            if (answerHuman) {
                                if (!person.getHairColor().equals(HairColor.BALD)) {
                                    person.setEliminated(true);
                                }
                            } else {
                                if (person.getHairColor().equals(HairColor.BALD)) {
                                    person.setEliminated(true);
                                }
                            }
                        case 8:
                            if (answerHuman) {
                                if (!person.getHairColor().equals(HairColor.BLOND)) {
                                    person.setEliminated(true);
                                }
                            } else {
                                if (person.getHairColor().equals(HairColor.BLOND)) {
                                    person.setEliminated(true);
                                }
                            }
                        case 9:
                            if (answerHuman) {
                                if (!person.getHairColor().equals(HairColor.BLACK)) {
                                    person.setEliminated(true);
                                }
                            } else {
                                if (person.getHairColor().equals(HairColor.BLACK)) {
                                    person.setEliminated(true);
                                }
                            }
                        case 10:
                            if (answerHuman) {
                                if (!person.getHairColor().equals(HairColor.BROWN)) {
                                    person.setEliminated(true);
                                }
                            } else {
                                if (person.getHairColor().equals(HairColor.BROWN)) {
                                    person.setEliminated(true);
                                }
                            }
                        case 11:
                            if (answerHuman) {
                                if (!person.getAccessories().equals(Accessories.HAT)) {
                                    person.setEliminated(true);
                                }
                            } else {
                                if (person.getAccessories().equals(Accessories.HAT)) {
                                    person.setEliminated(true);
                                }
                            }
                    }
                }
            }
        }
    }

    public Person makeGuess(int counter) {
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