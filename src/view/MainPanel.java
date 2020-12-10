package view;
import control.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainPanel extends JPanel {

    private Controller controller;
    private JPanel panelNorth;
    private JPanel panelWest;
    private JPanel panelCenter;
    private JPanel panelEast;
    private JPanel panelSouth;

    public MainPanel(Controller controller) {
        this.controller = controller;
        setPreferredSize(new Dimension(500,300));
        setBorder(new EmptyBorder(10,10,10,10));
        setupPanels();
        setupMainPanel();
    }

    public void setupPanels() {
        panelNorth = new LoginPanel(controller);
        panelWest = new JPanel();
        panelCenter = new JPanel();
        panelEast = new JPanel();
        panelSouth = new JPanel();
    }

    public void setupMainPanel() {
        setLayout(new BorderLayout());
        add(panelNorth, BorderLayout.NORTH);
        add(panelWest, BorderLayout.WEST);
        add(panelCenter, BorderLayout.CENTER);
        add(panelEast, BorderLayout.EAST);
        add(panelSouth, BorderLayout.SOUTH);
    }

    public JPanel getPanelNorth() {
        return panelNorth;
    }

    public void setPanelNorth(JPanel panelNorth) {
        this.panelNorth = panelNorth;
    }

    public JPanel getPanelWest() {
        return panelWest;
    }

    public void setPanelWest(JPanel panelWest) {
        this.panelWest = panelWest;
    }

    public JPanel getPanelCenter() {
        return panelCenter;
    }

    public void setPanelCenter(JPanel panelCenter) {
        this.panelCenter = panelCenter;
    }

    public JPanel getPanelEast() {
        return panelEast;
    }

    public void setPanelEast(JPanel panelEast) {
        this.panelEast = panelEast;
    }

    public JPanel getPanelSouth() {
        return panelSouth;
    }

    public void setPanelSouth(JPanel panelSouth) {
        this.panelSouth = panelSouth;
    }
}
