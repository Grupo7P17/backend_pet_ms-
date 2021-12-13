package com.pethose.pet_ms.controllers;
import com.pethose.pet_ms.models.Pet;
import com.pethose.pet_ms.models.Booking;
import com.pethose.pet_ms.repositories.PetRepositor;
import com.pethose.pet_ms.repositories.BookingRepository;
import com.pethose.pet_ms.exceptions.PetNotFoundException;
import com.pethose.pet_ms.exceptions.BookingNotFoundException;
import org.springframework.web.bind.annotation.*;

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
        Pet username = this.petRepository.findById(booking.getUsernameBooking()).orElse(null);
        if(username == null){
            throw new PetNotFoundException("la mascota del usuario "+username+" no se encuentra registrado.");
        }

        return bookingRepository.save(booking);

    }
    @GetMapping("/Booking/{username}")
    List<Booking> userBooking(@PathVariable String username){
        Pet userPet = this.petRepository.findById(username).orElse(null);
        if(userPet == null){
            throw new PetNotFoundException("La cuenta con usuario " + username
                    + " no se encuentra registrada en la base de datos.");
        }

        List<Booking> bookings  = this.bookingRepository.findByUsernameBooking(username);
        return bookings;

    }
    @GetMapping("/Booking/get/{id}")
    Booking getBooking(@PathVariable String id){
        Booking booking = this.bookingRepository.findById(id).orElse(null);
        if(booking == null){
            throw new BookingNotFoundException("El código de la reserva no existe en la base de datos.");
        }
        return booking;}
    @PutMapping("/Booking/update")
    Booking updateBooking(@RequestBody Booking bookingUpdate){
        Booking booking = this.bookingRepository.findById( bookingUpdate.getId() ).orElse(null);
        if(booking == null){
            throw new BookingNotFoundException("El código de la reserva no existe en la base de datos.");
        }
        booking.setCheckIn( bookingUpdate.getCheckIn() );
        booking.setCheckOut( bookingUpdate.getCheckOut() );
        booking.setCost( bookingUpdate.getCost());
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