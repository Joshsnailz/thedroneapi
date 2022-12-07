package com.musala.thedroneapi.drones;

import com.musala.thedroneapi.drones.data.AddDroneRequest;
import com.musala.thedroneapi.drones.data.DroneResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drones")
public class DroneController {

    @Autowired
    private  DroneService droneService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public DroneResponse addDroneResponse(@RequestBody AddDroneRequest droneCreateDto){
        return droneService.addDrone(droneCreateDto);
    }

    @GetMapping(produces = "application/json")
    public List<DroneResponse> getAvailableDrones() {
        return droneService.checkAvailableDrones();
    }
}
