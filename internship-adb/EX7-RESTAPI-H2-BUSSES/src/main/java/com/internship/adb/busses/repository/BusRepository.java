package com.internship.adb.busses.repository;

import com.internship.adb.busses.persistence.entity.BusEntity;
import com.internship.adb.busses.persistence.entity.EngineEntityType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BusRepository extends JpaRepository<BusEntity, Long> {
    Optional<BusEntity> findByExternalId(String id);
    List<BusEntity> findByEngineType(EngineEntityType engineType);
}