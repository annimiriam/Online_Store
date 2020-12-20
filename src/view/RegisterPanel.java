package view;
import control.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPanel extends JPanel {

    private MainPanel mainPanel;
    private JPanel gridPanel;


    private JLabel lblFirstName;
    private JLabel lblLastName;
    private JLabel lblEmail;
    private JLabel lblAddress;
    private JLabel lblCity;
    private JLabel lblCountry;
    private JLabel lblPhonenumber;
    private JLabel lblPassword;

    private JTextField txtFirstName;
    private JTextField txtLastName;
    private JTextField txtEmail;
    private JTextField txtPassword;
    private JTextField txtAddress;
    private JTextField txtCity;
    private JTextField txtCountry;
    private JTextField txtPhonenumber;

    private JButton btnRegister;

    public RegisterPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        createElements();
        addElements();
    }

    public void createElements() {
        gridPanel = new JPanel(new GridLayout(8,2));
        lblFirstName = new JLabel("Förnamn: ");
        lblLastName = new JLabel("Efternamn: ");
        lblEmail = new JLabel("Email: ");
        lblPassword = new JLabel("Lösenord: ");
        lblAddress = new JLabel("Gatuadress: ");
        lblCity = new JLabel("Stad: ");
        lblCountry = new JLabel("Land: ");
        lblPhonenumber = new JLabel("Telefonnummer: ");

        txtFirstName = new JTextField();
        txtLastName = new JTextField();
        txtEmail = new JTextField();
        txtPassword = new JTextField();
        txtAddress = new JTextField();
        txtCity = new JTextField();
        txtCountry = new JTextField();
        txtPhonenumber = new JTextField();

        btnRegister = new JButton("Registrera");
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.registerCustomer();
            }
        });
    }

    public void addElements() {
        gridPanel.add(lblFirstName);
        gridPanel.add(txtFirstName);
        gridPanel.add(lblLastName);
        gridPanel.add(txtLastName);
        gridPanel.add(lblAddress);
        gridPanel.add(txtAddress);
        gridPanel.add(lblCity);
        gridPanel.add(txtCity);
        gridPanel.add(lblCountry);
        gridPanel.add(txtCountry);
        gridPanel.add(lblPhonenumber);
        gridPanel.add(txtPhonenumber);
        gridPanel.add(lblEmail);
        gridPanel.add(txtEmail);
        gridPanel.add(lblPassword);
        gridPanel.add(txtPassword);

        add(gridPanel, this);
        add(btnRegister, this);

    }

    // Metoder för att returnera strängar från textfälten till controllern. Via MainPanel?

    public String getTxtFirstName(){
        return txtFirstName.getText();
    }

    public String getTxtLastName(){
        return txtLastName.getText();
    }

    public String getTxtEmail(){
        return txtEmail.getText();
    }

    public String getTxtPassword(){
        return txtPassword.getText();
    }

    public String getTxtAddress(){
        return txtAddress.getText();
    }

    public String getTxtCity(){
        return txtCity.getText();
    }

    public String getTxtCountry(){
        return txtCountry.getText();
    }

    public String getTxtPhonenumber(){
        return txtPhonenumber.getText();
    }

}
