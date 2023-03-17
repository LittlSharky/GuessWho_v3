package be.kdg.screenreader.model;

import be.kdg.screenreader.model.enums.*;

import java.util.List;

public class Board {
    public static final int ROWS = 4;
    public static final int COLUMNS = 5;

    private final Person[][] board;
    private Person chosenPerson;
    private boolean personConfirmed;
    private Person guessPerson;
    private Question question;

    public Board() {
        board = new Person[COLUMNS][ROWS];
        this.question = new Question();
        this.generateBoard();
    }

    private void generateBoard() {
        int index = 0;
        for (int i = 0; i < COLUMNS; i++) {
            for (int j = 0; j < ROWS; j++) {
                this.board[i][j] = PEOPLE[index++];
            }
        }
    }

    public void setChosenPerson(int x, int y) {
        this.chosenPerson = board[x][y];
    }

    public void setPersonConfirmed() {
        if (this.chosenPerson == null)
            throw new IllegalArgumentException("No person chosen");
        this.personConfirmed = true;
    }

    public boolean isPersonConfirmed() {
        return personConfirmed;
    }


    public boolean checkQuestion(int questionIndex) {
        return this.question.checkQuestion(questionIndex, this.chosenPerson);
    }

    public void removeQuestion(int questionIndex) {
        this.question.removeQuestion(questionIndex);
    }

    public boolean isEliminated(int x, int y) {
        return board[x][y].isEliminated();
        // gives the state of the character ( eliminated / not eliminated )
    }

    public void setEliminated(int x, int y, boolean eliminated) {
        board[x][y].setEliminated(eliminated);
        // is going to eliminate / not eliminate a person
    }

    public void setGuessPerson(int x, int y) {
        this.guessPerson = board[x][y];
    }

    public Person getGuessPerson() {
        return guessPerson;
    }

    public boolean checkWin(Person guessPerson) {
        boolean isCorrect = guessPerson.getName().equals(this.chosenPerson.getName());
        return isCorrect;
    }

    public int getROWS() {
        return ROWS;
    }

    public int getCOLUMNS() {
        return COLUMNS;
    }

    public List<String> getQuestions() {
        return this.question.getQuestions();
    }

    public Question getQuestion() {
        return question;
    }

    private final Person[] PEOPLE = {
            new Person(Name.AMY, HairColor.GINGER, Sex.FEMALE, EyeColor.RED, FacialHair.NONE, Accessories.GLASSES, Accessories.HAT),
            new Person(Name.ANDREW, HairColor.BALD, Sex.MALE, EyeColor.YELLOW, FacialHair.BEARD, Accessories.NONE, Accessories.NONE),
            new Person(Name.ANNE, HairColor.BLOND, Sex.FEMALE, EyeColor.RED, FacialHair.NONE, Accessories.NONE, Accessories.NONE),
            new Person(Name.DAVID, HairColor.BROWN, Sex.MALE, EyeColor.BLUE, FacialHair.MOUSTACHE, Accessories.NONE, Accessories.NONE),
            new Person(Name.GRAHAM, HairColor.GREY, Sex.MALE, EyeColor.BLUE, FacialHair.BEARD, Accessories.NONE, Accessories.NONE),
            new Person(Name.HARRY, HairColor.GINGER, Sex.MALE, EyeColor.BLUE, FacialHair.NONE, Accessories.NONE, Accessories.NONE),
            new Person(Name.JENNY, HairColor.BLOND, Sex.FEMALE, EyeColor.GREEN, FacialHair.NONE, Accessories.NONE, Accessories.HAT),
            new Person(Name.JOHN, HairColor.GINGER, Sex.MALE, EyeColor.BLUE, FacialHair.NONE, Accessories.GLASSES, Accessories.HAT),
            new Person(Name.JOSHUA, HairColor.BALD, Sex.MALE, EyeColor.BLUE, FacialHair.MOUSTACHE, Accessories.NONE, Accessories.NONE),
            new Person(Name.KATE, HairColor.BROWN, Sex.FEMALE, EyeColor.BLUE, FacialHair.NONE, Accessories.GLASSES, Accessories.NONE),
            new Person(Name.KEVIN, HairColor.BALD, Sex.MALE, EyeColor.BLUE, FacialHair.NONE, Accessories.NONE, Accessories.NONE),
            new Person(Name.LAUREN, HairColor.BROWN, Sex.FEMALE, EyeColor.RED, FacialHair.NONE, Accessories.NONE, Accessories.NONE),
            new Person(Name.LUCY, HairColor.BROWN, Sex.FEMALE, EyeColor.BLUE, FacialHair.NONE, Accessories.EARRINGS, Accessories.NONE),
            new Person(Name.MEGAN, HairColor.GREY, Sex.FEMALE, EyeColor.GREEN, FacialHair.NONE, Accessories.NONE, Accessories.NONE),
            new Person(Name.MICHAEL, HairColor.GREY, Sex.MALE, EyeColor.RED, FacialHair.MOUSTACHE, Accessories.NONE, Accessories.NONE),
            new Person(Name.NEIL, HairColor.GINGER, Sex.MALE, EyeColor.BROWN, FacialHair.NONE, Accessories.NONE, Accessories.NONE),
            new Person(Name.PAUL, HairColor.BLOND, Sex.MALE, EyeColor.BLUE, FacialHair.MOUSTACHE, Accessories.NONE, Accessories.NONE),
            new Person(Name.PETER, HairColor.GINGER, Sex.MALE, EyeColor.BLUE, FacialHair.BOTH, Accessories.NONE, Accessories.HAT),
            new Person(Name.SIMON, HairColor.BLOND, Sex.MALE, EyeColor.BROWN, FacialHair.BEARD, Accessories.NONE, Accessories.NONE),
            new Person(Name.THOMAS, HairColor.BLOND, Sex.MALE, EyeColor.BLUE, FacialHair.NONE, Accessories.NONE, Accessories.HAT),
    };

    public Person[] getPEOPLE() {
        return PEOPLE;
    }

    public Person getChosenPerson() {
        return chosenPerson;
    }
}
