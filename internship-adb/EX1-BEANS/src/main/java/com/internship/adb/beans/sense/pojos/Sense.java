package com.internship.adb.beans.sense.pojos;

abstract class Sense {

    protected final String aboutMe;

    protected Sense(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getMessage() {
        return aboutMe;
    }
}