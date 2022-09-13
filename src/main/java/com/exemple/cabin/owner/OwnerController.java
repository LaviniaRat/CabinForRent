package com.exemple.cabin.owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OwnerController {
    @Autowired
    OwnerService ownerService;

    @GetMapping("/owners")
    public List<Owner> getAllOwners(){
        return ownerService.getAllOwners();
    }

    @GetMapping("/owner")
    public Owner getOwner(int id){
        return ownerService.getOwnerById(id);
    }

    @PostMapping("/owner")
    public Owner saveOwner(Owner entity){
        return ownerService.saveOwner(entity);
    }

    @DeleteMapping("/owner")
    public void deleteOwner(int id){
        ownerService.deleteOwnerById(id);
    }

    @PutMapping("/owner")
    public Owner updateOwner(Owner entity){
        return ownerService.updateOwner(entity);
    }


}
