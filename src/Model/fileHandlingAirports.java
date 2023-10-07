package Model;

import java.util.ArrayList;

abstract class fileHandlingAirports
{


    abstract public ArrayList<Airports> readJsonFile(String file_path);
    abstract public void writeJsonFile(ArrayList<Airports> airports);
    //public void readCSVFile(String file_path);
    //public void readXMLFile(String file_path);

}
