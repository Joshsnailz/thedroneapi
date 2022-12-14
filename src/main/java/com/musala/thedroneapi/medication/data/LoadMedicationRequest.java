package com.musala.thedroneapi.medication.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoadMedicationRequest {
    private String medicationName;
    private double medicationWeight;
    private String medicationCode;
    private String medicationImage;
}
