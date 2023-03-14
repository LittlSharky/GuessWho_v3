package be.kdg.screenreader.model;

import be.kdg.screenreader.model.enums.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Person {
    private Name name;
    private HairColor hairColor;
    private Sex sex;
    private EyeColor eyeColor;
    private FacialHair facialHair;
    private Accessories accessories;
    private Accessories extraAccessories;
    private int coordX;
    private int coordY;
    private boolean eliminated;

    public Person(Name name, HairColor hairColor, Sex sex, EyeColor eyeColor, FacialHair facialHair, Accessories accessories, Accessories extraAccessories) {
        this.name = name;
        this.hairColor = hairColor;
        this.sex = sex;
        this.eyeColor = eyeColor;
        this.facialHair = facialHair;
        this.accessories = accessories;
        this.extraAccessories = extraAccessories;
        this.eliminated = false;
    }

    public Name getName() {
        return name;
    }

    public HairColor getHairColor() {
        return hairColor;
    }

    public Accessories getAccessories() {
        return accessories;
    }

    public Accessories getExtraAccessories() {
        return extraAccessories;
    }

    public EyeColor getEyeColor() {
        return eyeColor;
    }

    public FacialHair getFacialHair() {
        return facialHair;
    }

    public Sex getSex() {
        return sex;
    }

    public int getCoordX() {
        return coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }

    public void setEliminated(boolean eliminated) {
        this.eliminated = eliminated;
    }
    // Eliminate the person ^
    public boolean isEliminated() {
        return this.eliminated;
    }
}
