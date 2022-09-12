package com.exemple.cabin.cabin;

import com.exemple.cabin.cabin.Cabin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CabinRepository extends JpaRepository<Cabin,Integer> {

}
