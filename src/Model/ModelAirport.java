package Model;

import java.util.ArrayList;

public class ModelAirport
{
    protected manageAirports manageAirportData = new manageAirports();

    public ModelAirport()
    {
        manageAirportData.setLinesBeingDisplayed(25);
        manageAirportData.setFirstLineToDisplay(0);
    }

    public manageAirports getManageAirportData()
    {
        return manageAirportData;
    }
}