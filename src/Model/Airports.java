/*  Overview: This class is created to store the attributes of Airports. It is a subclass of the class "Location" which inherits
some of the attributes from the Location class. And the class representing the "Location" object implements the interface named 
"Flight Services".
 *
 * Attribute comments: 
 * id : Airport id
 * City : Airport city
 * Country : Mentions origin country of airport
 * Passengers: Total passengers travelling (in millions)
 */

 // Airport class inherits Location class and has unique attributes of Airports
 // Airport class implements Flight Services Interface 
package Model;

public class Airports extends Location implements FlightServices {

    public Airports(String city, String country,int id ,String code,int passengers,double runway_length,int total_runways,double airport_area) {
        super(city,country);
        setAirportId(id);
        setCode(code);
        setPassengers(passengers);
        setRunwayLength(runway_length);
        setRunwayCount(total_runways);
        setAirport_area(airport_area);

    }
    private int id;

    private String code;
    // iata code

    private int passengers;

    // total passenger in millions
    private double runway_length;

    private int total_runways;

    private double airport_area;



    public void setAirportId(int id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public void setRunwayLength(double runway_length) {
        this.runway_length = runway_length;
    }

    public void setRunwayCount(int total_runways) {
        this.total_runways = total_runways;
    }
    public void setAirport_area(double airport_area) {
        this.airport_area = airport_area;
    }

    public int getAirportId() {
        return this.id;
    }

    public String getCode() {
        return this.code;
    }

    public int getPassengers() {
        return this.passengers;
    }

    public double getRunwayLength() {
        return this.runway_length;
    }

    public int getRunwayCount() {
        return this.total_runways;
    }
    public double getAirportArea() {
        return this.airport_area;
    }

    public String displayAirport()
    {
        return " id : "+this.getAirportId() +display() +" ,Code :"+this.getCode()+" ,Total passengers :"+this.getPassengers()+" ,Runway Length :"+this.getRunwayLength()+" ,Total Runways :"+this.getRunwayCount()+" ,Airport area :"+this.getAirportArea();
    }

    @Override
    public void canLand(double runway_length, double weight) {

        if (weight / runway_length >= 130) {
            System.out.println("The flight can't land on the runway.");
        } else {
            System.out.println("Flight can land sucessfully.");
        }

    }

    @Override
    public void canLand(double runway_length) {
        System.out.println("The maximum weight of flight possible is " + (130 * runway_length) + " Tonnes");

    }
     @Override
     public double calculatePassengerDensity(int passengers,double airportArea) {
        // Calculate and return passenger density.

            return passengers / airportArea;

    }


}
