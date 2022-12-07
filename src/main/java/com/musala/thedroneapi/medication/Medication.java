package com.musala.thedroneapi.medication;


import com.musala.thedroneapi.drones.Drone;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "medication")
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "medication_name", nullable = false,unique = true)
    private String medicationName;

    @Column(name = "weight", nullable = false)
    private double medicationWeight;

    @Column(name = "code", nullable = false)
    private String medicationCode;

    @Column(name = "medication_image", nullable = false)
    private String medicationImage;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "drone_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Drone drone;
}
