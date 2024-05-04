package com.medicine.MedicalStore.service;

import com.medicine.MedicalStore.model.MedicineAdmin;
import org.springframework.http.ResponseEntity;

public interface MedicineService {
    public boolean AddMedicine(MedicineAdmin medicine) ;

    public ResponseEntity<?> GetMedicine(MedicineAdmin medicine) ;

    public ResponseEntity<?> UpdateMedicine(MedicineAdmin medicine) ;

    public boolean DeleteMedicine(MedicineAdmin medicine) ;
}
