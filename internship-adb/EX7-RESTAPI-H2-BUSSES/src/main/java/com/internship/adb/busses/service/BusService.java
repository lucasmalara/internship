package com.internship.adb.busses.service;

import com.internship.adb.busses.exception.BusAlreadyExistsException;
import com.internship.adb.busses.exception.BusNotFoundException;
import com.internship.adb.busses.model.BusModel;
import com.internship.adb.busses.persistence.entity.BusEntity;
import com.internship.adb.busses.persistence.entity.EngineEntityType;
import com.internship.adb.busses.repository.BusRepository;
import com.internship.adb.busses.utils.BusConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BusService {

    @Autowired
    private BusRepository busRepository;

    public Iterable<BusModel> getBusses() {
        final List<BusEntity> busses = busRepository.findAll();
        return BusConverter.convertToBussesModel(busses);
    }

    public BusModel getBus(String id) {
        Optional<BusEntity> optionalBusEntity = Optional.ofNullable(busRepository.findByExternalId(id));
        if (optionalBusEntity.isEmpty()) {
            throw new BusNotFoundException(id);
        } else return BusConverter.convertToBusModel(optionalBusEntity.get());
    }

    public Iterable<BusModel> getByEngineType(String engineType) {
        List<BusEntity> busEntities = busRepository.findByEngineType(EngineEntityType.convertFromString(engineType));
        return BusConverter.convertToBussesModel(busEntities);

    }

    public void addBus(BusModel busModel) {
        BusEntity busEntity = BusConverter.convertToBusEntity(busModel);
        List<String> allIDs = busRepository.findAll()
                .stream()
                .map(BusEntity::getExternalId)
                .collect(Collectors.toUnmodifiableList());
        String extractedId = busEntity.getExternalId();
        if(allIDs.contains(extractedId)) {
            throw new BusAlreadyExistsException(extractedId);
        } else busRepository.save(busEntity);
    }

    public void addBusses(Iterable<BusModel> bussesModel) {
        Iterable<BusEntity> busEntities = BusConverter.convertToBussesEntities(bussesModel);
        List<String> allIDs = busRepository.findAll()
                .stream()
                .map(BusEntity::getExternalId)
                .collect(Collectors.toUnmodifiableList());
        for (BusEntity busEntity : busEntities) {
            String extractedId = busEntity.getExternalId();
            if(allIDs.contains(extractedId)) {
                throw new BusAlreadyExistsException(extractedId);
            } else busRepository.saveAll(busEntities);
        }
    }

    public BusModel updateBus(String id, BusModel modifiedBusModel) {
        Optional<BusEntity> optionalBusEntity = Optional.ofNullable(busRepository.findByExternalId(id));
        if (optionalBusEntity.isEmpty()) {
            throw new BusNotFoundException(id);
        } else {
            BusEntity busEntity = optionalBusEntity.get();
            busEntity.setModel(modifiedBusModel.getModel());
            busEntity.setBrand(modifiedBusModel.getBrand());
            busEntity.setSeats(modifiedBusModel.getSeats());
            busEntity.setStandingRoom(modifiedBusModel.getStandingRoom());
            busEntity.setLength(modifiedBusModel.getLength());
            busEntity.setEngineType(EngineEntityType.valueOf(modifiedBusModel.getEngine().name()));
            busRepository.save(busEntity);
            return BusConverter.convertToBusModel(busEntity);
        }
    }

    public void deleteBus(String id) {
        Optional<BusEntity> optionalBusEntity = Optional.ofNullable(busRepository.findByExternalId(id));
        if (optionalBusEntity.isEmpty()) {
            throw new BusNotFoundException(id);
        } else busRepository.delete(optionalBusEntity.get());
    }
}