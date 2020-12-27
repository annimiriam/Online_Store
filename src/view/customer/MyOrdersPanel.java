package view.customer;

import view.MainPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MyOrdersPanel extends JPanel {
    private JPanel panelMyOrders;
    private JPanel panelOrderInventory;

    private DefaultTableModel myOrdersData;
    private DefaultTableModel orderDetailsData;
    private JTable tblMyOrders;
    private JTable tblOrderDetails;

    private JScrollPane scrollPaneMyOrders;
    private JScrollPane scrollPaneOrderDetails;
    private String[] columnNamesMyOrders = {"Ordernr", "Datum", "Pris"};
    private String[] columnNamesOrderDetails = {"Produkt", "Antal", "Pris"};

    public MyOrdersPanel(MainPanel mainPanel, DefaultTableModel myOrdersData, DefaultTableModel orderDetailsData) {
        this.myOrdersData = myOrdersData;
        this.orderDetailsData = orderDetailsData;
        setBorder(BorderFactory.createTitledBorder("Mina beställningar"));
        setLayout(new BorderLayout());
        createElements();
        addElements();
    }

    public void createElements() {
        panelMyOrders = new JPanel();
        myOrdersData = new DefaultTableModel();
        tblMyOrders = new JTable();
        tblMyOrders.setFillsViewportHeight(true);
        scrollPaneMyOrders = new JScrollPane(tblMyOrders);
        myOrdersData.setColumnIdentifiers(columnNamesMyOrders);
        tblMyOrders.setModel(myOrdersData);

        panelOrderInventory = new JPanel();
        orderDetailsData = new DefaultTableModel();
        tblOrderDetails = new JTable();
        tblOrderDetails.setFillsViewportHeight(true);
        scrollPaneOrderDetails = new JScrollPane(tblOrderDetails);
        orderDetailsData.setColumnIdentifiers(columnNamesOrderDetails);
        tblOrderDetails.setModel(orderDetailsData);
    }

    ;

    public void addElements() {
        panelMyOrders.add(scrollPaneMyOrders);
        panelOrderInventory.add(scrollPaneOrderDetails);

        add(panelMyOrders, BorderLayout.CENTER);
        add(panelOrderInventory, BorderLayout.SOUTH);
    }

    public void addItemToOrderTable(String[] item) {
        //TODO
    }

}
