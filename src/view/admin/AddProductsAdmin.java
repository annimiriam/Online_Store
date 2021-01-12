package view.admin;

import view.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddProductsAdmin extends JPanel {

    private MainPanel mainPanel;

    private JPanel pnlInput;
    private JPanel pnlButtons;

    private JLabel lblId;
    private JLabel lblName;
    private JLabel lblBaseprice;
    private JLabel lblSupplier;
    private JLabel lblQuantity;

    private JTextField txtId;
    private JTextField txtName;
    private JTextField txtBaseprice;
    private JTextField txtSupplier;
    private JTextField txtQuantity;

    private JButton btnAddNewProduct;
    private JButton btnUpdateQuantity;

    public AddProductsAdmin(MainPanel mainpanel) {
        this.mainPanel = mainpanel;
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Lägg till produkt"));
        createElements();
        addElements();
    }

    public void createElements() {
        pnlInput = new JPanel(new GridLayout(5, 2));
        pnlButtons = new JPanel();

        lblId = new JLabel("Id");
        lblName = new JLabel("Namn");
        lblBaseprice = new JLabel("Baspris");
        lblSupplier = new JLabel("Leverantör");
        lblQuantity = new JLabel("Antal");

        txtId = new JTextField();
        txtName = new JTextField();
        txtBaseprice = new JTextField();
        txtSupplier = new JTextField();
        txtQuantity = new JTextField();

        btnAddNewProduct = new JButton("Lägg till ny");
        btnUpdateQuantity = new JButton("Uppdatera lager"); //Bättre namn, lägg till antal i lager? Vad ska den göra plussa på?
    }

    public void addElements() {
        pnlInput.add(lblId);
        pnlInput.add(txtId);
        pnlInput.add(lblName);
        pnlInput.add(txtName);
        pnlInput.add(lblBaseprice);
        pnlInput.add(txtBaseprice);
        pnlInput.add(lblSupplier);
        pnlInput.add(txtSupplier);
        pnlInput.add(lblQuantity);
        pnlInput.add(txtQuantity);

        pnlButtons.add(btnAddNewProduct);
        pnlButtons.add(btnUpdateQuantity);

        addListeners();

        add(pnlInput, BorderLayout.CENTER);
        add(pnlButtons, BorderLayout.SOUTH);
    }

    public String getTxtId() {
        return txtId.getText();
    }

    public String getTxtName() {
        return txtName.getText();
    }

    public String getTxtBaseprice() {
        return txtBaseprice.getText();
    }

    public String getTxtSupplier() {
        return txtSupplier.getText();
    }

    public String getTxtQuantity() {
        return txtQuantity.getText();
    }

    public void addListeners() {
        btnAddNewProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("klickat på add product-knappen");
                mainPanel.addProduct();
                clear();
            }
        });

        btnUpdateQuantity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("klickat på uppdatera lager-lnappen");
                mainPanel.updateProductQty();
                clear();

            }
        });


    }

    public void setSelectedProduct(String id, String name, String qty) {
        txtId.setText(id);
        txtId.setEnabled(false);
        txtName.setText(name);
        txtName.setEnabled(false);
        txtQuantity.setText(qty);
    }

    public void clear(){
        txtId.setText("");
        txtId.setEnabled(true);
        txtName.setText("");
        txtName.setEnabled(true);
        txtQuantity.setText("");
        txtBaseprice.setText("");
        txtSupplier.setText("");
    }


}
