package com.exemple.cabin.cabin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CabinRepository extends JpaRepository<Cabin,Integer> {
    List<Cabin> findByPriceAndLocation(Integer price, String location);
    List<Cabin> findByLocation(String location);

}
