package be.kdg.screenreader.model;

import be.kdg.screenreader.model.enums.*;

public class Board {
    private final int ROWS = 5;
    private final int COLUMNS = 4;
    private Person[][] bord;

    private boolean personConfirmed;
    private Person person;

    private Person[] array = {
            new Person(Name.PETER, HairColor.GINGER, Sex.MALE, EyeColor.BLUE, FacialHair.BOTH, Accessories.NONE, Accessories.NONE),
            new Person(Name.AMY, HairColor.GINGER, Sex.FEMALE, EyeColor.RED, FacialHair.NONE, Accessories.GLASSES, Accessories.NONE),
            new Person(Name.HARRY, HairColor.GINGER, Sex.MALE, EyeColor.BLUE, FacialHair.NONE, Accessories.GLASSES, Accessories.NONE),
            new Person(Name.DAVID, HairColor.BROWN, Sex.MALE, EyeColor.BLUE, FacialHair.MOUSTACHE, Accessories.NONE, Accessories.NONE),
            new Person(Name.THOMAS, HairColor.BLOND, Sex.MALE, EyeColor.BLUE, FacialHair.NONE, Accessories.HAT, Accessories.NONE),
            new Person(Name.SIMON, HairColor.BLOND, Sex.MALE, EyeColor.BROWN, FacialHair.BEARD, Accessories.NONE, Accessories.NONE),
            new Person(Name.PAUL, HairColor.BLOND, Sex.MALE, EyeColor.BLUE, FacialHair.MOUSTACHE, Accessories.NONE, Accessories.NONE),
            new Person(Name.KATE, HairColor.BROWN, Sex.FEMALE, EyeColor.BROWN, FacialHair.NONE, Accessories.GLASSES, Accessories.NONE),
            new Person(Name.NEIL, HairColor.GINGER, Sex.MALE, EyeColor.BROWN, FacialHair.NONE, Accessories.GLASSES, Accessories.NONE),
            new Person(Name.JOHN, HairColor.GINGER, Sex.MALE, EyeColor.BLUE, FacialHair.NONE, Accessories.GLASSES, Accessories.HAT),
            new Person(Name.ANDREW, HairColor.BALD, Sex.MALE, EyeColor.YELLOW, FacialHair.BEARD, Accessories.NONE, Accessories.NONE),
            new Person(Name.JOSHUA, HairColor.BALD, Sex.MALE, EyeColor.BLUE, FacialHair.MOUSTACHE, Accessories.NONE, Accessories.NONE),
            new Person(Name.GRAHAM, HairColor.GREY, Sex.MALE, EyeColor.BLUE, FacialHair.BEARD, Accessories.NONE, Accessories.NONE),
            new Person(Name.MICHAEL, HairColor.GREY, Sex.MALE, EyeColor.RED, FacialHair.MOUSTACHE, Accessories.NONE, Accessories.NONE),
            new Person(Name.MEGAN, HairColor.GREY, Sex.FEMALE, EyeColor.BLUE, FacialHair.NONE, Accessories.NONE, Accessories.NONE),
            new Person(Name.JENNY, HairColor.BLOND, Sex.FEMALE, EyeColor.GREEN, FacialHair.NONE, Accessories.HAT, Accessories.NONE),
            new Person(Name.ANNE, HairColor.BLOND, Sex.FEMALE, EyeColor.RED, FacialHair.NONE, Accessories.NONE, Accessories.NONE),
            new Person(Name.LUCY, HairColor.BROWN, Sex.FEMALE, EyeColor.BLUE, FacialHair.NONE, Accessories.EARRINGS, Accessories.NONE),
            new Person(Name.KEVIN, HairColor.BALD, Sex.MALE, EyeColor.BLUE, FacialHair.NONE, Accessories.NONE, Accessories.NONE),
            new Person(Name.LAUREN, HairColor.BROWN, Sex.FEMALE, EyeColor.BROWN, FacialHair.NONE, Accessories.NONE, Accessories.NONE),
    };

    public Board() {
        bord = new Person[ROWS][COLUMNS];
        this.generateBoard();
    }

    public void setChosenPerson(int y, int x) {
        this.person = bord[y][x];
    }

    public void setPersonConfirmed() {
        if(this.person == null)
            throw new IllegalArgumentException("No person chosen");
        this.personConfirmed = true;
    }

    public boolean isPersonConfirmed() {
        return personConfirmed;
    }

    public boolean isEliminated(int y, int x) {
        return bord[y][x].isEliminated();
    }

    public void setEliminated(int y, int x, boolean eliminated) {
        bord[y][x].setEliminated(eliminated);
    }

    private void generateBoard() {
        int index = 0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                this.bord[i][j] = array[index++];
            }
        }
    }
}
