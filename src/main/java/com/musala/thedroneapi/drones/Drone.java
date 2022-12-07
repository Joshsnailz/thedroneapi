package com.musala.thedroneapi.drones;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

@Getter
@Setter
@Entity
@Table(name = "drones")
public class Drone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true, length = 100, name = "serial_number")
    private String serialNumber;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(nullable = false)
    private DroneModel model;

    @Column(nullable = false,name = "weight_limit")
    @Range(min = 1, max = 500)
    private double weightLimit;

    @Column(nullable = false,name = "battery_capacity")
    @Range(min = 0, max = 100)
    private double batteryCapacity;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(nullable = false)
    private DroneState state;
}
