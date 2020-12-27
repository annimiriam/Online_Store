package view.customer;

import view.MainPanel;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;

public class MyOrdersPanel extends JPanel {
    private MainPanel mainPanel;
    private JPanel panelMyOrders;
    private JPanel panelOrderInventory;

    private DefaultTableModel myOrdersData;
    private DefaultTableModel orderDetailsData;
    private JTable tblMyOrders;
    private JTable tblOrderDetails;

    private JScrollPane scrollPaneMyOrders;
    private JScrollPane scrollPaneOrderDetails;
    private String[] columnNamesMyOrders = {"Ordernr", "Pris", "Datum"};
    private String[] columnNamesOrderDetails = {"Produkt", "Antal", "Pris"};

    public MyOrdersPanel(MainPanel mainPanel, DefaultTableModel myOrdersData, DefaultTableModel orderDetailsData) {
        this.mainPanel = mainPanel;
        this.myOrdersData = myOrdersData;
        this.orderDetailsData = orderDetailsData;
        setBorder(BorderFactory.createTitledBorder("Mina beställningar"));
        setLayout(new BorderLayout());
        createElements();
        addElements();
        addListeners();
    }

    public void createElements() {
        panelMyOrders = new JPanel();
        //myOrdersData = new DefaultTableModel();
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

    public void addElements() {
        panelMyOrders.add(scrollPaneMyOrders);
        panelOrderInventory.add(scrollPaneOrderDetails);

        add(panelMyOrders, BorderLayout.CENTER);
        add(panelOrderInventory, BorderLayout.SOUTH);
    }

    public void addItemToOrderTable(String[] item) {
        //TODO
    }

    public int getSelectedOrderDetails() {
        return Integer.parseInt((String) tblMyOrders.getValueAt(tblMyOrders.getSelectedRow(), 0));
    }

    public void addListeners() {
        // TODO När en rad är klickad, skicka getSelectedOrderDetails till databasen och hämta details för aktuell order

        tblMyOrders.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                setOrderDetailsData(mainPanel.getOrderDetails(getSelectedOrderDetails()));
                tblOrderDetails.setModel(orderDetailsData);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

    }

    public void setOrderDetailsData(DefaultTableModel orderDetailsData){
        this.orderDetailsData = orderDetailsData;
    }


}
