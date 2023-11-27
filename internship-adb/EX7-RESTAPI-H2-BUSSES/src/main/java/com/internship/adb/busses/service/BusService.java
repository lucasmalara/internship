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

@Service
public class BusService {

    private final BusRepository busRepository;

    @Autowired
    public BusService(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    public Iterable<BusModel> getBusses() {
        List<BusEntity> busses = busRepository.findAll();
        return BusConverter.convertToBussesModel(busses);
    }

    public BusModel getBus(String id) {
        Optional<BusEntity> optionalBusEntity = busRepository.findByExternalId(id);
        if (optionalBusEntity.isEmpty()) {
            throw new BusNotFoundException(id);
        }
        return BusConverter.convertToBusModel(optionalBusEntity.get());
    }

    public Iterable<BusModel> getByEngineType(String engineType) {
        List<BusEntity> busEntities = busRepository.findByEngineType(EngineEntityType.convertFromString(engineType));
        return BusConverter.convertToBussesModel(busEntities);

    }

    public void addBus(BusModel busModel) {
        BusEntity busEntity = BusConverter.convertToBusEntity(busModel);
        String extractedId = busEntity.getExternalId();
        if (doesBusAlreadyExist(extractedId)) {
            throw new BusAlreadyExistsException(extractedId);
        }
        busRepository.save(busEntity);
    }

    public boolean doesBusAlreadyExist(String externalId) {
        Optional<BusEntity> byExternalId = busRepository.findByExternalId(externalId);
        return byExternalId.isPresent();
    }

    public void addBusses(Iterable<BusModel> bussesModel) {
        bussesModel.forEach(this::addBus);
    }

    public BusModel updateBus(String id, BusModel modifiedBusModel) {
        Optional<BusEntity> optionalBusEntity = busRepository.findByExternalId(id);
        if (optionalBusEntity.isEmpty()) {
            throw new BusNotFoundException(id);
        }
        BusEntity busEntity = optionalBusEntity.get();
        BusEntity updatedBusEntity = BusConverter.convertToBusEntity(busEntity, modifiedBusModel);
        busRepository.save(updatedBusEntity);
        return BusConverter.convertToBusModel(updatedBusEntity);
    }

    public void deleteBus(String id) {
        Optional<BusEntity> optionalBusEntity = busRepository.findByExternalId(id);
        if (optionalBusEntity.isEmpty()) {
            throw new BusNotFoundException(id);
        }
        busRepository.delete(optionalBusEntity.get());
    }
}