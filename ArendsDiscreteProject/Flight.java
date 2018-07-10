import java.text.*;
import java.util.*;

/**
 * This class will create flights with arrival and departure times.
 * 
 * Justin Arends 
 * Discrete II, Spring 2017, Semester Project
 * 4/26/2017
 */
public abstract class Flight
{
    public int number;
    public int time;
    private String airline;
    private String city;

   /**
     * Constructor for objects of class Flight
     */
   public Flight(String airline, int number, String city, int time)
   {
        this.airline = airline;
        this.number = number;
        this.city = city;
        this.time = time;
   }
    
   /**
     * Compares ticket times for their ordering in the sorted arraylist
     */
    public int compareTo(Flight otherFlight){
        if (this.time > otherFlight.time){
            return 1;
        }
        else if(this.time < otherFlight.time){
            return -1;
        }
        else{
            return 0;
        }
   }
   
   /**
    * Determines if one flight has a time conflict with another with a 15 minute buffer time added before and after its arrival or departure
    */
   
   public abstract boolean hasConflict(Flight otherFlight);

   /**
     * Returns the arrival or departure time of the flight
     */
    
   public String toString(){
        return airline + " | " + number + " | " + city + " | " + time;
   }
}
