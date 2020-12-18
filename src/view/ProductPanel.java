package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ProductPanel extends JPanel {

    private SearchProductPanel panelSearchProducts;


    private MainPanel mainPanel;

    private DefaultTableModel productData;
    private JTable productsTable;
    private JScrollPane scrollPane;
    private String[] columnNames = {"Produktkod", "Namn", "Baspris", "Leverantör", "Antal i lager"};

    public ProductPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(500, 500));
        createElements();
        addElements();
    }

    public void createElements() {
        panelSearchProducts = new SearchProductPanel();

        productData = new DefaultTableModel();
        productsTable = new JTable();
        productsTable.setFillsViewportHeight(true);
        scrollPane = new JScrollPane(productsTable);
        productData.setColumnIdentifiers(columnNames);
        productsTable.setModel(productData);

    }

    public void addElements() {
        add(panelSearchProducts, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

    }

    public SearchProductPanel getSearchProductPanel() {
        return panelSearchProducts;
    }




}
