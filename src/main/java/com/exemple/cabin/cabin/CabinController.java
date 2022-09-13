package com.exemple.cabin.cabin;

import com.exemple.cabin.owner.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CabinController {

    @Autowired
    CabinService cabinService;

    @GetMapping("/cabins")
    public List<Cabin> getAllCabins(){
        return cabinService.getAllCabins();
    }

    @GetMapping("/cabin")
    public Cabin getCabin(int id){
        return cabinService.getCabinById(id);
    }

    @GetMapping("/cabinByPriceAndLocation")
    public List<Cabin> getCabinByNameAndLocation(int price, String location){
        return cabinService.findByPriceAndLocation(price, location);
    }

    @GetMapping("/cabinByLocation")
    public List<Cabin> getCabinByLocation(String location){
        return cabinService.findByLocation(location);
    }

    @PostMapping("/cabin")
    public Cabin saveCabin(Cabin entity){
        return cabinService.saveCabin(entity);
    }

    @DeleteMapping("/cabin")
    public void deleteCabin(int id){
        cabinService.deleteCabinById(id);
    }

    @PutMapping("/cabin")
    public Cabin updateCabin(Cabin entity){
        return cabinService.updateCabin(entity);
    }

}
