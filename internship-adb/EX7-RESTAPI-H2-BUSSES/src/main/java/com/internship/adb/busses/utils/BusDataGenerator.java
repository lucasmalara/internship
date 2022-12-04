package com.internship.adb.busses.utils;

import com.internship.adb.busses.model.EngineModelType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BusDataGenerator {

    private static final String[] BRANDS = loadBrands();
    private static final String[] MODELS = loadModels();

    private static final Random RANDOM = new Random();

    public static String getRandomBrand() {
        final Shuffler<String> shuffler = new Shuffler<>();
        final List<String> shuffledList = shuffler.shuffle(BRANDS);
        return shuffledList.get(RANDOM.nextInt(shuffledList.size()));
    }

    public static String getRandomModel() {
        final Shuffler<String> shuffler = new Shuffler<>();
        final List<String> shuffledList = shuffler.shuffle(MODELS);
        return shuffledList.get(RANDOM.nextInt(shuffledList.size()));
    }

    public static int getRandomSeatsNumber() {
        return RANDOM.nextInt(51) + 20;
    }

    public static int getRandomStandingRoomNumber() {
        return RANDOM.nextInt(26) + 10;
    }

    public static int getRandomLength() {
        return RANDOM.nextInt(13) + 6;
    }

    public static EngineModelType getRandomEngineType() {
        final Shuffler<EngineModelType> shuffler = new Shuffler<>();
        final List<EngineModelType> shuffledList = shuffler.shuffle(EngineModelType.values());
        return shuffledList.get(RANDOM.nextInt(shuffledList.size()));
    }

    private static String[] loadBrands() {
        return new String[]{
                "Volvo",
                "Mercedes-Benz",
                "IVECO",
                "Scania AB",
                "Renault",
                "Daewoo Bus",
                "Hyundai",
                "Kia Motors",
                "Normale",
                "Busland"
        };
    }

    private static String[] loadModels() {
        return new String[]{
                "1500",
                "Octavia",
                "Fiesta",
                "Focus",
                "Light",
                "Black Carbon",
                "Division",
                "Prototype 2000",
                "See-sharp",
                "Anchor",
                "Megane",
                "C-class",
                "S-class",
                "i-30",
                "Quadrillion",
                "Andava"
        };
    }
}