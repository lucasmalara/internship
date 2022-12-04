package com.internship.adb.busses.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "busses")
public class BusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NaturalId
    @Column(name = "external_id", nullable = false, unique = true)
    private String externalId;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private int seats;

    @Column(name = "standing_room", nullable = false)
    private int standingRoom;

    @Column(nullable = false)
    private int length;

    @Enumerated(EnumType.STRING)
    @Column(name = "engine", nullable = false)
    private EngineEntityType engineType;
}