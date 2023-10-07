package View;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel  extends JPanel {
    JButton btn_airport = new JButton();
    JButton btn_airline = new JButton();

    public ButtonPanel(){
        btn_airport.setBackground(Color.cyan);
        btn_airport.setPreferredSize(new Dimension(80,25));
        btn_airport.setText("Airports");
        this.add(btn_airport);
        validate();
        repaint();
        btn_airline.setBackground(Color.cyan);
        btn_airline.setPreferredSize(new Dimension(80,25));
        btn_airline.setText("Airlines");
        this.add(btn_airline);
        validate();
        repaint();
    }

    public JButton getBtn_airport() {
        return btn_airport;
    }

    public JButton getBtn_airline() {
        return btn_airline;
    }
}
