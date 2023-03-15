package be.kdg.screenreader.model;

import be.kdg.screenreader.model.enums.*;

import java.util.Arrays;
import java.util.List;

public class Question {
    private List<String> questions;

    public Question() {

        this.questions = Arrays.asList(questionArray);
    }

    public List<String> getQuestions() {
        return questions;
    }

    public boolean checkQuestion(int questionIndex) {
        switch (chosenindex) {
            case 0 -> {
                return game.boardC.getPersonC().getSex().equals(Sex.FEMALE);
            }
            case 1 -> {
                return game.boardC.getPersonC().getAccessories().equals(Accessories.GLASSES);
            }
            case 2 -> {
                return game.boardC.getPersonC().getEyeColor().equals(EyeColor.BLUE);
            }
            case 3 -> {
                return game.boardC.getPersonC().getEyeColor().equals(EyeColor.BROWN);
            }
            case 4 -> {
                return game.boardC.getPersonC().getEyeColor().equals(EyeColor.GREY);
            }
            case 5 -> {
                return game.boardC.getPersonC().getFacialHair().equals(FacialHair.BEARD)
                        || game.boardC.getPersonC().getFacialHair().equals(FacialHair.BOTH);
            }
            case 6 -> {
                return game.boardC.getPersonC().getFacialHair().equals(FacialHair.MOUSTACHE)
                        || game.boardC.getPersonC().getFacialHair().equals(FacialHair.BOTH);
            }
            case 7 -> {
                return game.boardC.getPersonC().getHairColor().equals(HairColor.BALD);
            }
            case 8 -> {
                return game.boardC.getPersonC().getHairColor().equals(HairColor.BLOND);
            }
            case 9 -> {
                return game.boardC.getPersonC().getHairColor().equals(HairColor.BLACK);
            }
            case 10 -> {
                return game.boardC.getPersonC().getHairColor().equals(HairColor.BROWN);
            }
            case 11 -> {
                return game.boardC.getPersonC().getAccessories().equals(Accessories.HAT);
            }
            default -> {
                return false;
            }
        }
    }

    private final String[] questionArray = {"Is he/she female?", "Does the person wear glasses?", "Are their eyes blue?",
            "Does the person have brown eyes?", "Are their eyes grey?", "Does he have beard?",
            "Does he have a moustache?", "Is the person bald?", "Does the person have blond hair?",
            "Does the person have black hair?", "Is their hair color brown?", "Does the person wear something on their head?"};
}
