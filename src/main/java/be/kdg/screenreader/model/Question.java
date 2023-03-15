package be.kdg.screenreader.model;

import be.kdg.screenreader.model.enums.*;

import java.util.Arrays;
import java.util.List;

public class Question {
    private Game game;
    private int chosenIndex;
    private Question[] question;
    private boolean chosenQuestion;
    private Question questionH;
    private boolean questionConfirmed;
    private List<String> listQuestion;

    public Question() {
        String[] questions = {"Is he/she female?", "Does the person wear glasses?", "Are their eyes blue?",
                "Does the person have brown eyes?", "Are their eyes grey?", "Does he have beard?",
                "Does he have a moustache?", "Is the person bald?", "Does the person have blond hair?",
                "Does the person have black hair?", "Is their hair color brown?", "Does the person wear something on their head?"};
        this.listQuestion = Arrays.asList(questions);
        this.chosenQuestion = false;
    }

    public List<String> getListQuestion() {
        return listQuestion;
    }

    public String getQuestion(int index) {
        return listQuestion.get(index);
    }

    public void setQuestionConfirmed() {
        if (this.questionH == null)
            throw new IllegalArgumentException("Question is null");
        this.questionConfirmed = true;
    }
    public boolean isQuestionConfirmed() {
        return this.questionConfirmed;
    }

    public void setChosenQuestion(boolean chosenQuestion) {
        this.chosenQuestion = chosenQuestion;
    }

    public boolean isChosenQuestion() {
        return this.chosenQuestion;
    }

    public boolean isChosenQuestion(int index) {
        this.chosenIndex = index;
        return question[index].isChosenQuestion();
    }

    public void setChosenQuestion(int index, boolean chosenQuestion) {
        this.chosenIndex = index;
        question[index].setChosenQuestion(chosenQuestion); //question choose
    }

    public int getChosenIndex() {
        return chosenIndex;
    }

    public boolean checkedQuestion(int chosenindex) {
        this.chosenIndex = chosenindex;
        switch (chosenindex) {
            case 0 -> {
                return game.newBoardC.getPersonC().getSex().equals(Sex.FEMALE);
            }
            case 1 -> {
                return game.newBoardC.getPersonC().getAccessories().equals(Accessories.GLASSES);
            }
            case 2 -> {
                return game.newBoardC.getPersonC().getEyeColor().equals(EyeColor.BLUE);
            }
            case 3 -> {
                return game.newBoardC.getPersonC().getEyeColor().equals(EyeColor.BROWN);
            }
            case 4 -> {
                return game.newBoardC.getPersonC().getEyeColor().equals(EyeColor.GREY);
            }
            case 5 -> {
                return game.newBoardC.getPersonC().getFacialHair().equals(FacialHair.BEARD)
                        || game.newBoardC.getPersonC().getFacialHair().equals(FacialHair.BOTH);
            }
            case 6 -> {
                return game.newBoardC.getPersonC().getFacialHair().equals(FacialHair.MOUSTACHE)
                        || game.newBoardC.getPersonC().getFacialHair().equals(FacialHair.BOTH);
            }
            case 7 -> {
                return game.newBoardC.getPersonC().getHairColor().equals(HairColor.BALD);
            }
            case 8 -> {
                return game.newBoardC.getPersonC().getHairColor().equals(HairColor.BLOND);
            }
            case 9 -> {
                return game.newBoardC.getPersonC().getHairColor().equals(HairColor.BLACK);
            }
            case 10 -> {
                return game.newBoardC.getPersonC().getHairColor().equals(HairColor.BROWN);
            }
            case 11 -> {
                return game.newBoardC.getPersonC().getAccessories().equals(Accessories.HAT);
            }
            default -> {
                return false;
            }
        }
    }
}
