package com.internship.adb.stream.animal.utils;

import com.internship.adb.stream.animal.Animal;
import com.internship.adb.stream.animal.cat.Cat;
import com.internship.adb.stream.animal.dog.Dog;
import com.internship.adb.stream.animal.collection.implementation.CustomizedArrayList;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AnimalUtils {

    public static boolean isValidName(String name) {
        if (name == null) {
            return false;
        }
        if (name.length() < 3) {
            return false;
        }
        return name.matches("\\p{L}*");
    }

    public static List<Dog> getDogs(List<Animal> animals) {
        List<Dog> dogs = new CustomizedArrayList<>();
        if(animals != null) {
            for (Animal animal : animals) {
                if (animal instanceof Dog) {
                    dogs.add((Dog) animal);
                }
            }
        }
        return dogs;
    }

    public static List<Cat> getCats(List<Animal> animals) {
        List<Cat> cats = new CustomizedArrayList<>();
        if(animals != null) {
            for (Animal animal : animals) {
                if (animal instanceof Cat) {
                    cats.add((Cat) animal);
                }
            }
        }
        return cats;
    }
}