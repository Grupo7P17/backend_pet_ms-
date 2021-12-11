package com.pethose.pet_ms.exceptions;

public class PetNotFoundException extends RuntimeException{
    public PetNotFoundException(String message){
        super(message);
    }
}
