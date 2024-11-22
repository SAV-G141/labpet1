package com.tecsup.lab10.service;

import com.tecsup.lab10.model.Pet;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class PetServiceTest {

    @Autowired
    private PetService petService;

    @Test
    public void testCreatePet(){
        String PET_NAME = "Rocco";
        Date PET_BITHDATE = new Date();

        Pet pet = new Pet(PET_NAME,PET_BITHDATE);

        Pet petCreated = this.petService.createPet(pet);
        log.info("PET", petCreated.toString());

        assertNotNull(petCreated.getId());
        assertEquals(PET_NAME, petCreated.getName());
        assertEquals(PET_BITHDATE, petCreated.getBirthDate());

    }

    @Test
    public void testFindAllPets() {
        List<Pet> pets = this.petService.findAll();
        assertNotNull(pets);
        assertTrue(pets.size()>0);
    }

    @Test
    public void testFindByName(){
        String NAME = "Rocco";
        List<Pet> pets = this.petService.findByName(NAME);
        assertNotNull(pets);
        assertTrue(pets.size()>0);
    }

}