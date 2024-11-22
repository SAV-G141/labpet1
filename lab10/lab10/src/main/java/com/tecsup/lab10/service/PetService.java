package com.tecsup.lab10.service;

import com.tecsup.lab10.model.Pet;

import java.util.List;

public interface PetService {

    Pet createPet(Pet pet);

    List<Pet> findByName(String name);

    List<Pet> findAll();

}
