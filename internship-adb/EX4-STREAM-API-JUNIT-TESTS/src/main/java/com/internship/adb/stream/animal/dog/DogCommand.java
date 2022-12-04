package com.internship.adb.stream.animal.dog;

import lombok.Getter;

@Getter
public enum DogCommand {
    BARK("bark"),
    GIVE_A_PAW("give a paw"),
    GO_FETCH("go fetch"),
    GUARD("guard"),
    SEARCH("search"),
    SIT("sit"),
    STAY("stay");

    private final String typeOfCommand;

    DogCommand(String typeOfCommand) {
        this.typeOfCommand = typeOfCommand;
    }

    @Override
    public String toString() {
        return typeOfCommand;
    }
}