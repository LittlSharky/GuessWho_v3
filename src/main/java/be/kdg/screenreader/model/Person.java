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
    private final Accessories accessories;
    private final Accessories extraAccessories;

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

    public void setEliminated(boolean eliminated) {
        this.eliminated = eliminated;
    }
    // Eliminate the person ^
    public boolean isEliminated() {
        return this.eliminated;
    }
}
