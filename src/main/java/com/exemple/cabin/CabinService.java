package com.exemple.cabin;

import com.exemple.cabin.entities.Cabin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CabinService {

    @Autowired
    CabinRepository cabinRepository;

    public CabinService(){

    }

    public List<Cabin> getCabins(){
        return cabinRepository.findAll();

    }
}
