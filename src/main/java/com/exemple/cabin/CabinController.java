package com.exemple.cabin;

import com.exemple.cabin.entities.Cabin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CabinController {

    @Autowired
    CabinService cabinService;

    @GetMapping("/getCabins")
    public List<Cabin> getCabins(){
        return cabinService.getCabins();
    }
}
