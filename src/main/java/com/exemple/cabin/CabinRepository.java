package com.exemple.cabin;

import com.exemple.cabin.entities.Cabin;
import com.exemple.cabin.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CabinRepository extends JpaRepository<Cabin,Integer> {

}
