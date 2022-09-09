package com.exemple.cabin;

import com.exemple.cabin.entities.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OwnerController {
    @Autowired
    OwnerService ownerService;

    @GetMapping("/getOwners")
    public List<Owner> getAllOwners(){
        return ownerService.getAllOwners();
    }

    @GetMapping("/getOwner")
    public Owner getOwner(int id){
        return ownerService.getOwnerById(id);
    }

    @PostMapping("/saveOwner")
    public Owner saveOwner(Owner entity){
        return ownerService.saveOwner(entity);
    }

    @DeleteMapping("/deleteOwner")
    public void deleteOwner(int id){
        ownerService.deleteOwnerById(id);
    }

    @PutMapping("/updateOwner")
    public Owner updateOwner(Owner entity){
        return ownerService.updateOwner(entity);
    }


}
