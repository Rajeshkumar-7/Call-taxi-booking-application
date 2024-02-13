import Models.Taxi;
import Service.TaxiBooking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Give the Number of taxis");
        int n = sc.nextInt();

        // Creating the taxi entities
        List<Taxi> taxis = new ArrayList<>();
        for(int i=0;i<n;i++){
            Taxi taxi = new Taxi();
            taxis.add(taxi);
        }

        // Creating the Taxi Booking app
        TaxiBooking taxiBooking = new TaxiBooking(taxis);

        boolean opt = true;
        while(opt){
            System.out.println("Press 1 : To Book the Cab \n" +
                    "Press 2 : To print all the Taxi details \n" +
                    "Press Any other number to exit");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Give start location , end location and pickUp time");
                    char s = sc.next().charAt(0);
                    char e = sc.next().charAt(0);
                    int pickUp = sc.nextInt();
                    taxiBooking.bookTaxi(s , e , pickUp);
                    break;
                case 2:
                    TaxiBooking.printTaxiDetails(taxis);
                    break;
                default:
                    System.out.println("Thank you");
                    opt = false;
                    break;
            }

        }
    }
}