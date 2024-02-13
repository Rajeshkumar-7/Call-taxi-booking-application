package Models;

public class Booking {

    private int taxiId;

    private int customerId;

    private char from;

    private char to;

    private int pickUp;

    private int drop;

    private int cost;


    public Booking(int taxiId, int customerId, char from, char to, int pickUp, int drop, int cost) {
        this.taxiId = taxiId;
        this.customerId = customerId;
        this.from = from;
        this.to = to;
        this.pickUp = pickUp;
        this.drop = drop;
        this.cost = cost;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getTaxiId() {
        return taxiId;
    }

    public void setTaxiId(int taxiId) {
        this.taxiId = taxiId;
    }

    public char getFrom() {
        return from;
    }

    public void setFrom(char from) {
        this.from = from;
    }

    public char getTo() {
        return to;
    }

    public void setTo(char to) {
        this.to = to;
    }

    public int getPickUp() {
        return pickUp;
    }

    public void setPickUp(int pickUp) {
        this.pickUp = pickUp;
    }

    public int getDrop() {
        return drop;
    }

    public void setDrop(int drop) {
        this.drop = drop;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
