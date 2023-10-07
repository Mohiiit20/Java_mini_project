package Controller;


import Model.ModelAirline;
import Model.ModelAirport;

import View.View;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Controller {
    ModelAirport modelAirport;
    ModelAirline modelAirline;
    View view;
    public Controller(ModelAirport ma, ModelAirline ml, View v) {
        modelAirport = ma;
        modelAirline = ml;
        view = v;



        addButtonClickAp(ma);
        addButtonClickAl(ml);
       addScrollingAirline();
      addScrollingAirport();

    }
    private void addButtonClickAp(ModelAirport ma) {
        view.getMf().getIp().getBp().getBtn_airport().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                System.out.println("Airport Pressed");
                view.centerInitialSetup(ma.getManageAirportData().getLinesBeingDisplayed(), ma.getManageAirportData().getAirportHeaders().size());
                view.centerUpdate(ma.getManageAirportData().getLines(ma.getManageAirportData().getFirstLineToDisplay(), ma.getManageAirportData().getLastLineToDisplay()), ma.getManageAirportData().getAirportHeaders());
             //   addScrollingAirport();
            }

        });
    }
    private void addButtonClickAl(ModelAirline ml){

        view.getMf().getIp().getBp().getBtn_airline().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                System.out.println("Airline Pressed");
                view.centerInitialSetup(ml.getManageAirlineData().getLinesBeingDisplayed(), ml.getManageAirlineData().getAirlineHeaders().size());

                view.centerUpdate(ml.getManageAirlineData().getLines(ml.getManageAirlineData().getFirstLineToDisplay(), ml.getManageAirlineData().getLastLineToDisplay()), ml.getManageAirlineData().getAirlineHeaders());
             //   addScrollingAirline();
            }
        });
    }

    private void addScrollingAirport()
    {
        view.getMf().getIp().getCp().addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int units = e.getUnitsToScroll();
                System.out.println(units);
                int current_first_line = modelAirport.getManageAirportData().getFirstLineToDisplay();
                int current_last_line = modelAirport.getManageAirportData().getLastLineToDisplay();
                int no_of_players = modelAirport.getManageAirportData().getTable().size();
                int no_of_display_lines = modelAirport.getManageAirportData().getLinesBeingDisplayed();
                if(units <= 0 && current_first_line == 0)
                {
                    modelAirport.getManageAirportData().setFirstLineToDisplay(0);
                }
                else if(units <= 0 && current_first_line > 0)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line <= 0)
                    {
                        modelAirport.getManageAirportData().setFirstLineToDisplay(0);
                    }
                    else
                    {
                        modelAirport.getManageAirportData().setFirstLineToDisplay(new_first_line);
                    }
                }
                else if(units > 0 && current_last_line == no_of_players-1)
                {
                    modelAirport.getManageAirportData().setFirstLineToDisplay(current_first_line);
                }
                else if (units > 0 && current_last_line < no_of_players-1)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line > no_of_players - no_of_display_lines)
                    {
                        new_first_line = no_of_players-no_of_display_lines;
                        modelAirport.getManageAirportData().setFirstLineToDisplay(new_first_line);
                    }
                    else
                    {
                        modelAirport.getManageAirportData().setFirstLineToDisplay(new_first_line);
                    }
                }

                view.centerUpdate(modelAirport.getManageAirportData().getLines(modelAirport.getManageAirportData().getFirstLineToDisplay(), modelAirport.getManageAirportData().getLastLineToDisplay()), modelAirport.getManageAirportData().getAirportHeaders());
            }
        });
    }

    private void addScrollingAirline()
    {
        view.getMf().getIp().getCp().addMouseWheelListener(new MouseWheelListener() {
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

                view.centerUpdate(modelAirline.getManageAirlineData().getLines(modelAirline.getManageAirlineData().getFirstLineToDisplay(), modelAirline.getManageAirlineData().getLastLineToDisplay()), modelAirline.getManageAirlineData().getAirlineHeaders());
            }
        });
    }
}