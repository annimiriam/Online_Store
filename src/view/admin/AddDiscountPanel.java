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
    private JLabel lblFrom;
    private JLabel lblTom;
    private JLabel lblGiveProductDiscount;

    private JTextField txtName;
    private JTextField txtId;
    private JTextField txtPercent;
    private JTextField txtDateFrom;
    private JTextField txtDateTom;
    private JTextField txtGiveProductDiscount;

    private JButton btnAddDiscount;
    private JButton btnRemoveDiscount;
    private JButton btnGiveProductDiscount;

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
        lblFrom = new JLabel("From yymmdd?");
        lblTom = new JLabel("Tom yymmdd?");
        lblGiveProductDiscount = new JLabel("Produktkod");

        txtName = new JTextField();
        txtId = new JTextField();
        txtPercent = new JTextField();
        txtDateFrom = new JTextField();
        txtDateTom = new JTextField();
        txtGiveProductDiscount = new JTextField();

        btnAddDiscount = new JButton("Lägg till rabatt");
        btnAddDiscount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Klickat på add Discount.knapp");
                mainPanel.addDiscount();
            }
        });
        btnGiveProductDiscount = new JButton("Ge vara rabatt");
        btnGiveProductDiscount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int discountId = mainPanel.getChosenDiscountId();
                int productId = Integer.parseInt(txtGiveProductDiscount.getText());
                mainPanel.giveProductDiscount(discountId, productId);
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
        pnlInput.add(lblFrom);
        pnlInput.add(txtDateFrom);
        pnlInput.add(lblTom);
        pnlInput.add(txtDateTom);
        pnlInput.add(lblGiveProductDiscount);
        pnlInput.add(txtGiveProductDiscount);
        pnlButtons.add(btnAddDiscount);
        pnlButtons.add(btnRemoveDiscount);
        pnlButtons.add(btnGiveProductDiscount);

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

    public String getDateFrom() {return txtDateFrom.getText();}
    public String getDateTo() {return txtDateTom.getText();}


}
