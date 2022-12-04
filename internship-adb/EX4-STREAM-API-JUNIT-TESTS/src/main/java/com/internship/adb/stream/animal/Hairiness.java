package com.internship.adb.stream.animal;

import lombok.Getter;

@Getter
public enum Hairiness {
    FUR("fur") {
        @Override
        public boolean isShedding() {
            return true;
        }
    },
    HAIR("hair"),
    NONE("bald");

    private final String type;

    Hairiness(String type) {
        this.type = type;
    }

    public boolean isShedding() {
        return false;
    }

    @Override
    public String toString() {
        return type;
    }
}