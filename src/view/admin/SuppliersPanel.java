package view.admin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class SuppliersPanel extends JPanel {

    private AddSupplierPanel pnlAddSupplier;

    private DefaultTableModel supplierData;
    private JTable supplierTable;
    private JScrollPane scrollPane;
    private String[] columnNames = {"Namn", "Adress", "Telefonnr" };

    public SuppliersPanel(){
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Leverantörer"));
        createElements();
        addElements();
    }

    public void createElements(){
        pnlAddSupplier = new AddSupplierPanel();

        supplierData = new DefaultTableModel();
        supplierTable = new JTable();
        supplierTable.setFillsViewportHeight(true);
        scrollPane = new JScrollPane(supplierTable);
        supplierData.setColumnIdentifiers(columnNames);
        supplierTable.setModel(supplierData);

    };

    public void addElements(){
        add(scrollPane, BorderLayout.CENTER);
        add(pnlAddSupplier, BorderLayout.SOUTH);
    }

    public AddSupplierPanel getPnlAddSupplier() {
        return pnlAddSupplier;
    }
}
