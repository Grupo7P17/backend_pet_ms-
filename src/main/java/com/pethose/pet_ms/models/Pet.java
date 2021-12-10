package com.pethose.pet_ms.models;
import  org.springframework.data.annotation.Id;


public class Pet {
    @Id
    private String username;
    private String name;
    private String breed;
    private Integer age;

    public Pet(String username, String name, String breed, Integer age){
        this.username = username;
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
