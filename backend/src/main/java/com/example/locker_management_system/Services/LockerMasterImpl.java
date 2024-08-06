package com.example.locker_management_system.Services;

import com.example.locker_management_system.Entity.LockerMaster;
import com.example.locker_management_system.Repository.LockerMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LockerMasterImpl implements LockerMasterService {
    @Autowired
    private LockerMasterRepository lockerMasterRepository;

    @Override
    public LockerMaster saveLocker(LockerMaster lockerMaster) {
        return lockerMasterRepository.save(lockerMaster);
    }


    @Override
    public LockerMaster getLockerById(Long lockerId) {
        return lockerMasterRepository.findById(lockerId).orElseThrow(()->
                new RuntimeException("Locker with lockerId " + lockerId + " not found"));
    }

    @Override
    public void deleteLockerById(Long Id) {
        lockerMasterRepository.deleteById(Id);

    }

    @Override
    public LockerMaster updateLocker(Long id, LockerMaster lockerMaster) {
        Optional<LockerMaster> lockerMasterOptional = lockerMasterRepository.findById(id);
        if(lockerMasterOptional.isPresent()){
            LockerMaster lockerMasterToUpdate = lockerMasterOptional.get();

            lockerMasterToUpdate.setLockerNumber(lockerMaster.getLockerNumber());
            lockerMasterToUpdate.setLockerSize(lockerMasterOptional.get().getLockerSize());
            lockerMasterToUpdate.setLockerPrice(lockerMaster.getLockerPrice());
            lockerMasterToUpdate.setLockerStatus(lockerMaster.getLockerStatus());
            lockerMasterToUpdate.setLockerkeyno(lockerMaster.getLockerkeyno());

            return lockerMasterRepository.save(lockerMasterToUpdate);
        }
        return null;
    }

    @Override
    public List<LockerMaster> GetAllLockers() {
        return lockerMasterRepository.findAll();
    }
}
