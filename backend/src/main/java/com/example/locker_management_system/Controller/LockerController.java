package com.example.locker_management_system.Controller;

import com.example.locker_management_system.Entity.LockerMaster;
import com.example.locker_management_system.Services.LockerMasterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locker")
public class LockerController {
    @Autowired
    private LockerMasterService lockerMasterService;

    //add locker to database
    @PostMapping("/add")
    public LockerMaster saveLocker(@Valid @RequestBody LockerMaster lockerMaster) {
        return lockerMasterService.saveLocker(lockerMaster);

    }
    @GetMapping("/get/{lockerId}")
    public LockerMaster getLockerById(@PathVariable Long lockerId) {
        return lockerMasterService.getLockerById(lockerId);
    }

    @DeleteMapping("/delete/{Id}")
    public void deleteLockerById(@PathVariable Long Id) {
        lockerMasterService.deleteLockerById(Id);
    }

    @PutMapping("/update/{id}")
    public LockerMaster updateLocker(@PathVariable Long id, @RequestBody LockerMaster lockerMaster) {
        return lockerMasterService.updateLocker(id, lockerMaster);
    }

    @GetMapping("/getAll")
    public List<LockerMaster> GetAllLockers() {
        return lockerMasterService.GetAllLockers();
    }
}
