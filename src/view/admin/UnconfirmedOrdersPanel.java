package view.admin;

import view.MainPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnconfirmedOrdersPanel extends JPanel{

    private ConfirmOrderPanel pnlConfirmOrder;
    private DefaultTableModel ordersData;
    private JTable ordersTable;
    private JScrollPane scrollPane;
    private String[] columnNames = {"Ordernummer", "Kund", "Status" };
    private MainPanel mainPanel;
    private MostSoldProductsPanel pnlMostSoldProducts;

    public UnconfirmedOrdersPanel (MainPanel mainPanel) {

        this.mainPanel = mainPanel;
        setPreferredSize(new Dimension(400, 300));
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Obekräftade ordrar"));
        createElements();
        addElements();
    }

    private void createElements(){
        pnlConfirmOrder = new ConfirmOrderPanel();
        pnlMostSoldProducts = new MostSoldProductsPanel(mainPanel);

        ordersData = new DefaultTableModel();
        ordersTable = new JTable();
        ordersTable.setFillsViewportHeight(true);
        ordersTable.setSize(new Dimension(100, 500));
        scrollPane = new JScrollPane(ordersTable);
        ordersData.setColumnIdentifiers(columnNames);
        ordersTable.setModel(ordersData);

    }

    private void addElements(){
        add(scrollPane, BorderLayout.CENTER);
        add(pnlConfirmOrder, BorderLayout.SOUTH);
        add(pnlMostSoldProducts, BorderLayout.EAST);
        addItemToOrderTable(); // TODO, detta bör nog flyttas, se kommentar nedan
        addItemsToMostSoldProductPanel();
    }

    public ConfirmOrderPanel getPnlConfirmOrder() {
        return pnlConfirmOrder;
    }

    // TODO gör snyggare MVC, använd metoden ovan istället
    public void addItemToOrderTable(){
        DefaultTableModel item = mainPanel.getUnconfirmedOrders();
        ordersTable.setModel(item);
    }

    public void addItemsToMostSoldProductPanel()
    {
        DefaultTableModel item = mainPanel.getMostSoldProducts();
        pnlMostSoldProducts.setMostSoldData(item);
    }

    private class ConfirmOrderPanel extends JPanel
    {
        private JPanel pnlButtons;
        private JPanel pnlInput;
        private JLabel lblOrder;
        private JTextField txtOrder;
        private JButton btnConfirmOrder;

        public ConfirmOrderPanel() {
            setLayout(new BorderLayout());
            setBorder(BorderFactory.createTitledBorder("Hantera Order"));
            createElements();
            addElements();
        }

        public void createElements() {

            pnlButtons = new JPanel();
            pnlInput = new JPanel();
            lblOrder = new JLabel("Ordernummer");

            txtOrder = new JTextField();
            txtOrder.setPreferredSize(new Dimension(100, 20));

            btnConfirmOrder = new JButton("Bekräfta order");
            btnConfirmOrder.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mainPanel.confirmOrder(Integer.parseInt(txtOrder.getText()));
                    txtOrder.setText("");
                    addItemToOrderTable();
                }
            });

        }

        public void addElements() {
            pnlInput.add(lblOrder);
            pnlInput.add(txtOrder);
            pnlButtons.add(btnConfirmOrder);

            add(pnlInput, BorderLayout.WEST);
            add(pnlButtons, BorderLayout.CENTER);
        }

    }
}
