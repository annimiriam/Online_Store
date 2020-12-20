package view;
import control.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel {

    private MainPanel mainPanel;
    private JPanel gridPanel1;
    private JPanel gridPanel2;
    private JLabel lblUserName;
    private JLabel lblPassword;

    private JTextField txtUsername;
    private JTextField txtPassword;

    private JButton btnLogIn;
    private JButton btnRegister;

    public LoginPanel( MainPanel mainPanel) {
        this.mainPanel = mainPanel;
        setBorder(BorderFactory.createTitledBorder("Logga in"));
        createElements();
        addElements();
        addListeners();
    }

    public void createElements() {
        gridPanel1 = new JPanel(new GridLayout(2, 2));
        gridPanel2 = new JPanel(new GridLayout(2, 1));
        lblUserName = new JLabel("Användarnamn: ");
        lblPassword = new JLabel("Lösenord: ");

        txtUsername = new JTextField();
        txtPassword = new JTextField();

        btnLogIn = new JButton("Logga in");
        btnRegister = new JButton("Registrera ny kund");
    }

    public void addElements() {
        gridPanel1.add(lblUserName);
        gridPanel1.add(txtUsername);

        gridPanel1.add(lblPassword);
        gridPanel1.add(txtPassword);


        gridPanel2.add(btnLogIn);
        gridPanel2.add(btnRegister);

        add(gridPanel1);
        add(gridPanel2);
    }

    public void addListeners() {
        btnLogIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //1. Kontrollera användarnamn och lösenord
                System.out.println("Logga in som: " + txtUsername.getText() + " " + txtPassword.getText());
                mainPanel.login();
                mainPanel.checkLogin(txtUsername.getText(), txtPassword.getText());//TODO ta bort sen
            }
        });

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Registrera ny kund");
                mainPanel.showRegisterCustomerPanel();
            }
        });
    }

    public String getTxtUsername() {
        return txtUsername.getText();
    }

    public String getTxtPassword() {
        return txtPassword.getText();
    }
}

