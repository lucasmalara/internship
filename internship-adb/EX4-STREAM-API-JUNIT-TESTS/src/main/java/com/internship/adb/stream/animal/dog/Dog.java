package com.internship.adb.stream.animal.dog;


import com.internship.adb.stream.animal.Hairiness;
import com.internship.adb.stream.animal.Animal;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Dog extends Animal {

    protected List<DogCommand> dogCommands = new ArrayList<>();

    public Dog(String name, Hairiness hairiness, int weight) {
        super(name, hairiness, weight);
    }

    public Dog(String name, Hairiness hairiness, int weight, List<DogCommand> dogCommands) {
        this(name, hairiness, weight);
        this.dogCommands = dogCommands;
    }

    public int countLearntCommands() {
        return dogCommands.size();
    }

    public void learnNewCommand(DogCommand dogCommand) {
        dogCommands.add(dogCommand);
    }

    public void learnNewCommands(List<DogCommand> dogCommands) {
        if (dogCommands != null) {
            for (DogCommand dogCommand : dogCommands) {
                learnNewCommand(dogCommand);
            }
        }
    }

    @Override
    public void speak() {
        System.out.println("Woof woof");
    }

    @Override
    public void move() {
        System.out.println("I'll follow you, human.");
    }

    @Override
    public String toString() {
        return super.toString() + ", " + this.dogCommands;
    }
}