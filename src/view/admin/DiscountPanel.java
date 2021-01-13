package view.admin;

import view.MainPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class DiscountPanel extends JPanel {

    private JPanel southPanel;
    private AddDiscountPanel pnlAddDiscount;

    //discounts
    private DefaultTableModel discountData;
    private JTable discountTable;
    private JScrollPane scrollPane;
    private String[] columnNames = {"Rabatt ID", "Namn", "Rabatt %", "from", "tom"};


    //Discounted products
    private DefaultTableModel discountedProductsData;
    private JTable discountedProductsTable;
    private JScrollPane discountedProductsscrollPane;
    private String[] discountedProductscolumnNames = { "Produkt ID", "Produkt namn", "Rabatt ID", "Rabatt namn", "Rabatt %", "from", "tom"};

    private MainPanel mainPanel;


//    private UnconfirmedOrdersPanel panelUnconOrders;

    public DiscountPanel(MainPanel mainPanel, DefaultTableModel discountData,DefaultTableModel discountedProductsData) {
       this.discountedProductsData = discountedProductsData;
        this.mainPanel = mainPanel;
        this.discountData = discountData;
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Rabatter"));
        createElements();
        addElements();
    }

    private void createElements() {
        pnlAddDiscount = new AddDiscountPanel(mainPanel);
//        panelUnconOrders = new UnconfirmedOrdersPanel(mainPanel);
        southPanel = new JPanel(new BorderLayout());

//        discountData = new DefaultTableModel();
        discountTable = new JTable();
        //discountTable.setFillsViewportHeight(true);
        scrollPane = new JScrollPane(discountTable);
        discountData.setColumnIdentifiers(columnNames);
        discountTable.setModel(discountData);

        discountedProductsTable = new JTable();
        discountedProductsData.setColumnIdentifiers(discountedProductscolumnNames);
        discountedProductsscrollPane = new JScrollPane(discountedProductsTable);
        discountedProductsTable.setModel(discountedProductsData);

    }

    private void addElements() {
        add(scrollPane, BorderLayout.CENTER);
        add(pnlAddDiscount, BorderLayout.NORTH);
//        add(panelUnconOrders, BorderLayout.SOUTH);

        add(discountedProductsscrollPane, BorderLayout.SOUTH);
    }

    public AddDiscountPanel getPnlAddDiscount() {
        return pnlAddDiscount;
    }

    public void addItemToDiscountTable(String[] item) {
        //TODO
    }

    public int getChosenDiscountId()
    { return Integer.parseInt((String) discountTable.getValueAt(discountTable.getSelectedRow(), 0));}

    public void setDiscountTableData(DefaultTableModel updatedDiscountData) {
        discountData = updatedDiscountData;
        discountData.setColumnIdentifiers(columnNames);
        discountTable.setModel(discountData);
    }

    public void setDiscountedProductsTableData(DefaultTableModel updatedDiscountedProductsData) {
        discountedProductsData = updatedDiscountedProductsData;
        discountedProductsData.setColumnIdentifiers(discountedProductscolumnNames);
        discountedProductsTable.setModel(discountedProductsData);
    }
}
