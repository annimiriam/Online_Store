package view.customer;

import view.MainPanel;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;

public class MyOrdersPanel extends JPanel {
    private MainPanel mainPanel;
    private JPanel panelMyOrders;
    private JPanel panelOrderInventory;
    private JPanel panelRemoveOrder;

    private DefaultTableModel myOrdersData;
    private DefaultTableModel orderDetailsData;
    private JTable tblMyOrders;
    private JTable tblOrderDetails;

    private JButton btnRemoveOrder;

    private JScrollPane scrollPaneMyOrders;
    private JScrollPane scrollPaneOrderDetails;
    private String[] columnNamesMyOrders = {"Ordernr", "Pris", "Datum", "Status"};
    private String[] columnNamesOrderDetails = {"Produkt", "Antal"};

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
        panelMyOrders.setLayout(new GridLayout(2,1));
        //myOrdersData = new DefaultTableModel();
        tblMyOrders = new JTable();
        tblMyOrders.setSize(new Dimension(200, 100));
      //  tblMyOrders.setFillsViewportHeight(true);
        scrollPaneMyOrders = new JScrollPane(tblMyOrders);
        scrollPaneMyOrders.setSize(new Dimension(200,200));
        myOrdersData.setColumnIdentifiers(columnNamesMyOrders);
        tblMyOrders.setModel(myOrdersData);
        panelRemoveOrder = new JPanel();
        panelRemoveOrder.setSize(new Dimension(200, 30));
        btnRemoveOrder = new JButton("Radera markerad order");
        btnRemoveOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String status = (String) tblMyOrders.getValueAt(tblMyOrders.getSelectedRow(), 3);
               int orderNbr = getSelectedOrderDetails();
                if(status.equals("confirmed"))
                {
                    JOptionPane.showMessageDialog(null, "Denna order är redan bekräftad och går ej att radera.");
                }
                else{
                    mainPanel.deleteUnconfirmedOrderCustomer(orderNbr);
                    myOrdersData = mainPanel.getMyOrders();
                    tblMyOrders.setModel(myOrdersData);
                    JOptionPane.showMessageDialog(null, "Din order är nu raderad.");
                }
            }
        });

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
        panelRemoveOrder.add(btnRemoveOrder);
        panelMyOrders.add(panelRemoveOrder);
        panelOrderInventory.add(scrollPaneOrderDetails);

        add(panelMyOrders, BorderLayout.CENTER);
        add(panelOrderInventory, BorderLayout.SOUTH);
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
                orderDetailsData.setColumnIdentifiers(columnNamesOrderDetails);
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
        orderDetailsData.setColumnIdentifiers(columnNamesOrderDetails);
    }


}
