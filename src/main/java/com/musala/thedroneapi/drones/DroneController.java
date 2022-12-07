package com.musala.thedroneapi.drones;

import com.musala.thedroneapi.drones.data.AddDroneRequest;
import com.musala.thedroneapi.drones.data.DroneResponse;
import com.musala.thedroneapi.medication.data.LoadMedicationRequest;
import com.musala.thedroneapi.medication.data.MedicationResponse;
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

    @PostMapping(value = "{id}/medication", consumes = "application/json", produces = "application/json")
    public MedicationResponse loadMedication(@PathVariable("id") long droneId, @RequestBody LoadMedicationRequest request) throws Exception {
        return droneService.loadDrone(droneId, request);
    }

    @GetMapping(value = "{id}/medication", produces = "application/json")
    public List<MedicationResponse> checkLoadedMedication(@PathVariable("id") long id) {
        return droneService.checkLoadedItems(id);
    }
}
