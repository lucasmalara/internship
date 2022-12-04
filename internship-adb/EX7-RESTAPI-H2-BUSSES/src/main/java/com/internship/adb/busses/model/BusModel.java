package com.internship.adb.busses.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import static com.internship.adb.busses.utils.BusDataGenerator.*;
import static com.internship.adb.busses.utils.StringValidator.*;

@Getter
@ToString
@NoArgsConstructor
public class BusModel {

    //INFO: id in BusModel is mapped to externalId of BusEntity
    private String id;
    private String brand;
    private String model;
    private int seats;
    private int standingRoom;

    //INFO: Approximate length expressed as a whole number
    private int length;

    //INFO: engineType in BusModel is mapped to engineType of BusEntity
    private EngineModelType engine;

    public static BusModel randomBus(String id) {
        BusModel busModel = new BusModel();
        busModel.setId(id);
        busModel.setBrand(getRandomBrand());
        busModel.setModel(getRandomModel());
        busModel.setSeats(getRandomSeatsNumber());
        busModel.setStandingRoom(getRandomStandingRoomNumber());
        busModel.setLength(getRandomLength());
        busModel.engine = getRandomEngineType();
        return busModel;
    }

    public void setId(String id) {
        if (validateNonNegativeNumber(id)) {
            this.id = id;
        }
    }

    public void setBrand(String brand) {
        if (validateBrand(brand)) {
            this.brand = brand;
        }
    }

    public void setModel(String model) {
        if (validateModel(model)) {
            this.model = model;
        }
    }

    public void setSeats(int seats) {
        if (validateNonNegativeNumber(String.valueOf(seats))) {
            this.seats = seats;
        }
    }

    public void setStandingRoom(int standingRoom) {
        if (validateNonNegativeNumber(String.valueOf(standingRoom))) {
            this.standingRoom = standingRoom;
        }
    }

    public void setLength(int length) {
        if (validateNonNegativeNumber(String.valueOf(length))) {
            this.length = length;
        }
    }

    public void setEngine(String engineType) {
        if (validateEngine(engineType)) {
            this.engine = EngineModelType.convertFromString(engineType);
        }
    }
}