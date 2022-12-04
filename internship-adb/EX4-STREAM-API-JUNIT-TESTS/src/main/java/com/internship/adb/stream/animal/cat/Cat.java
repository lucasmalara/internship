package com.internship.adb.stream.animal.cat;

import com.internship.adb.stream.animal.Hairiness;
import com.internship.adb.stream.animal.Animal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cat extends Animal {

    protected CatHunterSense hunterSense;

    public Cat(String name, Hairiness hairiness, int weight, CatHunterSense hunterSense) {
        super(name, hairiness, weight);
        if(hairiness == Hairiness.HAIR) {
            this.hairiness = Hairiness.FUR;
        }
        this.hunterSense = hunterSense;
    }

    public void scratchScratchingPost() {
        System.out.println("Scratch... scratch...");
    }

    public int getHunterSensePower() {
        return hunterSense.getSensePower();
    }

    @Override
    public void speak() {
        System.out.println("Meow meow");
    }

    @Override
    public void move() {
        System.out.println("Follow my lead, human.");
    }

    @Override
    public String toString() {
       return super.toString() + ", [" + this.hunterSense + "]";
    }
}
