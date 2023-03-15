package be.kdg.screenreader.model;

import be.kdg.screenreader.model.enums.*;

import java.util.Random;

public class Board {
    private final int ROWS = 4;
    private final int COLUMNS = 5;

    private final Person[][] bord;
    private Person chosenPerson;
    private boolean personConfirmed;
    private Question question;

    public Board() {
        bord = new Person[COLUMNS][ROWS];
        this.generateBoard();
    }

    private void generateBoard() {
        int index = 0;
        for (int i = 0; i < COLUMNS; i++) {
            for (int j = 0; j < ROWS; j++) {
                this.bord[i][j] = PEOPLE[index++];
            }
        }
    }

    public void setChosenPerson(int x, int y) {
        this.chosenPerson = bord[x][y];
    }

    public void setPersonConfirmed() {
        if (this.chosenPerson == null)
            throw new IllegalArgumentException("No person chosen");
        this.personConfirmed = true;
    }

    public boolean isPersonConfirmed() {
        return personConfirmed;
    }

    public boolean isEliminated(int x, int y) {
        return bord[x][y].isEliminated();
        // gives the state of the character ( eliminated / not eliminated )
    }

    public void setEliminated(int x, int y, boolean eliminated) {
        bord[x][y].setEliminated(eliminated);
        // is going to eliminate / not eliminate a person
    }

    public int getROWS() {
        return ROWS;
    }

    public int getCOLUMNS() {
        return COLUMNS;
    }

    private final Person[] PEOPLE = {
            new Person(Name.AMY, HairColor.GINGER, Sex.FEMALE, EyeColor.RED, FacialHair.NONE, Accessories.GLASSES, Accessories.NONE),
            new Person(Name.GRAHAM, HairColor.GREY, Sex.MALE, EyeColor.BLUE, FacialHair.BEARD, Accessories.NONE, Accessories.NONE),
            new Person(Name.JOSHUA, HairColor.BALD, Sex.MALE, EyeColor.BLUE, FacialHair.MOUSTACHE, Accessories.NONE, Accessories.NONE),
            new Person(Name.LUCY, HairColor.BROWN, Sex.FEMALE, EyeColor.BLUE, FacialHair.NONE, Accessories.EARRINGS, Accessories.NONE),
            new Person(Name.PAUL, HairColor.BLOND, Sex.MALE, EyeColor.BLUE, FacialHair.MOUSTACHE, Accessories.NONE, Accessories.NONE),
            new Person(Name.ANDREW, HairColor.BALD, Sex.MALE, EyeColor.YELLOW, FacialHair.BEARD, Accessories.NONE, Accessories.NONE),
            new Person(Name.HARRY, HairColor.GINGER, Sex.MALE, EyeColor.BLUE, FacialHair.NONE, Accessories.GLASSES, Accessories.NONE),
            new Person(Name.KATE, HairColor.BROWN, Sex.FEMALE, EyeColor.BROWN, FacialHair.NONE, Accessories.GLASSES, Accessories.NONE),
            new Person(Name.MEGAN, HairColor.GREY, Sex.FEMALE, EyeColor.BLUE, FacialHair.NONE, Accessories.NONE, Accessories.NONE),
            new Person(Name.PETER, HairColor.GINGER, Sex.MALE, EyeColor.BLUE, FacialHair.BOTH, Accessories.NONE, Accessories.NONE),
            new Person(Name.ANNE, HairColor.BLOND, Sex.FEMALE, EyeColor.RED, FacialHair.NONE, Accessories.NONE, Accessories.NONE),
            new Person(Name.JENNY, HairColor.BLOND, Sex.FEMALE, EyeColor.GREEN, FacialHair.NONE, Accessories.HAT, Accessories.NONE),
            new Person(Name.KEVIN, HairColor.BALD, Sex.MALE, EyeColor.BLUE, FacialHair.NONE, Accessories.NONE, Accessories.NONE),
            new Person(Name.MICHAEL, HairColor.GREY, Sex.MALE, EyeColor.RED, FacialHair.MOUSTACHE, Accessories.NONE, Accessories.NONE),
            new Person(Name.SIMON, HairColor.BLOND, Sex.MALE, EyeColor.BROWN, FacialHair.BEARD, Accessories.NONE, Accessories.NONE),
            new Person(Name.DAVID, HairColor.BROWN, Sex.MALE, EyeColor.BLUE, FacialHair.MOUSTACHE, Accessories.NONE, Accessories.NONE),
            new Person(Name.JOHN, HairColor.GINGER, Sex.MALE, EyeColor.BLUE, FacialHair.NONE, Accessories.GLASSES, Accessories.HAT),
            new Person(Name.LAUREN, HairColor.BROWN, Sex.FEMALE, EyeColor.BROWN, FacialHair.NONE, Accessories.NONE, Accessories.NONE),
            new Person(Name.NEIL, HairColor.GINGER, Sex.MALE, EyeColor.BROWN, FacialHair.NONE, Accessories.GLASSES, Accessories.NONE),
            new Person(Name.THOMAS, HairColor.BLOND, Sex.MALE, EyeColor.BLUE, FacialHair.NONE, Accessories.HAT, Accessories.NONE),
    };
}
