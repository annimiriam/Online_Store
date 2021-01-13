package view.customer;
import view.MainPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShoppingListPanel extends JPanel {

    private JPanel panelSouth;
    private DefaultTableModel shoppingListData;
    private JTable shoppingListTable;
    private JScrollPane scrollPane;
    private String[] columnNames = {"Produktkod", "Namn", "Antal", "Pris" };

    private JButton btnRemove;
    private JButton btnCreateOrder;
    private JLabel lblTotalPrice;

    private MainPanel mainPanel;

    public ShoppingListPanel(MainPanel mainpanel){
        this.mainPanel = mainpanel;
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Shopplinglista"));
        createElements();
        addElements();
    }

    private void createElements(){
        panelSouth = new JPanel();
        shoppingListData = new DefaultTableModel();
        shoppingListTable = new JTable();
        shoppingListTable.setFillsViewportHeight(true);
        scrollPane = new JScrollPane(shoppingListTable);
        shoppingListData.setColumnIdentifiers(columnNames);
        shoppingListTable.setModel(shoppingListData);
        btnCreateOrder = new JButton("Beställ");
        btnRemove = new JButton("Ta bort");
        lblTotalPrice = new JLabel("Totalpris: 0");

        btnCreateOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.makeOrder();
                DefaultTableModel newShoppingListData = new DefaultTableModel();
                setNewOrderData(newShoppingListData);
                updateTotalPrice(0);
            }
        });
    };

    private void addElements(){
        panelSouth.add(btnRemove);
        panelSouth.add(btnCreateOrder);
        panelSouth.add(lblTotalPrice);

        add(scrollPane, BorderLayout.CENTER);
        add(panelSouth, BorderLayout.SOUTH);
    }

    public void setNewOrderData(DefaultTableModel newOrderData){
        shoppingListData = newOrderData;
        shoppingListTable.setModel(shoppingListData);
        shoppingListData.setColumnIdentifiers(columnNames);
    }

    public void updateTotalPrice(double totalPrice)
    {
        lblTotalPrice.setText("Totalpris: " + totalPrice);
    }

    public void addItemToShoppingList(String[] item){
        //TODO
    }

}
