package Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Calendar;

/**
 * Identification comments:
 * Name: VED WAJE and MOHIT VAIDYA
 * Experiment No:4
 * Experiment Title:
 * Experiment Date:
 * 
 * @version 1.0
 *
 *
 *          Beginning comments:
 *          Filename: Airlines.java
 * @author: Ved Waje and Mohit Vaidya
 *          /* Overview: This class is created to store the attributes of
 *          Airlines. It is a
 *          subclass of the class "Company" which inherits
 *          some of the attributes from the Company class. And the class
 *          representing the "Company"
 *          object implements the interface named
 *          "Airline Operation".
 *
 *          Attribute comments:
 *          id : Airline id
 *          Name : Airline name
 *          Country_of_origin : Mentions origin country of airline
 *          Email : Gives email id of airline
 *          Destinations : Gives number of destinations where airline provides
 *          services
 */

// Airline class inherits company class and contains attributes unique for airline
// Airline class implements AirlineOperation interface
public class Airlines extends Company implements PromoCode{
    /* Airline attributes */

    ArrayList<String> airline_review;

    private int destinations;
    private String airlinecode;
     

    public Airlines(int id, String name, String email, String country_of_origin, int destinations, String airlinecode) {
        super(id, name, email, country_of_origin);
        setDestinations(destinations);
        setAirlinecode(airlinecode);
    }

    public Airlines(int id, String name, String email, String country_of_origin, int destinations) {

        super(id, name, email, country_of_origin);
        setDestinations(destinations);
        setAirlinecode(ConvertNameToCode(name));
    }


    public void setDestinations(int destinations) {
        this.destinations = destinations;
    }

    public void setAirlinecode(String airlinecode) {
        this.airlinecode = airlinecode;
    }

    public int getDestinations() {
        return this.destinations;
    }

    public String getAirlinecode() {
        return this.airlinecode;
    }


    // Method to convert airline name to a code
    @Override
    public String ConvertNameToCode(String name) {

        String[] words = name.split(" ");
        StringBuilder shortForm = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                shortForm.append(word.charAt(0));
            }
        }

        String result = shortForm.toString().toUpperCase();

        return result;

    }

    @Override
    public String generatePromoCode() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        String promoCode = ConvertNameToCode(getName()) + currentYear;
        return promoCode;
    }

    @Override
    public boolean isPromoCodeValid(String promoCode) {
        String validPromoCode = generatePromoCode();
        return promoCode.equals(validPromoCode);
    }
    public String displayAirline()
    {
        return " id : "+this.getAirlineId() +display_() +" ,AirlineCode :"+this.getAirlinecode()+" ,Total destinations :"+this.getDestinations();
    }



}