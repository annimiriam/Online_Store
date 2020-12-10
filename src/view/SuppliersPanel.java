package view;
import control.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SuppliersPanel extends JPanel {
    private DefaultTableModel supplierData;
    private JTable supplierTable;
    private JScrollPane scrollPane;
    private String[] columnNames = {"Namn", "Adress", "Telefonnr" };

    private JButton btnRemoveSupplier;
    private JButton btnAddSupplier;

    public SuppliersPanel(){
        createElements();
        addElements();
    }

    public void createElements(){
        supplierData = new DefaultTableModel();
        supplierTable = new JTable();
        supplierTable.setFillsViewportHeight(true);
        scrollPane = new JScrollPane(supplierTable);
        supplierData.setColumnIdentifiers(columnNames);
        supplierTable.setModel(supplierData);
        btnAddSupplier = new JButton("Lägg till leverantör");
        btnRemoveSupplier = new JButton("Ta bort leverantör");
    };

    public void addElements(){
        add(scrollPane);
        add(btnRemoveSupplier);
        add(btnAddSupplier);
    }

}
