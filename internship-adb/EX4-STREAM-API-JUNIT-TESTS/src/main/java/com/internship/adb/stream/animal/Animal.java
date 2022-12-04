package com.internship.adb.stream.animal;

import com.internship.adb.stream.animal.utils.AnimalUtils;
import lombok.Getter;

@Getter
public abstract class Animal {

    protected String name;
    protected Hairiness hairiness;
    protected int weight;

    protected Animal(String name, Hairiness hairiness, int weight) {
        if (AnimalUtils.isValidName(name)) {
            this.name = name;
        }
        this.hairiness = hairiness;
        this.weight = Math.max(weight, 1);
    }

    public abstract void speak();

    public abstract void move();

    @Override
    public String toString() {
        return this.getClass().getSimpleName()
                + " -> [" + this.name
                + "], [" + this.hairiness
                + "], [" + this.weight + "kg]";
    }
}