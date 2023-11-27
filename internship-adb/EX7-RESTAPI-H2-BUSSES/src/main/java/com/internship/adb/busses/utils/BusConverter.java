package com.internship.adb.busses.utils;

import com.internship.adb.busses.model.BusModel;
import com.internship.adb.busses.persistence.entity.BusEntity;
import com.internship.adb.busses.persistence.entity.EngineEntityType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BusConverter {

    public static BusModel convertToBusModel(BusEntity busEntity) {
        BusModel busModel = new BusModel();
        busModel.setId(busEntity.getExternalId());
        busModel.setModel(busEntity.getModel());
        busModel.setBrand(busEntity.getBrand());
        busModel.setLength(busEntity.getLength());
        busModel.setStandingRoom(busEntity.getStandingRoom());
        busModel.setSeats(busEntity.getSeats());
        busModel.setEngine(busEntity.getEngineType().name());
        return busModel;
    }

    public static BusEntity convertToBusEntity(BusModel busModel) {
        BusEntity busEntity = new BusEntity();
        busEntity.setExternalId(busModel.getId());
        return convertToBusEntity(busEntity, busModel);
    }

    public static BusEntity convertToBusEntity(BusEntity busEntity, BusModel busModel) {
        busEntity.setBrand(busModel.getBrand());
        busEntity.setModel(busModel.getModel());
        busEntity.setLength(busModel.getLength());
        busEntity.setStandingRoom(busModel.getStandingRoom());
        busEntity.setSeats(busModel.getSeats());
        busEntity.setEngineType(EngineEntityType.valueOf(busModel.getEngine().name()));
        return busEntity;
    }

    public static Iterable<BusModel> convertToBussesModel(Iterable<BusEntity> bussesEntities) {
        List<BusModel> bussesModel = new ArrayList<>();
        for (BusEntity busEntity : bussesEntities) {
            bussesModel.add(BusConverter.convertToBusModel(busEntity));
        }
        return bussesModel;
    }

    public static Iterable<BusEntity> convertToBussesEntities(Iterable<BusModel> bussesModel) {
        List<BusEntity> bussesEntities = new ArrayList<>();
        for (BusModel busModel : bussesModel) {
            bussesEntities.add(BusConverter.convertToBusEntity(busModel));
        }
        return bussesEntities;
    }
}