package view.admin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class DiscountPanel extends JPanel {

    private AddDiscountPanel pnlAddDiscount;

    private DefaultTableModel discountData;
    private JTable discountTable;
    private JScrollPane scrollPane;
    private String[] columnNames = {"Rabatt ID", "Namn", "Rabatt %" };

    public DiscountPanel () {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Rabatter"));
        createElements();
        addElements();
    }

    private void createElements(){
        pnlAddDiscount = new AddDiscountPanel();

        discountData = new DefaultTableModel();
        discountTable = new JTable();
        discountTable.setFillsViewportHeight(true);
        scrollPane = new JScrollPane(discountTable);
        discountData.setColumnIdentifiers(columnNames);
        discountTable.setModel(discountData);

    }

    private void addElements(){
        add(scrollPane, BorderLayout.CENTER);
        add(pnlAddDiscount, BorderLayout.SOUTH);
    }

    public AddDiscountPanel getPnlAddDiscount() {
        return pnlAddDiscount;
    }

    public void addItemToDiscountTable(String[] item){
        //TODO
    }
}
