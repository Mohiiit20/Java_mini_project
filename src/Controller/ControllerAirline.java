package Controller;

import Model.ModelAirline;
import View.View;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ControllerAirline {
    ModelAirline modelAirline;
    View viewAl;

    public ControllerAirline(ModelAirline m, View v) {
        modelAirline = m;
        viewAl = v;
        viewAl.centerInitialSetup(modelAirline.getManageAirlineData().getLinesBeingDisplayed(), modelAirline.getManageAirlineData().getAirlineHeaders().size());
        viewAl.centerUpdate(modelAirline.getManageAirlineData().getLines(modelAirline.getManageAirlineData().getFirstLineToDisplay(), modelAirline.getManageAirlineData().getLastLineToDisplay()), modelAirline.getManageAirlineData().getAirlineHeaders());
        addScrolling();
        addButtonClick();
    }
    private void addButtonClick()
    {
        viewAl.getMf().getIp().getBp().getBtn_airport().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                System.out.println("Airline Pressed");

                viewAl.centerUpdate(modelAirline.getManageAirlineData().getLines(modelAirline.getManageAirlineData().getFirstLineToDisplay(), modelAirline.getManageAirlineData().getLastLineToDisplay()), modelAirline.getManageAirlineData().getAirlineHeaders());
            }
        });

        viewAl.getMf().getIp().getBp().getBtn_airline().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                System.out.println("Airport Pressed");
            }
        });
    }

    private void addScrolling()
    {
        viewAl.getMf().getIp().getCp().addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int units = e.getUnitsToScroll();
                System.out.println(units);
                int current_first_line = modelAirline.getManageAirlineData().getFirstLineToDisplay();
                int current_last_line = modelAirline.getManageAirlineData().getLastLineToDisplay();
                int no_of_players = modelAirline.getManageAirlineData().getTable().size();
                int no_of_display_lines = modelAirline.getManageAirlineData().getLinesBeingDisplayed();
                if(units <= 0 && current_first_line == 0)
                {
                    modelAirline.getManageAirlineData().setFirstLineToDisplay(0);
                }
                else if(units <= 0 && current_first_line > 0)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line <= 0)
                    {
                        modelAirline.getManageAirlineData().setFirstLineToDisplay(0);
                    }
                    else
                    {
                        modelAirline.getManageAirlineData().setFirstLineToDisplay(new_first_line);
                    }
                }
                else if(units > 0 && current_last_line == no_of_players-1)
                {
                    modelAirline.getManageAirlineData().setFirstLineToDisplay(current_first_line);
                }
                else if (units > 0 && current_last_line < no_of_players-1)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line > no_of_players - no_of_display_lines)
                    {
                        new_first_line = no_of_players-no_of_display_lines;
                        modelAirline.getManageAirlineData().setFirstLineToDisplay(new_first_line);
                    }
                    else
                    {
                        modelAirline.getManageAirlineData().setFirstLineToDisplay(new_first_line);
                    }
                }

                viewAl.centerUpdate(modelAirline.getManageAirlineData().getLines(modelAirline.getManageAirlineData().getFirstLineToDisplay(), modelAirline.getManageAirlineData().getLastLineToDisplay()), modelAirline.getManageAirlineData().getAirlineHeaders());
            }
        });
    }
}