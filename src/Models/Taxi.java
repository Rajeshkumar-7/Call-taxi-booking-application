package Models;

import java.util.ArrayList;
import java.util.List;

public class Taxi {

    static int idx = 1;

    private int id;

    private int totalMoneyEarned;

    private char lastLocation;

    private int freeTime;

    private List<Booking> bookings;

    public Taxi(){
        this.id = idx++;
        this.totalMoneyEarned = 0;
        this.lastLocation = 'A';
        this.bookings = new ArrayList<>();
        this.freeTime = 0;
    }

    public int getFreeTime() {
        return freeTime;
    }

    public void setFreeTime(int freeTime) {
        this.freeTime = freeTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalMoneyEarned() {
        return totalMoneyEarned;
    }

    public void setTotalMoneyEarned(int totalMoneyEarned) {
        this.totalMoneyEarned = totalMoneyEarned;
    }

    public char getLastLocation() {
        return lastLocation;
    }

    public void setLastLocation(char lastLocation) {
        this.lastLocation = lastLocation;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
