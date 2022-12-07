package com.musala.thedroneapi.drones.data;

import com.musala.thedroneapi.drones.DroneModel;
import com.musala.thedroneapi.drones.DroneState;
import lombok.Data;

@Data
public class DroneResponse {
    private long id;
    private String serialNumber;
    private double weightLimit;
    private DroneModel model;
    private DroneState state;
}
