package be.kdg.screenreader.model;

import be.kdg.screenreader.model.enums.*;

import java.util.List;

public class Board {
    public  static int rows = 4;
    public  static int columns = 5;

    private final Person[][] board;
    private Person chosenPerson;
    // ^ chosen character by computer and human
    private boolean personConfirmed;
    // ^ boolean for button to choose your character (if you haven't chosen anyone yet you can't ask questions or make a guess)
    private Person guessPerson;
    // ^ character guessed by the human
    private Question question;
    // ^ attribute per question
    private int index = 0;

    public Board() {
        board = new Person[columns][rows];
        this.question = new Question();
        this.generateBoard(false);
    }

    public Board(boolean bigBoard) {
        board = new Person[5][5];
        this.question = new Question();
        this.generateBoard(bigBoard);
    }

    private void generateBoard(boolean bigBoard) {
        if (!bigBoard) {
            for (int i = 0; i < columns; i++) {
                for (int j = 0; j < rows; j++) {
                    this.board[i][j] = PEOPLE[index++];
                }
            }
        } else {
            columns = 5;
            rows = 5;
            for (int i = 0; i < columns; i++) {
                for (int j = 0; j < rows; j++) {
                    this.board[i][j] = NEW_PEOPLE[index++];
                }
            }
        }
    }


    public void setChosenPerson(int x, int y) {
        this.chosenPerson = board[x][y];
    }
    // ^ to choose your character

    public void setPersonConfirmed() {
        if (this.chosenPerson == null)
            throw new IllegalArgumentException("No person chosen");
        this.personConfirmed = true;
    }

    public boolean isPersonConfirmed() {
        return personConfirmed;
    }
    // ^ to know if you already chose your character (true -> already chose)


    public boolean checkQuestion(int questionIndex, Person person) {
        return this.question.checkQuestion(questionIndex, person);
        // ^ compare the two lists of question to get the right index of the question
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
    // ^ for human to set guessPerson (view gives you the coordinates)

    public Person getGuessPerson() {
        return this.guessPerson;
    }

    public boolean checkWin(Person guessPerson) {
        return guessPerson.getName().equals(this.chosenPerson.getName());
    }

    public int getROWS() {
        return rows;
    }

    public int getCOLUMNS() {
        return columns;
    }

    public List<String> getQuestions() {
        return this.question.getQuestions();
    }

    public Question getQuestion() {
        return question;
    }

    private final Person[] NEW_PEOPLE = {
            new Person(Name.AMY, HairColor.GINGER, Sex.FEMALE, EyeColor.RED, FacialHair.NONE, FacialHair.NONE, Accessories.GLASSES, Accessories.HAT),
            new Person(Name.ANDREW, HairColor.BALD, Sex.MALE, EyeColor.YELLOW, FacialHair.NONE, FacialHair.BEARD, Accessories.NONE, Accessories.NONE),
            new Person(Name.ANNE, HairColor.BLOND, Sex.FEMALE, EyeColor.RED, FacialHair.NONE, FacialHair.NONE, Accessories.NONE, Accessories.NONE),
            new Person(Name.DAVID, HairColor.BROWN, Sex.MALE, EyeColor.BLUE, FacialHair.MOUSTACHE, FacialHair.NONE, Accessories.NONE, Accessories.NONE),
            new Person(Name.GRAHAM, HairColor.GREY, Sex.MALE, EyeColor.BLUE, FacialHair.NONE, FacialHair.BEARD, Accessories.NONE, Accessories.NONE),
            new Person(Name.HARRY, HairColor.GINGER, Sex.MALE, EyeColor.BLUE, FacialHair.NONE, FacialHair.NONE, Accessories.NONE, Accessories.NONE),
            new Person(Name.JENNY, HairColor.BLOND, Sex.FEMALE, EyeColor.GREEN, FacialHair.NONE, FacialHair.NONE, Accessories.NONE, Accessories.HAT),
            new Person(Name.JOHN, HairColor.GINGER, Sex.MALE, EyeColor.BLUE, FacialHair.NONE, FacialHair.NONE, Accessories.GLASSES, Accessories.HAT),
            new Person(Name.JOSHUA, HairColor.BALD, Sex.MALE, EyeColor.BLUE, FacialHair.MOUSTACHE, FacialHair.NONE, Accessories.NONE, Accessories.NONE),
            new Person(Name.KATE, HairColor.BROWN, Sex.FEMALE, EyeColor.BLUE, FacialHair.NONE, FacialHair.NONE, Accessories.GLASSES, Accessories.NONE),
            new Person(Name.KEVIN, HairColor.BALD, Sex.MALE, EyeColor.BLUE, FacialHair.NONE, FacialHair.NONE, Accessories.NONE, Accessories.NONE),
            new Person(Name.LAUREN, HairColor.BROWN, Sex.FEMALE, EyeColor.RED, FacialHair.NONE, FacialHair.NONE, Accessories.NONE, Accessories.NONE),
            new Person(Name.LUCY, HairColor.BROWN, Sex.FEMALE, EyeColor.BLUE, FacialHair.NONE, FacialHair.NONE, Accessories.EARRINGS, Accessories.NONE),
            new Person(Name.MEGAN, HairColor.GREY, Sex.FEMALE, EyeColor.GREEN, FacialHair.NONE, FacialHair.NONE, Accessories.NONE, Accessories.NONE),
            new Person(Name.MICHAEL, HairColor.GREY, Sex.MALE, EyeColor.RED, FacialHair.MOUSTACHE, FacialHair.NONE, Accessories.NONE, Accessories.NONE),
            new Person(Name.NEIL, HairColor.GINGER, Sex.MALE, EyeColor.BROWN, FacialHair.NONE, FacialHair.NONE, Accessories.NONE, Accessories.NONE),
            new Person(Name.PAUL, HairColor.BLOND, Sex.MALE, EyeColor.BLUE, FacialHair.MOUSTACHE, FacialHair.NONE, Accessories.NONE, Accessories.NONE),
            new Person(Name.PETER, HairColor.GINGER, Sex.MALE, EyeColor.BLUE, FacialHair.MOUSTACHE, FacialHair.BEARD, Accessories.NONE, Accessories.HAT),
            new Person(Name.SIMON, HairColor.BLOND, Sex.MALE, EyeColor.BROWN, FacialHair.NONE, FacialHair.BEARD, Accessories.NONE, Accessories.NONE),
            new Person(Name.THOMAS, HairColor.BLOND, Sex.MALE, EyeColor.BLUE, FacialHair.NONE, FacialHair.NONE, Accessories.NONE, Accessories.HAT),
            new Person(Name.SARAH, HairColor.GINGER, Sex.FEMALE, EyeColor.BLUE, FacialHair.NONE, FacialHair.NONE, Accessories.GLASSES, Accessories.HAT),
            new Person(Name.EMMA, HairColor.BLOND, Sex.FEMALE, EyeColor.BLUE, FacialHair.NONE, FacialHair.NONE, Accessories.NONE, Accessories.HAT),
            new Person(Name.DANIEL, HairColor.BROWN, Sex.MALE, EyeColor.BROWN, FacialHair.NONE, FacialHair.NONE, Accessories.GLASSES, Accessories.NONE),
            new Person(Name.RICHARD, HairColor.BALD, Sex.MALE, EyeColor.BLUE, FacialHair.NONE, FacialHair.NONE, Accessories.GLASSES, Accessories.NONE),
            new Person(Name.TEST, HairColor.BALD, Sex.MALE, EyeColor.BLUE, FacialHair.NONE, FacialHair.NONE, Accessories.GLASSES, Accessories.NONE)
    };

    private final Person[] PEOPLE = {
            new Person(Name.AMY, HairColor.GINGER, Sex.FEMALE, EyeColor.RED, FacialHair.NONE, FacialHair.NONE, Accessories.GLASSES, Accessories.HAT),
            new Person(Name.ANDREW, HairColor.BALD, Sex.MALE, EyeColor.YELLOW, FacialHair.NONE, FacialHair.BEARD, Accessories.NONE, Accessories.NONE),
            new Person(Name.ANNE, HairColor.BLOND, Sex.FEMALE, EyeColor.RED, FacialHair.NONE, FacialHair.NONE, Accessories.NONE, Accessories.NONE),
            new Person(Name.DAVID, HairColor.BROWN, Sex.MALE, EyeColor.BLUE, FacialHair.MOUSTACHE, FacialHair.NONE, Accessories.NONE, Accessories.NONE),
            new Person(Name.GRAHAM, HairColor.GREY, Sex.MALE, EyeColor.BLUE, FacialHair.NONE, FacialHair.BEARD, Accessories.NONE, Accessories.NONE),
            new Person(Name.HARRY, HairColor.GINGER, Sex.MALE, EyeColor.BLUE, FacialHair.NONE, FacialHair.NONE, Accessories.NONE, Accessories.NONE),
            new Person(Name.JENNY, HairColor.BLOND, Sex.FEMALE, EyeColor.GREEN, FacialHair.NONE, FacialHair.NONE, Accessories.NONE, Accessories.HAT),
            new Person(Name.JOHN, HairColor.GINGER, Sex.MALE, EyeColor.BLUE, FacialHair.NONE, FacialHair.NONE, Accessories.GLASSES, Accessories.HAT),
            new Person(Name.JOSHUA, HairColor.BALD, Sex.MALE, EyeColor.BLUE, FacialHair.MOUSTACHE, FacialHair.NONE, Accessories.NONE, Accessories.NONE),
            new Person(Name.KATE, HairColor.BROWN, Sex.FEMALE, EyeColor.BLUE, FacialHair.NONE, FacialHair.NONE, Accessories.GLASSES, Accessories.NONE),
            new Person(Name.KEVIN, HairColor.BALD, Sex.MALE, EyeColor.BLUE, FacialHair.NONE, FacialHair.NONE, Accessories.NONE, Accessories.NONE),
            new Person(Name.LAUREN, HairColor.BROWN, Sex.FEMALE, EyeColor.RED, FacialHair.NONE, FacialHair.NONE, Accessories.NONE, Accessories.NONE),
            new Person(Name.LUCY, HairColor.BROWN, Sex.FEMALE, EyeColor.BLUE, FacialHair.NONE, FacialHair.NONE, Accessories.EARRINGS, Accessories.NONE),
            new Person(Name.MEGAN, HairColor.GREY, Sex.FEMALE, EyeColor.GREEN, FacialHair.NONE, FacialHair.NONE, Accessories.NONE, Accessories.NONE),
            new Person(Name.MICHAEL, HairColor.GREY, Sex.MALE, EyeColor.RED, FacialHair.MOUSTACHE, FacialHair.NONE, Accessories.NONE, Accessories.NONE),
            new Person(Name.NEIL, HairColor.GINGER, Sex.MALE, EyeColor.BROWN, FacialHair.NONE, FacialHair.NONE, Accessories.NONE, Accessories.NONE),
            new Person(Name.PAUL, HairColor.BLOND, Sex.MALE, EyeColor.BLUE, FacialHair.MOUSTACHE, FacialHair.NONE, Accessories.NONE, Accessories.NONE),
            new Person(Name.PETER, HairColor.GINGER, Sex.MALE, EyeColor.BLUE, FacialHair.MOUSTACHE, FacialHair.BEARD, Accessories.NONE, Accessories.HAT),
            new Person(Name.SIMON, HairColor.BLOND, Sex.MALE, EyeColor.BROWN, FacialHair.NONE, FacialHair.BEARD, Accessories.NONE, Accessories.NONE),
            new Person(Name.THOMAS, HairColor.BLOND, Sex.MALE, EyeColor.BLUE, FacialHair.NONE, FacialHair.NONE, Accessories.NONE, Accessories.HAT)
    };

    public Person[] getPEOPLE() {
        return PEOPLE;
    }

    public Person[] getNEW_PEOPLE() {
        return NEW_PEOPLE;
    }

    public Person[] getPeople(boolean isBiggerBoard) {
        return isBiggerBoard ? NEW_PEOPLE : PEOPLE;
    }

    public Person getChosenPerson() {
        return chosenPerson;
    }

}
