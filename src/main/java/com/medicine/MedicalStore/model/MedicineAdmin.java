package com.medicine.MedicalStore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedicineAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int medicineId ;

    private String medicineName ;

    private String medicineQuantity ;

    private String medicinePrice ;

}
