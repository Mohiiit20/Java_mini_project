package Model;
//Manages class managing relation between airports and airlines

public class Manages {
    private String arrivalTime;
    Airlines ObjAirline;
    Airports ObjAirport;

    public void airport_managed_airline(Airlines tempAirline, Airports tempAirport, String temp_arrival_time) {
        ObjAirline = tempAirline; // function to set relation
        ObjAirport = tempAirport;
        arrivalTime = temp_arrival_time;
    }

    public void display_flight() { // function to print output
        System.out.println("Flight of " + this.ObjAirline.getName() + " arrived at airport of "
                + this.ObjAirport.getCityName() + " at " + arrivalTime);
    }
}
