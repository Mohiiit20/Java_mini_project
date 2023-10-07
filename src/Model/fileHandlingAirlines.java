package Model;

import java.util.ArrayList;

abstract class fileHandlingAirlines
{


    abstract public ArrayList<Airlines> readJsonFile(String file_path);
    abstract public void writeJsonFile(ArrayList<Airlines> airlines);
    //public void readCSVFile(String file_path);
    //public void readXMLFile(String file_path);

}