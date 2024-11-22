package com.tecsup.lab10.service;

import com.tecsup.lab10.model.Pet;
import com.tecsup.lab10.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService{

    private final PetRepository petRepository;

    public PetServiceImpl(PetRepository petRepository){
        this.petRepository = petRepository;
    }

    @Override
    public Pet createPet(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public List<Pet> findByName(String name) {
        List<Pet> pets = petRepository.findByName(name);
        return pets;
    }

    @Override
    public List<Pet> findAll() {
        return petRepository.findAll();
    }

}
