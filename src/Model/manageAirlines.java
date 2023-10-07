package Model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class manageAirlines extends fileHandlingAirlines implements Displayable {
    ArrayList<Airlines> airline = new ArrayList<Airlines>();
    /*public ArrayList<Student> loadJsonFile(String file_path) {
        return readJsonFile(file_path);
    }*/
    private int linesBeingDisplayed;
    private int firstLineIndex;

    int lastLineIndex;
    int highlightedLine;

    public manageAirlines(){
        readJsonFile("src/Model/airlines.json");
    }
    public ArrayList<Airlines> readJsonFile(String file_path) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read JSON file
            //JsonNode rootNode = objectMapper.readTree(new File("src/Model/temp.json"));
            JsonNode rootNode = objectMapper.readTree(new File(file_path));

            // Iterate through JSON array
            if (rootNode.isArray()) {
                for (JsonNode node : rootNode) {
                    String name = node.get("name").asText();
                    String email = node.get("email").asText();
                    String country_of_origin = node.get("country_of_origin").asText();
                    int destinations = node.get("destinations").asInt();
                    int airlineId = node.get("airlineId").asInt();


                    Airlines aline = new Airlines(airlineId,name,email,country_of_origin,destinations);
                    airline.add(aline);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return airline;
    }
    @Override
    public void writeJsonFile(ArrayList<Airlines> airlines) {
        ObjectMapper Obj = new ObjectMapper();
        try {

            for (int i = 0; i < airlines.size(); i++)
            {
                // Converting the Java object into a JSON string
                String stud_str = Obj.writeValueAsString(airlines.get(i));
                // Displaying Java object into a JSON string
                System.out.println(stud_str);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getAirlineHeaders() {
        ArrayList<String> headers = new ArrayList<String>();
        headers.add("Id");
        headers.add("name");
        headers.add("Country of Orign");
        headers.add("Total destinations");
        headers.add("Code");
        headers.add("Email");


        return headers;
    }

    @Override
    public ArrayList<String> getLine(int line) {
        ArrayList<String> airline_details = new ArrayList<String>();

        airline_details.add(String.valueOf(airline.get(line).getAirlineId()));
        airline_details.add(airline.get(line).getName());
        airline_details.add(airline.get(line).getCountry_of_origin());
        airline_details.add(String.valueOf(airline.get(line).getDestinations()));
        airline_details.add(airline.get(line).getAirlinecode());
        airline_details.add(airline.get(line).getEmail());

        return airline_details;
    }
    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>> airlines_subset = new ArrayList<ArrayList<String>>();

        for (int i = firstLine; i <= lastLine; i++) {
            airlines_subset.add(getLine(i));
        }
        return airlines_subset;
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
        return airline;
    }
}




