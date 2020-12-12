package view;

import javax.swing.*;

public class MainFrame extends JFrame {

    public MainFrame(MainPanel mainPanel) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("OnlineStore");
        setLocation(500, 300);
        setContentPane(mainPanel);
        pack();
        setVisible(true);
    }

}
