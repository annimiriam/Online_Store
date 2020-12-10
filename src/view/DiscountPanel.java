package view;
import control.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class DiscountPanel extends JPanel {
    private DefaultTableModel discountData;
    private JTable discountTable;
    private JScrollPane scrollPane;
    private String[] columnNames = {"Rabatt ID", "Namn", "Rabatt %" };

    private JButton btnAddDiscount;
    private JButton btnRemoveDiscount;

    public DiscountPanel () {
        setBorder(new EmptyBorder(10,10,10,10));
        createElements();
        addElements();
    }

    public void createElements(){
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
        add(scrollPane);
        add(btnRemoveDiscount);
        add(btnAddDiscount);
    }

}
