package be.kdg.screenreader.model;

import be.kdg.screenreader.model.enums.*;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Question {
    private List<String> questions;
    // ^^ the one that is in the combobox
    private final TreeMap<String, Integer> questionsMap;
    // ^^ This list of questions doesn't change EVER

    public Question() {
        this.questions = new ArrayList<>();
        this.questionsMap = new TreeMap<>();
        initialQuestions();
    }

    public void initialQuestions() {
        questionsMap.put("Is he/she female?", 0);
        questionsMap.put("Does the person wear glasses?", 1);
        questionsMap.put("Are their eyes blue?", 2);
        questionsMap.put("Does the person have brown eyes?", 3);
        questionsMap.put("Are their eyes grey?", 4);
        questionsMap.put("Does he have a beard?", 5);
        questionsMap.put("Does he have a moustache?", 6);
        questionsMap.put("Is the person bald?", 7);
        questionsMap.put("Does the person have blond hair?", 8);
        questionsMap.put("Does the person have black hair?", 9);
        questionsMap.put("Is their hair color brown?", 10);
        questionsMap.put("Does the person wear something on their head?", 11);

        questions.addAll(questionsMap.keySet());
    }

    public List<String> getQuestions() {
        return questions;
    }
    public int index;
    public boolean checkQuestion(int questionIndex, Person person) {
        index = compareQuestions(questionIndex);
        switch (index) {
            case 0 -> {
                return person.getSex().equals(Sex.FEMALE);
            }
            case 1 -> {
                return   person.getAccessories().equals(Accessories.GLASSES);
            }
            case 2 -> {
                return  person.getEyeColor().equals(EyeColor.BLUE);
            }
            case 3 -> {
                return person.getEyeColor().equals(EyeColor.BROWN);
            }
            case 4 -> {
                return person.getEyeColor().equals(EyeColor.GREY);
            }
            case 5 -> {
                return  person.getExtraFacialHair().equals(FacialHair.BEARD)
                        || (person.getFacialHair().equals(FacialHair.MOUSTACHE) && person.getExtraFacialHair().equals(FacialHair.BEARD));
            }
            case 6 -> {
                return  person.getFacialHair().equals(FacialHair.MOUSTACHE)
                        ||(person.getFacialHair().equals(FacialHair.MOUSTACHE) && person.getExtraFacialHair().equals(FacialHair.BEARD));
            }
            case 7 -> {
                return person.getHairColor().equals(HairColor.BALD);
            }
            case 8 -> {
                return  person.getHairColor().equals(HairColor.BLOND);
            }
            case 9 -> {
                return  person.getHairColor().equals(HairColor.BLACK);
            }
            case 10 -> {
                return person.getHairColor().equals(HairColor.BROWN);
            }
            case 11 -> {
                return  person.getExtraAccessories().equals(Accessories.HAT);
            }
        }
        return false;
    }

    public void removeQuestion(int questionIndex) {
        this.questions.remove(questionIndex);
    }

    public int compareQuestions(int questionIndex) {
        // is going to compare the question keys from the stationary question map to the dynamic combobox question
        String askedQuestion = questions.get(questionIndex);
        return this.questionsMap.get(askedQuestion);
    }
    public int getIndex() {
        return index;
    }
}
