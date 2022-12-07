package com.musala.thedroneapi.medication;

import com.musala.thedroneapi.drones.Drone;
import com.musala.thedroneapi.drones.DroneState;
import com.musala.thedroneapi.exceptions.BatteryCapacityException;
import com.musala.thedroneapi.exceptions.WeightOverloadException;
import com.musala.thedroneapi.medication.data.LoadMedicationRequest;
import com.musala.thedroneapi.medication.data.MedicationResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicationServiceImpl implements MedicationService {

    @Autowired
    private MedicationRepository medicationRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public MedicationResponse loadToDrone(Drone drone, LoadMedicationRequest request) throws Exception {
        validateRequest(drone, request);

        Medication medication = modelMapper.map(request, Medication.class);
        medication.setDrone(drone);
        medicationRepository.save(medication);

        return modelMapper.map(medication, MedicationResponse.class);
    }

    @Override
    public List<MedicationResponse> checkLoadedMedication(Drone drone) {
        return medicationRepository.findAllByDrone(drone)
                .stream()
                .map(medication -> modelMapper.map(medication, MedicationResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public double getTotalWeight(Drone drone) {
        double currentDroneWeight = 0;
        List<Medication> medicationsAlreadyLoaded = medicationRepository.findAllByDrone(drone);
        if (!medicationsAlreadyLoaded.isEmpty()) {
            for (Medication med :
                    medicationsAlreadyLoaded)
                currentDroneWeight += med.getMedicationWeight();
        }
        return currentDroneWeight;
    }

    private void validateRequest(Drone drone, LoadMedicationRequest request) throws Exception {
        double currentDroneWeight = getTotalWeight(drone);

        if (drone.getBatteryCapacity() < 25) {
            throw new BatteryCapacityException();
        }

        if (!drone.getState().equals(DroneState.IDLE) && !drone.getState().equals(DroneState.LOADING)) {
            throw new Exception("The drone is not available for loading");
        }

        if (drone.getWeightLimit() < currentDroneWeight) {
            throw new WeightOverloadException();
        }
    }
}
