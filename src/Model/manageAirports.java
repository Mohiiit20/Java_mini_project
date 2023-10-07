package Model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class manageAirports extends fileHandlingAirports implements Displayable {
    ArrayList<Airports> airport = new ArrayList<Airports>();
    /* public ArrayList<Airports> loadJsonFile(String file_path) {
        return readJsonFile(file_path);

    }*/
    private int linesBeingDisplayed;
    private int firstLineIndex;
    int lastLineIndex;
    int highlightedLine;

    public manageAirports(){
        readJsonFile("src/Model/airports.json");
    }
    public ArrayList<Airports> readJsonFile(String file_path) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read JSON file
            //JsonNode rootNode = objectMapper.readTree(new File("src/Model/temp.json"));
            JsonNode rootNode = objectMapper.readTree(new File(file_path));

            // Iterate through JSON array
            if (rootNode.isArray()) {
                for (JsonNode node : rootNode) {
                    String country = node.get("country").asText();
                    String code = node.get("code").asText();
                    int passengers = node.get("passengers").asInt();
                    double runwayLength = node.get("runwayLength").asDouble();
                    int runwayCount= node.get("runwayCount").asInt();
                    double airportArea = node.get("airportArea").asDouble();
                    int airportId = node.get("airportId").asInt();
                    String cityName = node.get("cityName").asText();
                    Airports aport = new Airports(cityName,country,airportId,code,passengers,runwayLength,runwayCount,airportArea);
                    airport.add(aport);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return airport;
    }
    @Override
    public void writeJsonFile(ArrayList<Airports> airports) {
        ObjectMapper Obj = new ObjectMapper();
        try {

            for (int i = 0; i < airports.size(); i++)
            {
                // Converting the Java object into a JSON string
                String stud_str = Obj.writeValueAsString(airports.get(i));
                // Displaying Java object into a JSON string
                System.out.println(stud_str);
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getAirportHeaders() {
        ArrayList<String> headers = new ArrayList<String>();
        headers.add("Id");
        headers.add("City");
        headers.add("Country");
        headers.add("Code");
        headers.add("Total Passengers");
        headers.add("Runway length");
        headers.add("Total Runways");
        headers.add("Airport Area");

        return headers;
    }

    /*
    The getLine(int line) method returns an ArrayList of String objects that represent a single row of the table.
    The method takes an integer argument line that specifies which row to retrieve. The method retrieves the FootballPlayer object
    at the specified index in the students list and then extracts the various attributes of the student such as their name, height, weight,
    etc. These attributes are then added to the ArrayList and returned.
     */
    @Override
    public ArrayList<String> getLine(int line) {
        ArrayList<String> airport_details = new ArrayList<String>();

        airport_details.add(String.valueOf(airport.get(line).getAirportId()));
        airport_details.add(airport.get(line).getCityName());
        airport_details.add(airport.get(line).getCountry());
        airport_details.add(airport.get(line).getCode());
        airport_details.add(String.valueOf(airport.get(line).getPassengers()));
        airport_details.add(String.valueOf(airport.get(line).getRunwayLength()));
        airport_details.add(String.valueOf(airport.get(line).getRunwayCount()));
        airport_details.add(String.valueOf(airport.get(line).getAirportArea()));

        return airport_details;
    }

    /*
    The getLines(int firstLine, int lastLine) method returns an ArrayList of ArrayList of String objects that represent a subset of rows
    of the table. The method takes two integer arguments firstLine and lastLine that specify the range of rows to retrieve.
    The method then iterates over this range and calls getLine(int line) for each row, adding the resulting ArrayList of attributes to a
    new ArrayList of ArrayList of String objects that is then returned.
     */
    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>> airports_subset = new ArrayList<ArrayList<String>>();

        for (int i = firstLine; i <= lastLine; i++) {
            airports_subset.add(getLine(i));
        }
        return airports_subset;
    }

    @Override
    public int getFirstLineToDisplay() {
        return firstLineIndex;
    }

    @Override
    public int getLineToHighlight() {
        return highlightedLine;
    }

    @Override
    public int getLastLineToDisplay() {
        setLastLineToDisplay(getFirstLineToDisplay() + getLinesBeingDisplayed() - 1);
        return lastLineIndex;
    }

    @Override
    public int getLinesBeingDisplayed() {
        return linesBeingDisplayed;
    }

    @Override
    public void setFirstLineToDisplay(int firstLine) {
        firstLineIndex = firstLine;
    }

    @Override
    public void setLineToHighlight(int highlightedLine) {
        highlightedLine = highlightedLine;
    }

    @Override
    public void setLastLineToDisplay(int lastLine) {
        lastLineIndex = lastLine;
    }

    @Override
    public void setLinesBeingDisplayed(int numberOfLines) {
        linesBeingDisplayed = numberOfLines;
    }

    public ArrayList getTable() {
        return airport;
    }
}


