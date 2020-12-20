package view.admin;

import view.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDiscountPanel extends JPanel {

    private JPanel pnlInput;
    private JPanel pnlButtons;

    private JLabel lblName;
    private JLabel lblId;
    private JLabel lblPercent;

    private JTextField txtName;
    private JTextField txtId;
    private JTextField txtPercent;

    private JButton btnAddDiscount;
    private JButton btnRemoveDiscount;

    private MainPanel mainPanel;


    public AddDiscountPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Hantera Rabatt"));
        createElements();
        addElements();
    }

    public void createElements() {
        pnlInput = new JPanel(new GridLayout(3, 2));
        pnlButtons = new JPanel();

        lblName = new JLabel("Namn");
        lblId = new JLabel("Id");
        lblPercent = new JLabel("Procent");

        txtName = new JTextField();
        txtId = new JTextField();
        txtPercent= new JTextField();

        btnAddDiscount = new JButton("Lägg till rabatt");
        btnAddDiscount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.addDiscount();
            }
        });
        btnRemoveDiscount = new JButton("Ta bort rabatt");
    }

    public void addElements() {
        pnlInput.add(lblId);
        pnlInput.add(txtId);
        pnlInput.add(lblName);
        pnlInput.add(txtName);
        pnlInput.add(lblPercent);
        pnlInput.add(txtPercent);
        pnlButtons.add(btnAddDiscount);
        pnlButtons.add(btnRemoveDiscount);

        add(pnlInput, BorderLayout.CENTER);
        add(pnlButtons, BorderLayout.SOUTH);
    }

    //Get-metoder för att hämta input från textfälten

    public String getTxtName() {
        return txtName.getText();
    }

    public String getTxtId() {
        return txtId.getText();
    }

    public String getTxtPercent() {
        return txtPercent.getText();
    }


}
