package com.exemple.cabin;

import com.exemple.cabin.entities.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {

    @Autowired
    OwnerRepository ownerRepository;

    public List<Owner> getAllOwners(){
        List<Owner> ownerList=ownerRepository.findAll();
        if(ownerList.size()>0){
            return ownerList;
        }
        else{
            return new ArrayList<>();
        }
    }

    public Owner getOwnerById(int id){
        Optional<Owner> owner=ownerRepository.findById(id);
        return owner.get();

    }
}
