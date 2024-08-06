package com.example.locker_management_system.Services;

import com.example.locker_management_system.Entity.LockerMaster;

import java.util.List;

public interface LockerMasterService {
    LockerMaster saveLocker(LockerMaster lockerMaster);
    LockerMaster getLockerById(Long lockerId);
    void deleteLockerById(Long Id);
    LockerMaster updateLocker(Long id, LockerMaster lockerMaster);
    List<LockerMaster>GetAllLockers();

}
