package view;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MyOrdersPanel extends JPanel {
    private JPanel panelMyOrders;
    private JPanel panelOrderDetails;

    private DefaultTableModel myOrdersData;
    private DefaultTableModel orderDetailsData;
    private JTable tblMyOrders;
    private JTable tblOrderDetails;

    private JScrollPane scrollPaneMyOrders;
    private JScrollPane scrollPaneOrderDetails;
    private String[] columnNamesMyOrders = {"Ordernr", "Datum", "Pris" };
    private String[] columnNamesOrderDetails = {"Produkt", "Antal", "Pris" };

    public MyOrdersPanel(){
        setBorder(BorderFactory.createTitledBorder("Mina beställningar"));
        setLayout(new BorderLayout());
        createElements();
        addElements();
    }

    public void createElements(){
        panelMyOrders = new JPanel();
        myOrdersData = new DefaultTableModel();
        tblMyOrders = new JTable();
        tblMyOrders.setFillsViewportHeight(true);
        scrollPaneMyOrders = new JScrollPane(tblMyOrders);
        myOrdersData.setColumnIdentifiers(columnNamesMyOrders);
        tblMyOrders.setModel(myOrdersData);

        panelOrderDetails = new JPanel();
        orderDetailsData = new DefaultTableModel();
        tblOrderDetails = new JTable();
        tblOrderDetails.setFillsViewportHeight(true);
        scrollPaneOrderDetails = new JScrollPane(tblOrderDetails);
        orderDetailsData.setColumnIdentifiers(columnNamesOrderDetails);
        tblOrderDetails.setModel(orderDetailsData);
    };

    public void addElements(){
        panelMyOrders.add(scrollPaneMyOrders);
        panelOrderDetails.add(scrollPaneOrderDetails);

        add(panelMyOrders, BorderLayout.CENTER);
        add(panelOrderDetails, BorderLayout.SOUTH);
    }

}
