package view;

import javax.swing.*;

public class MainFrame extends JFrame {

    public MainFrame(MainPanel mainPanel) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("OnlineStore");
        setLocation(0, 0);
        setContentPane(mainPanel);
        pack();
        setVisible(true);

    }

}
