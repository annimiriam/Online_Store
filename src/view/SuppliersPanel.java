package view;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class SuppliersPanel extends JPanel {

    private JPanel panelAddSupplier;

    private DefaultTableModel supplierData;
    private JTable supplierTable;
    private JScrollPane scrollPane;
    private String[] columnNames = {"Namn", "Adress", "Telefonnr" };

    private JButton btnRemoveSupplier;
    private JButton btnAddSupplier;

    public SuppliersPanel(){
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Leverantörer"));
        createElements();
        addElements();
    }

    public void createElements(){
        panelAddSupplier = new JPanel();

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
        panelAddSupplier.add(btnAddSupplier);
        panelAddSupplier.add(btnRemoveSupplier);

        add(scrollPane, BorderLayout.CENTER);
        add(panelAddSupplier, BorderLayout.SOUTH);
    }

    // Metod eller metoder för att skicka meddelande från knapptrycken till controllern. Via MainPanel?

}
