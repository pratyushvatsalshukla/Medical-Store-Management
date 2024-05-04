package com.medicine.MedicalStore.repository;

import com.medicine.MedicalStore.model.MedicineAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepository extends JpaRepository<MedicineAdmin, Integer> {
   public MedicineAdmin findMedicineByMedicineName(String medicine) ;
}
