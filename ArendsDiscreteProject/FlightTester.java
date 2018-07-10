import java.io.*; // for use of files
import java.util.*; // for use of Scanner class

/**
 * Creates an arraylist of flights sorted by time and
 * assigns them to a gate using the least possible gates.
 * 
 * Justin Arends
 */

public class FlightTester
{
    public static void main(String [] args)
    {
            Scanner input = null;
            File inputFile = null;
            try{
            inputFile = new File("inputFile.txt");
            input = new Scanner(inputFile);
            }
            catch (FileNotFoundException e) {
                System.out.println("No file found!");
            }
            //Creates an arraylist of flights to be sorted by time
            ArrayList<Flight> list = new ArrayList();
            while(input.hasNext())
            {
               char code = input.next().charAt(0);
               //Creates ticket items based on arrival or departure
               Flight newFlight;
               if (code == 'A'){
                   newFlight = new Arrival(input.next(), input.nextInt(), input.next(), input.nextInt());
               }
               else{
                   newFlight = new Departure(input.next(), input.nextInt(), input.next(), input.nextInt());
               }
               if (list.size() == 0){
                   list.add(newFlight);
               }
               //Orders the flight into its position in the list.
               else if (newFlight.compareTo(list.get(list.size()-1)) < 0){
                        if(newFlight.compareTo(list.get(0)) < 0){
                            list.add(0, newFlight);
                            //System.out.println("in if");
                        }
                        else{
                        int i = 1;
                        while (newFlight.compareTo(list.get(list.size()-i)) < 0 && i < list.size()){
                            i++;
                            //System.out.println("in while");
                        }
                        list.add(list.size()-i+1, newFlight);
                        }
               }
               
               else{
                    list.add(newFlight);
               }
            }
            //Prints the arraylist of flights in order by time
            for(int i = 0; i < list.size(); i++){
                System.out.println(list.get(i));
            }
            //Creates new arraylists for every available gate
            ArrayList<Flight> B1 = new ArrayList(), B2 = new ArrayList(), B3 = new ArrayList(), 
            B4 = new ArrayList(), B5 = new ArrayList(), B6 = new ArrayList(), B7 = new ArrayList(), 
            B8 = new ArrayList(), B9 = new ArrayList(), B10 = new ArrayList();
            
            //Creates an arraylist of all available gate arrays to be stored
            ArrayList<ArrayList<Flight>> gates = new ArrayList<ArrayList<Flight>>();
            gates.add(B1);
            gates.add(B2);
            gates.add(B3);
            gates.add(B4);
            gates.add(B5);
            gates.add(B6);
            gates.add(B7);
            gates.add(B8);
            gates.add(B9);
            gates.add(B10);
            
            //For each flight in the flight arraylist, iterates through the available gates until a match is found with no conflicting flights.
            for(int i = 0; i < list.size(); i++){
                boolean gateAssigned = false;
                int z = 0;
                while(gateAssigned == false){
                    if (gates.get(z).isEmpty() || (list.get(i).hasConflict(gates.get(z).get(gates.get(z).size() - 1)) == false)){
                        gates.get(z).add(list.get(i));
                        gateAssigned = true;
                    }
                    z++;
                }
            }
            System.out.println();
            
            //Prints the gate assignments in order by time
             for(int i = 0; i < gates.size(); i++){
                 for (int z=0; z < gates.get(i).size(); z++){
                     System.out.println("Gate " + "B" + (i+1) + " contains flight " + gates.get(i).get(z).toString());
            }
            System.out.println();
            }
    }
}
