package com.musala.thedroneapi.drones.data;

import com.musala.thedroneapi.drones.DroneModel;
import lombok.Data;


@Data
public class AddDroneRequest {
    private  String serialNumber;
    private double weightLimit;
    private DroneModel model;
}
