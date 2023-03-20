package be.kdg.screenreader.model;

import be.kdg.screenreader.model.enums.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Person {
    private final Name name;
    private final HairColor hairColor;
    private final Sex sex;
    private final EyeColor eyeColor;
    private final FacialHair facialHair;
    private final FacialHair extraFacialHair;
    private final Accessories accessories;
    private final Accessories extraAccessories;
    private boolean eliminated;

    public Person(Name name, HairColor hairColor, Sex sex, EyeColor eyeColor, FacialHair facialHair, FacialHair extraFacialHair, Accessories accessories, Accessories extraAccessories) {
        this.name = name;
        this.hairColor = hairColor;
        this.sex = sex;
        this.eyeColor = eyeColor;
        this.facialHair = facialHair;
        this.extraFacialHair = extraFacialHair;
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

    public EyeColor getEyeColor() {
        return eyeColor;
    }

    public FacialHair getFacialHair() {
        return facialHair;
    }

    public FacialHair getExtraFacialHair() {
        return extraFacialHair;
    }

    public Sex getSex() {
        return sex;
    }

    public Accessories getExtraAccessories() {
        return extraAccessories;
    }

    public void setEliminated(boolean eliminated) {
        this.eliminated = eliminated;
    }
    // Eliminate the person ^
    public boolean isEliminated() {
        return this.eliminated;
    }
    public boolean getEliminated() {
        return this.eliminated;
    }
}
