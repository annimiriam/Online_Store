package view;
import control.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel {

    private Controller controller;
    private JPanel gridPanel;
    private JLabel lblUserName;
    private JLabel lblPassword;

    private JTextField txtUsername;
    private JTextField txtPassword;

    private JButton btnLogIn;
    private JButton btnRegister;

    public LoginPanel(Controller controller) {
        this.controller = controller;
        setBorder(new EmptyBorder(10, 10, 10, 10));
        createElements();
        addElements();
        addListeners();
    }

    public void createElements() {
        gridPanel = new JPanel(new GridLayout(2, 2));
        lblUserName = new JLabel("Användarnamn: ");
        lblPassword = new JLabel("Lösenord: ");

        txtUsername = new JTextField();
        txtPassword = new JTextField();

        btnLogIn = new JButton("Logga in");
        btnRegister = new JButton("Registrera ny kund");
    }

    public void addElements() {
        gridPanel.add(lblUserName);
        gridPanel.add(txtUsername);

        gridPanel.add(lblPassword);
        gridPanel.add(txtPassword);

        add(gridPanel);
        add(btnLogIn);
        add(btnRegister);
    }

    public void addListeners() {
        btnLogIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //1. Kontrollera användarnamn och lösenord
                System.out.println("Logga in som: " + txtUsername.getText() + " " + txtPassword.getText());
                controller.checkLogin(txtUsername.getText(), txtPassword.getText());
            }
        });

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Registrera ny kund");
                controller.registerCustomer();
            }
        });
    }

}

