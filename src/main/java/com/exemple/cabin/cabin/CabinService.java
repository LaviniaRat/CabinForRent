package com.exemple.cabin.cabin;

import com.exemple.cabin.owner.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CabinService {

    @Autowired
    CabinRepository cabinRepository;

    public CabinService(){

    }

    public List<Cabin> getAllCabins(){
        List<Cabin> cabinList = cabinRepository.findAll();
        if(cabinList.size()>0){
            return cabinList;
        } else{
            return new ArrayList<>();
        }

    }

    public Cabin getCabinById(int id)throws NoSuchElementException {
        Optional<Cabin>cabin=cabinRepository.findById(id);
        if(cabin.isPresent()){
            return cabin.get();
        } else{
            throw new NoSuchElementException("No cabin record exist or given id");
        }
    }

    public Cabin updateCabin(Cabin entity) throws NoSuchElementException{
        Optional<Cabin> cabin = cabinRepository.findById(entity.getId());
        if(cabin.isPresent()){
            Cabin newCabin= cabin.get();
            newCabin.setName(entity.getName());
            newCabin.setOwner(entity.getOwner());
            newCabin.setPrice(entity.getPrice());
            newCabin.setLocation(entity.getLocation());
            newCabin = cabinRepository.save(newCabin);
            return newCabin;
        } else{
            throw new NoSuchElementException("No cabin record exist or given id");
        }
    }

    public Cabin saveCabin(Cabin entity){
        return cabinRepository.save(entity);
    }

    public void deleteCabinById(int id) throws  NoSuchElementException{
        Optional <Cabin> cabin = cabinRepository.findById(id);
        if(cabin.isPresent()){
            cabinRepository.deleteById(id);
        } else{
            throw new NoSuchElementException("No cabin record exist or given id");
        }
    }

    public List<Cabin> findByPriceAndLocation(Integer price, String location) {
        List<Cabin> cabinList = cabinRepository.findByPriceAndLocation(price, location);
        return cabinList;
    }

        public List<Cabin> findByLocation(String location){
            List<Cabin> cabinList = cabinRepository.findByLocation(location);
            return cabinList;
        }
    }

