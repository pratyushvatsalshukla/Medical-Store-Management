package com.medicine.MedicalStore.service;

import java.util.Objects;

import com.medicine.MedicalStore.model.MedicineAdmin;
import com.medicine.MedicalStore.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MedicineServiceImpl implements MedicineService{

    @Autowired
    private MedicineRepository medRepo ;

    @Override
    public boolean AddMedicine(MedicineAdmin medicine) {
            if(Objects.nonNull(medRepo.findMedicineByMedicineName(medicine.getMedicineName())))
            {
                return false ;
            }
            else{
                medRepo.save(medicine) ;
                return true ;
            }
    }

    @Override
    public ResponseEntity<?> GetMedicine(MedicineAdmin medicine) {
        MedicineAdmin medicineByMedicineName = medRepo.findMedicineByMedicineName(medicine.getMedicineName());
        if(Objects.isNull(medicineByMedicineName))
        {
            return new ResponseEntity<>("Medicine Not Found !!", HttpStatus.NOT_FOUND) ;
        }
        else
        {
            return new ResponseEntity<>(medicineByMedicineName, HttpStatus.FOUND) ;
        }
    }

    @Override
    public ResponseEntity<?> UpdateMedicine(MedicineAdmin medicine) {
    MedicineAdmin medicineByMedicineName = medRepo.findMedicineByMedicineName((medicine.getMedicineName())) ;
    if(Objects.isNull(medicineByMedicineName)){
        return new ResponseEntity<>("Medicine Not Found !! Try To Add The Medicine First !", HttpStatus.NOT_FOUND) ;
    }
    else{
        if(Objects.nonNull(medicine.getMedicineName()))
        {
            medicineByMedicineName.setMedicineName(medicine.getMedicineName());
        }
        if(Objects.nonNull(medicine.getMedicineQuantity())){
            medicineByMedicineName.setMedicineQuantity(medicine.getMedicineQuantity());
        }
        if(Objects.nonNull((medicine.getMedicinePrice()))){
            medicineByMedicineName.setMedicinePrice(medicine.getMedicinePrice());
        }
        medRepo.save(medicineByMedicineName) ;
        return new ResponseEntity<>("Medicine Updated Successfully ! Please Refresh !", HttpStatus.OK) ;
    }
    }

    @Override
    public boolean DeleteMedicine(MedicineAdmin medicine) {
        MedicineAdmin medicineByMedicineName = medRepo.findMedicineByMedicineName(medicine.getMedicineName()) ;
        if(Objects.nonNull(medicineByMedicineName)){
            medRepo.delete(medicineByMedicineName);
            return true ;
        }
        else{
            return false ;
        }

    }
}
