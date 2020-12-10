package view;
import control.*;
import javax.swing.*;

public class MainFrame extends JFrame {

    private Controller controller;
    private MainPanel mainPanel;

    public MainFrame(Controller controller, MainPanel mainPanel) {
        this.controller = controller;
        this.mainPanel=mainPanel;

        setupFrame();
    }

    public void setupFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("OnlineStore");
        setContentPane(mainPanel);
        pack();
        setVisible(true);
    }

}
