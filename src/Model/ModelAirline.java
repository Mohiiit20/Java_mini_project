package Model;

public class ModelAirline {
    protected manageAirlines manageAirlineData = new manageAirlines();

    public ModelAirline()
    {
        manageAirlineData.setLinesBeingDisplayed(25);
        manageAirlineData.setFirstLineToDisplay(0);
    }

    public manageAirlines getManageAirlineData()
    {
        return manageAirlineData;
    }
}
