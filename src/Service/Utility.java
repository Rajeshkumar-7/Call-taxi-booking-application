package Service;

import Models.Taxi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Utility {
    public static Taxi findTheTaxi(char s , int pickUp , HashMap<Character , List<Taxi>> taxiMap){

        // i -- > Represents the closest range from s
        int i = 0;
        while(s-i >= 'A' ||  s+i <= 'F'){
            char l = (char) (s - i);
            char r = (char) (i + s);
//            System.out.println(l+" , "+s);
            PriorityQueue<Taxi> taxis = new PriorityQueue<>((a,b) -> a.getTotalMoneyEarned() - b.getTotalMoneyEarned());
            if(taxiMap.containsKey(l)){
                List<Taxi> taxiList = taxiMap.get(l);
                for(Taxi taxi1 : taxiList){
                    if(taxi1.getFreeTime() <= pickUp){
                        taxis.add(taxi1);
                    }
                }
            }
            if(taxiMap.containsKey(r)){
                List<Taxi> taxiList = taxiMap.get(r);
                for(Taxi taxi1 : taxiList){
                    if(taxi1.getFreeTime() <= pickUp){
                        taxis.add(taxi1);
                    }
                }
            }

            if(!taxis.isEmpty()) return taxis.peek();
            i++;
        }
        System.out.println(i);
        return null;
    }
}
