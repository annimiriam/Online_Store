package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ProductPanel extends JPanel {

    private SearchProductPanel panelSearchProducts;
    private JPanel panelSouth;

    private DefaultTableModel productData;
    private JTable productsTable;
    private JScrollPane scrollPane;
    private String[] columnNames = {"Produktkod", "Namn", "Baspris", "Leverantör", "Antal i lager"};

    public ProductPanel(JPanel panelSouth) {
        this.panelSouth = panelSouth;
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
        add(panelSouth, BorderLayout.SOUTH);
    }

    public SearchProductPanel getSearchProductPanel() {
        return panelSearchProducts;
    }

    public JPanel getPanelSouth() {
        return panelSouth;
    }


}
