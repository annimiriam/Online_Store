package view;
import control.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainPanel extends JPanel {

    private Controller controller;
    private JPanel panelNorth;

    public MainPanel(Controller controller) {
        this.controller = controller;
        panelNorth = new LoginPanel(controller);
        setBorder(new EmptyBorder(10,10,10,10));
        setLayout(new BorderLayout());
        add(panelNorth, BorderLayout.NORTH);
    }
}
