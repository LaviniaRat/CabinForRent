package com.exemple.cabin;

import com.exemple.cabin.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Integer> {
}
