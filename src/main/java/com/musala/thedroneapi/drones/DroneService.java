package com.musala.thedroneapi.drones;

import com.musala.thedroneapi.drones.data.AddDroneRequest;
import com.musala.thedroneapi.drones.data.DroneResponse;
import com.musala.thedroneapi.medication.data.LoadMedicationRequest;
import com.musala.thedroneapi.medication.data.MedicationResponse;

import java.util.List;

public interface DroneService {
    DroneResponse addDrone(AddDroneRequest droneCreateDto);
    MedicationResponse loadDrone(long droneId, LoadMedicationRequest medicationRequest) throws Exception;

    List<DroneResponse> checkAvailableDrones();

    List<MedicationResponse> checkLoadedItems(long droneId);

}
