package com.pethose.pet_ms.controllers;
import com.pethose.pet_ms.models.Pet;
import com.pethose.pet_ms.exceptions.PetNotFoundException;
import com.pethose.pet_ms.repositories.PetRepositor;
import org.springframework.web.bind.annotation.*;

@RestController
public class PetController {
    private final PetRepositor petRepository;

    public PetController(PetRepositor petRepository){
        this.petRepository = petRepository;
    }
    @GetMapping("/pet/{username}")
    Pet getPet(@PathVariable String username) {
        return this.petRepository.findById(username).
                orElseThrow(() -> new PetNotFoundException("No se encontró la mascota asociada al usuario."
                        +username +"."));
    }
    @PostMapping("/pet")
    Pet createPet(@RequestBody Pet pet){
        return petRepository.save(pet);
    }
    @DeleteMapping("/pet/delete/{username}")
    String deletePet(@PathVariable String username){
        Pet pet = petRepository.findById(username).orElse(null);
        if(pet == null){
            throw new PetNotFoundException("No se encontró la mascota.");
        }
        this.petRepository.deleteById(username);
        return "Se eliminó la mascota.";
    }
    @PutMapping("/pet/update/{username}")
    Pet updatePet(@RequestBody Pet petUpdate){
        Pet pet = this.petRepository.findById(petUpdate.getUsername()).orElse(null);
        if(pet == null){
            throw new PetNotFoundException("La mascota no está registrada");
        }
        pet.setName( petUpdate.getName());
        pet.setBreed(petUpdate.getBreed());
        pet.setAge(petUpdate.getAge());
        return petRepository.save(pet);
    }
}
