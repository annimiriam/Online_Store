package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class DiscountPanel extends JPanel {

    private JPanel panelAddDiscount;

    private DefaultTableModel discountData;
    private JTable discountTable;
    private JScrollPane scrollPane;
    private String[] columnNames = {"Rabatt ID", "Namn", "Rabatt %" };

    private JButton btnAddDiscount;
    private JButton btnRemoveDiscount;

    public DiscountPanel () {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Rabatter"));
        createElements();
        addElements();
    }

    public void createElements(){
        panelAddDiscount = new JPanel();

        discountData = new DefaultTableModel();
        discountTable = new JTable();
        discountTable.setFillsViewportHeight(true);
        scrollPane = new JScrollPane(discountTable);
        discountData.setColumnIdentifiers(columnNames);
        discountTable.setModel(discountData);

        btnAddDiscount = new JButton("Lägg till rabatt");
        btnRemoveDiscount = new JButton("Ta bort rabatt");
    }

    public void addElements(){
        panelAddDiscount.add(btnRemoveDiscount);
        panelAddDiscount.add(btnAddDiscount);

        add(scrollPane, BorderLayout.CENTER);
        add(panelAddDiscount, BorderLayout.SOUTH);
    }

    // Metod eller metoder för att skicka meddelande från knapptrycken till controllern. Via MainPanel?

}
