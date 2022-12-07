package com.musala.thedroneapi.drones;

import com.musala.thedroneapi.drones.data.AddDroneRequest;
import com.musala.thedroneapi.drones.data.DroneResponse;
import com.musala.thedroneapi.medication.MedicationService;
import com.musala.thedroneapi.medication.data.LoadMedicationRequest;
import com.musala.thedroneapi.medication.data.MedicationResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DroneServiceImpl implements DroneService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DroneRepository droneRepository;

    @Autowired
    private MedicationService medicationService;

    @Override
    public DroneResponse addDrone(AddDroneRequest droneCreateDto) {
        Drone drone = modelMapper.map(droneCreateDto, Drone.class);
        drone.setState(DroneState.IDLE);
        drone.setBatteryCapacity(100);

        droneRepository.save(drone);

        return modelMapper.map(drone, DroneResponse.class);
    }

    @Override
    public MedicationResponse loadDrone(long droneId, LoadMedicationRequest medicationRequest) throws Exception {
        Drone drone = droneRepository.getReferenceById(droneId);
        if(drone.getState().equals(DroneState.IDLE)){
            drone.setState(DroneState.LOADING);
        }

        double currentWeight = medicationService.getTotalWeight(drone);
        if(drone.getWeightLimit() == currentWeight) {
            drone.setState(DroneState.LOADED);
        }

        droneRepository.save(drone);

        return medicationService.loadToDrone(drone, medicationRequest);

    }

    @Override
    public List<DroneResponse> checkAvailableDrones() {

        return droneRepository.findAllByState(DroneState.IDLE)
                .stream()
                .map(drone -> modelMapper.map(drone, DroneResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<MedicationResponse> checkLoadedItems(long droneId) {
        Drone drone = droneRepository.getReferenceById(droneId);
        return medicationService.checkLoadedMedication(drone);
    }
}
