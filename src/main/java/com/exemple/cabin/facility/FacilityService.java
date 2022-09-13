package com.exemple.cabin.facility;

import com.exemple.cabin.owner.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class FacilityService {

    @Autowired
    FacilityRepository facilityRepository;

    public List<Facility> getAllFacilities() {
        List<Facility> allFacilityList = facilityRepository.findAll();
        if (allFacilityList.size() > 0) {
            return allFacilityList;
        } else {
            return new ArrayList<>();
        }
    }

    public Facility getFacilityById(int id) throws NoSuchElementException {
        Optional<Facility> facility = facilityRepository.findById(id);
        if (facility.isPresent()) {
            return facility.get();
        } else {
            throw new NoSuchElementException("No facility record exist or given id");
        }
    }

    public Facility updateFacility(Facility entity) throws NoSuchElementException {
        Optional<Facility> facility = facilityRepository.findById(entity.getId());
        if (facility.isPresent()) {
            Facility newFacility = facility.get();
            newFacility.setName(entity.getName());
            return newFacility;
        } else {
            throw new NoSuchElementException("No facility record exist or given id");
        }
    }

    public Facility saveFacility(Facility entity) {
        return facilityRepository.save(entity);
    }

    public void deleteFacilityById(int id) {
        Optional<Facility> facility = facilityRepository.findById(id);
        if (facility.isPresent()) {
            facilityRepository.deleteById(id);
        } else {
            throw new NoSuchElementException("No facility record exist or given id");
        }
    }
}
