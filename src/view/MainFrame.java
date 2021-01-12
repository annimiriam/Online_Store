package view;

import javax.swing.*;

public class MainFrame extends JFrame {

    public MainFrame(MainPanel mainPanel) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("OnlineStore");
        setLocation(100, 100);
        setContentPane(mainPanel);
        pack();
        setVisible(true);

    }

}
