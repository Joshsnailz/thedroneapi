package com.musala.thedroneapi.medication;

import com.musala.thedroneapi.drones.Drone;
import com.musala.thedroneapi.medication.data.LoadMedicationRequest;
import com.musala.thedroneapi.medication.data.MedicationResponse;

import java.util.List;

public interface MedicationService {
    MedicationResponse loadToDrone(Drone drone, LoadMedicationRequest request) throws Exception;

    List<MedicationResponse> checkLoadedMedication(Drone drone);
}
