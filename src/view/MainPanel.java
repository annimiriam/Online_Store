package view;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainPanel extends JPanel {

    public MainPanel(LoginPanel loginPanel) {
        setBorder(new EmptyBorder(10,10,10,10));
        setLayout(new BorderLayout());
        add(loginPanel, BorderLayout.NORTH);
    }
}
