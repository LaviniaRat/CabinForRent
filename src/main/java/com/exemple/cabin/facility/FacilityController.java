package com.exemple.cabin.facility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FacilityController {
    @Autowired
    FacilityService facilityService;

    @GetMapping("/facilities")
    public List<Facility> getAllFacilities(){
        return facilityService.getAllFacilities();
    }

    @GetMapping("/facility")
    public Facility getFacility(int id){
        return facilityService.getFacilityById(id);
    }

    @PostMapping("/facility")
    public Facility saveFacility(Facility entity){
        return facilityService.saveFacility(entity);
    }

    @DeleteMapping("/facility")
    public void deleteFacility(int id){
        facilityService.deleteFacilityById(id);
    }

    @PutMapping("/facility")
    public Facility updateFacility(Facility entity){
        return facilityService.updateFacility(entity);
    }
}
