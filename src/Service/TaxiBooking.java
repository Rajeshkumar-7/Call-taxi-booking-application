package Service;

import Models.Booking;
import Models.Taxi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TaxiBooking {

    static int idx = 1;
    HashMap<Character , List<Taxi>> taxiMap;

    public TaxiBooking(List<Taxi> taxis){
        // Create the taxi map for all the stations
        // Initially A station will have all the taxis
        taxiMap = new HashMap<>();
        taxiMap.put('A' , new ArrayList<>());
        taxiMap.put('B' , new ArrayList<>());
        taxiMap.put('C' , new ArrayList<>());
        taxiMap.put('D' , new ArrayList<>());
        taxiMap.put('E' , new ArrayList<>());
        taxiMap.put('F' , new ArrayList<>());
        for(int i=0;i< taxis.size();i++) taxiMap.get('A').add(taxis.get(i));
    }

    public void bookTaxi(char s, char e, int pickUp) {

        // Check  if any taxis are available
        Taxi taxi = Utility.findTheTaxi(s , pickUp , taxiMap);

        // If there is no taxi available inform the customer
        if(taxi == null){
            System.out.println("Taxi is not available right now , sorry!!!");
            return;
        }

        // Calculate the time to reach the destination
        int travelTime = (int) (e - s);
        int dropTime = pickUp + travelTime;

        // Calculate the cost to travel
        int distance = travelTime * 15;
        int cost = 500 + ((distance - 5)*10);

        // Create the Booking entity
        Booking booking = new Booking(taxi.getId() , idx++ , s , e , pickUp , dropTime , cost);

        // Update the Taxi entity
        taxiMap.get(taxi.getLastLocation()).remove(taxi);
        taxi.setLastLocation(e);
        taxi.getBookings().add(booking);
        taxi.setTotalMoneyEarned(taxi.getTotalMoneyEarned() + cost);
        taxi.setFreeTime(dropTime);
        taxiMap.get(taxi.getLastLocation()).add(taxi);

        System.out.println("Taxi-"+taxi.getId()+" has been booked for you");
    }

    public static void printTaxiDetails(List<Taxi> taxis) {

//        System.out.println(taxis.size());

        for(int i=0;i<taxis.size();i++){
            Taxi taxi = taxis.get(i);
            // Print the Taxi details
            System.out.println("Taxi-"+taxi.getId()+"   Total Earnings : Rs . "+taxi.getTotalMoneyEarned()+
                    "    Taxi Current Location : "+taxi.getLastLocation()+"    Taxi next free time : "+taxi.getFreeTime());
            List<Booking> bookings = taxi.getBookings();
            for(Booking booking : bookings){
                // Print all the Booking Details
                System.out.println(booking.getTaxiId()+"    "+booking.getCustomerId()+"    "+
                        booking.getFrom()+"    "+ booking.getTo()+"    "+ booking.getPickUp()+
                        "    "+booking.getDrop()+"    "+booking.getCost());
            }
        }
    }

}
