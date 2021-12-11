package com.pethose.pet_ms.repositories;
import com.pethose.pet_ms.models.Pet;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PetRepositor extends MongoRepository<Pet, String>{
}
