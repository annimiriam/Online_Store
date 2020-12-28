package view.admin;

import view.MainPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class SuppliersPanel extends JPanel {

    private AddSupplierPanel pnlAddSupplier;

    private DefaultTableModel supplierData;
    private JTable supplierTable;
    private JScrollPane scrollPane;
    private String[] columnNames = {"Namn", "Telefonnr", "Gatuadress", "Postnr", "Stad", "Land"};
    private MainPanel mainPanel;

    public SuppliersPanel(MainPanel mainPanel, DefaultTableModel supplierData) {
        this.mainPanel = mainPanel;
        this.supplierData = supplierData;

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Leverantörer"));
        createElements();
        addElements();
    }

    public void createElements() {
        pnlAddSupplier = new AddSupplierPanel(mainPanel);

        //supplierData = new DefaultTableModel();
        supplierTable = new JTable();
        supplierTable.setFillsViewportHeight(true);
        scrollPane = new JScrollPane(supplierTable);
        supplierData.setColumnIdentifiers(columnNames);
        supplierTable.setModel(supplierData);

    }

    public void addElements() {
        add(scrollPane, BorderLayout.CENTER);
        add(pnlAddSupplier, BorderLayout.SOUTH);
    }

    public AddSupplierPanel getPnlAddSupplier() {
        return pnlAddSupplier;
    }

    public void addItemToSupplierTable(String[] item) {
        //TODO
    }

    public void setSupplierData(DefaultTableModel updatedSupplierData) {
        supplierData = updatedSupplierData;
        supplierTable.setModel(supplierData);
    }
}
