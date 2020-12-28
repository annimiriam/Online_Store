package view.admin;

import view.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddSupplierPanel extends JPanel {
    private MainPanel mainPanel;
    private JPanel pnlInput;
    private JPanel pnlButtons;

    private JLabel lblName;
    private JLabel lblAddress;
    private JLabel lblPostnbr;
    private JLabel lblCity;
    private JLabel lblCountry;
    private JLabel lblPhone;

    private JTextField txtName;
    private JTextField txtAddress;
    private JTextField txtPostnbr;
    private JTextField txtCity;
    private JTextField txtCountry;
    private JTextField txtPhone;

    private JButton btnRemoveSupplier;
    private JButton btnAddSupplier;
    private JButton btnUpdateSupplier;

    public AddSupplierPanel(MainPanel mainPanel) {
        this.mainPanel=mainPanel;
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Lägg till leverantör"));
        createElements();
        addElements();
        addListeners();
    }

    public void createElements() {
        pnlInput = new JPanel(new GridLayout(6, 2));
        pnlButtons = new JPanel();

        lblName = new JLabel("Namn");
        lblAddress = new JLabel("Gatuadress");
        lblPostnbr = new JLabel("Postnr");
        lblCity = new JLabel("Stad");
        lblCountry = new JLabel("Land");
        lblPhone = new JLabel("Telefonnr");

        txtName = new JTextField();
        txtAddress = new JTextField();
        txtPostnbr = new JTextField();
        txtCity = new JTextField();
        txtCountry = new JTextField();
        txtPhone = new JTextField();

        btnAddSupplier = new JButton("Lägg till leverantör");
        btnRemoveSupplier = new JButton("Ta bort leverantör");
        btnUpdateSupplier = new JButton("Uppdatera leverantör");
    }

    public void addElements() {
        pnlInput.add(lblName);
        pnlInput.add(txtName);
        pnlInput.add(lblAddress);
        pnlInput.add(txtAddress);
        pnlInput.add(lblPostnbr);
        pnlInput.add(txtPostnbr);
        pnlInput.add(lblCity);
        pnlInput.add(txtCity);
        pnlInput.add(lblCountry);
        pnlInput.add(txtCountry);
        pnlInput.add(lblPhone);
        pnlInput.add(txtPhone);

        pnlButtons.add(btnAddSupplier);
        pnlButtons.add(btnRemoveSupplier);
        pnlButtons.add(btnUpdateSupplier);

        add(pnlInput, BorderLayout.CENTER);
        add(pnlButtons, BorderLayout.SOUTH);
    }

    //Get-metoder för att hämta input från textfälten

    public String getTxtName() {
        return txtName.getText();
    }

    public String getTxtAddress() {
        return txtAddress.getText();
    }

    public String getTxtPostnbr() {
        return txtPostnbr.getText();
    }

    public String getTxtCity() {
        return txtCity.getText();
    }

    public String getTxtCountry() {
        return txtCountry.getText();
    }

    public String getTxtPhone() {
        return txtPhone.getText();
    }

    public void addListeners() {
        btnAddSupplier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("klickat på add Supplier");
                System.out.println(txtName.getText());
                mainPanel.addSupplier();
            }
        });
    }


    public JButton getBtnRemoveSupplier() {
        return btnRemoveSupplier;
    }

    public JButton getBtnAddSupplier() {
        return btnAddSupplier;
    }

    public JButton getBtnUpdateSupplier() {
        return btnUpdateSupplier;
    }
}
