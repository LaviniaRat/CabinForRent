package com.exemple.cabin;

import com.exemple.cabin.entities.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class OwnerService {

    @Autowired
    OwnerRepository ownerRepository;

    public List<Owner> getAllOwners(){
        List<Owner> ownerList=ownerRepository.findAll();
        if(ownerList.size()>0){
            return ownerList;
        } else{
            return new ArrayList<>();
        }
    }

    public Owner getOwnerById(int id)throws NoSuchElementException {
        Optional<Owner> owner=ownerRepository.findById(id);
        if(owner.isPresent()){
            return owner.get();
        } else{
            throw new NoSuchElementException("No owner record exist gor given id");
        }
    }

    public Owner updateOwner(Owner entity) throws NoSuchElementException{
        Optional<Owner> owner = ownerRepository.findById(entity.getId());
        if(owner.isPresent()){
            Owner newOwner= owner.get();
            newOwner.setName(entity.getName());
            newOwner.setEmail(entity.getEmail());
            newOwner.setPhone(entity.getPhone());
            newOwner = ownerRepository.save(newOwner);
            return newOwner;
        } else{
            throw new NoSuchElementException("No owner record exist gor given id");
        }
    }

    public Owner saveOwner(Owner entity){
        return ownerRepository.save(entity);
//        Owner newOwner = new Owner();
//        newOwner.setName(entity.getName());
//        newOwner.setEmail(entity.getEmail());
//        newOwner.setPhone(entity.getPhone());
//        return ownerRepository.save(newOwner);
    }

    public void deleteOwnerById(int id) throws  NoSuchElementException{
        Optional <Owner> owner = ownerRepository.findById(id);
        if(owner.isPresent()){
            ownerRepository.deleteById(id);
        } else{
            throw new NoSuchElementException("No owner record exist gor given id");
        }


    }

}
