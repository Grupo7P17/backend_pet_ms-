package com.pethose.pet_ms.controllers;
import com.pethose.pet_ms.models.Pet;
import com.pethose.pet_ms.models.Booking;
import com.pethose.pet_ms.repositories.PetRepositor;
import com.pethose.pet_ms.repositories.BookingRepository;
import com.pethose.pet_ms.exceptions.PetNotFoundException;
import com.pethose.pet_ms.exceptions.BookingNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.List;

@RestController
public class BookingController {
    private final BookingRepository bookingRepository;
    private final PetRepositor petRepository;

    public BookingController(BookingRepository bookingRepository, PetRepositor petRepository){
        this.bookingRepository = bookingRepository;
        this.petRepository = petRepository;
    }
    @PostMapping("/Booking")
    Booking newBooking(@RequestBody Booking booking){
        Pet username = this.petRepository.findById(booking.getUsername()).orElse(null);
        if(username == null){
            throw new PetNotFoundException("la mascota del usuario "+username+" no se encuentra registrado.");
        }
        return bookingRepository.save(booking);

    }
    @GetMapping("/Booking/{username}")
    List<Booking> userBooking(@PathVariable String username){
        Pet usernamePet = this.petRepository.findById(username).orElse(null);
        if(usernamePet == null){
            throw new PetNotFoundException("la mascota del usuario "+username+" no se encuentra registrado.");
        }
        List<Booking> BookingUser = this.bookingRepository.findByUsername(username);
        return  BookingUser;

    }
    @PutMapping("/Booking/update")
    Booking updateBooking(@RequestBody Booking bookingUpdate){
        Booking booking = this.bookingRepository.findById(bookingUpdate.getId()).orElse(null);
        if (booking == null){
            throw new BookingNotFoundException("La reserva no existe.");
        }
        return bookingRepository.save(booking);

    }
    @DeleteMapping("/Booking/delete/{id}")
    String deleteBooking(@PathVariable String id){
        Booking booking = this.bookingRepository.findById(id).orElse((null));
        if(booking==null){
            throw new BookingNotFoundException("La reserva no se encuentra registrada");
        }
        this.bookingRepository.deleteById(id);
        return "Se eliminó la reserva "+id + ".";
    }

}
