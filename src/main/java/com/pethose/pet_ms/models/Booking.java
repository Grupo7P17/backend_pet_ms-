package com.pethose.pet_ms.models;
import org.springframework.data.annotation.Id;
import java.util.Date;


public class Booking {
    @Id
    private String id;
    private String username;
    private String checkIn;
    private String checkOut;
    private Integer cost;

    public Booking(String id, String username, String checkIn, String checkOut, Integer cost, String id1){

        this.id = id;
        this.username = username;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}
