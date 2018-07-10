/**
 * This class will create flight departures.
 * 
 * Justin Arends 
 * Discrete II, Spring 2017, Semester Project
 * 4/26/2017
 */
public class Departure extends Flight
{
    //Instantiates the time the gate is locked before arrival.
    private final static int buffer = 15;
    /**
     * Constructor for objects of class Departure
     */
    public Departure(String airline, int number, String city, int time)
    {
        super(airline, number, city, time);
    }
    
    /**
     * Adds additional departure message to the toString() method.
     */
    public String toString(){
        String x = super.toString();
        String statement = "Departure: " + x;
        return statement;
    }
    
     /**
     * Determines if there is a time conflict between the flight to be placed and a flight already assigned
     * Prints if there is a time conflict or not between two flights for further error proofing.
     */
    public boolean hasConflict(Flight otherFlight){
        System.out.println();
        System.out.println("Comparing flights " + this.number + " vs " + otherFlight.number);
        System.out.println("Begin comparison of " + this.time + " vs " + otherFlight.time);
        if(((Math.abs(this.time - otherFlight.time) < 100) && (this.time%100 <= 15) && (otherFlight.time%100 >=45)))
        {
            System.out.println("TIME CONFLICT " + this.time + " AND " + otherFlight.time);
            return true;
        }
        else if ((Math.abs(this.time/100 - otherFlight.time/100) == 0) && (Math.abs(this.time - otherFlight.time) <= 30 )){
            System.out.println("TIME CONFLICT " + this.time + " AND " + otherFlight.time);
            return true;
        }
        else{
            System.out.println("No conflicts between " + this.time + " and " + otherFlight.time);
            return false;
        }
    }
}