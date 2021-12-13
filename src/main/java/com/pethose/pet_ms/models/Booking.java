package com.pethose.pet_ms.models;
import org.springframework.data.annotation.Id;

public class Booking {
    @Id
    private String id;
    private String usernameBooking;
    private String checkIn;
    private String checkOut;
    private Integer cost;

    public Booking(String id, String usernameBooking, String checkIn, String checkOut, Integer cost){

        this.id = id;
        this.usernameBooking = usernameBooking;
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

    public String getUsernameBooking() {
        return usernameBooking;
    }

    public void setUsernameBooking(String usernameBooking) {
        this.usernameBooking = usernameBooking;
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
