package com.internship.adb.stream.animal.cat;

import lombok.Getter;

@Getter
public enum CatHunterSense {
    WEAK("I play hunts with toys only.", 0) {
        @Override
        public boolean doesHuntMice() {
            return false;
        }
    },
    AVERAGE("Mice, do not come to my house...I will hunt you down.", 1),
    MEDIUM("I even go outside to hunt.", 2) {
        @Override
        public boolean doesHuntBirds() {
            return true;
        }
    };

    private final String description;
    private final int sensePower;

    CatHunterSense(String description, int sensePower) {
        this.description = description;
        this.sensePower = sensePower;
    }

    public boolean doesHuntMice() {
        return true;
    }

    public static int getMaxPossible() {
        int currentMax = -1;
        for (CatHunterSense sense : CatHunterSense.values()) {
            int sensePower = sense.getSensePower();
            if(sensePower > currentMax) {
                currentMax = sensePower;
            }
        }
        return currentMax;
    }

    public boolean doesHuntBirds() {
        return false;
    }

    @Override
    public String toString() {
        return description;
    }
}