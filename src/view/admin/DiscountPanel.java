package view.admin;

import view.MainPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class DiscountPanel extends JPanel {

    private JPanel southPanel;
    private AddDiscountPanel pnlAddDiscount;

    private DefaultTableModel discountData;
    private JTable discountTable;
    private JScrollPane scrollPane;
    private String[] columnNames = {"Rabatt ID", "Namn", "Rabatt %", "from", "tom"};
    private MainPanel mainPanel;


    private UnconfirmedOrdersPanel panelUnconOrders;

    public DiscountPanel(MainPanel mainPanel, DefaultTableModel discountData) {
        this.mainPanel = mainPanel;
        this.discountData = discountData;
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Rabatter"));
        createElements();
        addElements();
    }

    private void createElements() {
        pnlAddDiscount = new AddDiscountPanel(mainPanel);
        panelUnconOrders = new UnconfirmedOrdersPanel(mainPanel);
        southPanel = new JPanel(new BorderLayout());

//        discountData = new DefaultTableModel();
        discountTable = new JTable();
        //discountTable.setFillsViewportHeight(true);
        scrollPane = new JScrollPane(discountTable);
        discountData.setColumnIdentifiers(columnNames);
        discountTable.setModel(discountData);

    }

    private void addElements() {
        add(scrollPane, BorderLayout.CENTER);
        add(pnlAddDiscount, BorderLayout.NORTH);
        add(panelUnconOrders, BorderLayout.SOUTH);
    }

    public AddDiscountPanel getPnlAddDiscount() {
        return pnlAddDiscount;
    }

    public void addItemToDiscountTable(String[] item) {
        //TODO
    }

    public void setDiscountTableData(DefaultTableModel updatedDiscountData) {
        discountData = updatedDiscountData;
        discountTable.setModel(discountData);
    }
}
