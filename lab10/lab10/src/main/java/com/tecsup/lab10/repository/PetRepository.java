package com.tecsup.lab10.repository;

import com.tecsup.lab10.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {

    List<Pet> findByName(String name);

    List<Pet> findAll();

}
