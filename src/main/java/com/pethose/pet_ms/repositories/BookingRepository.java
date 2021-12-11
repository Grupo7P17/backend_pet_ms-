package com.pethose.pet_ms.repositories;
import com.pethose.pet_ms.models.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;


public interface BookingRepository extends MongoRepository<Booking,String> {
    List<Booking> findByUsername(String username);
}
