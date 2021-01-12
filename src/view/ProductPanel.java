package view;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ProductPanel extends JPanel implements ListSelectionListener {

    private SearchProductPanel panelSearchProducts;

    private MainPanel mainPanel;

    private DefaultTableModel productData;
    private JTable productsTable;
    private JScrollPane scrollPane;
    private String[] columnNames = {"Produktkod", "Namn", "Baspris", "Leverantör", "Antal i lager", "Pris"};

    public ProductPanel(MainPanel mainPanel, DefaultTableModel productData) {
        this.mainPanel = mainPanel;
        this.productData = productData;

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(500, 500));
        createElements();
        addElements();
    }

    private void createElements() {
        panelSearchProducts = new SearchProductPanel(mainPanel);

//        productData = new DefaultTableModel();
        productsTable = new JTable();
        productsTable.setFillsViewportHeight(true);
        scrollPane = new JScrollPane(productsTable);
        productData.setColumnIdentifiers(columnNames);
        productsTable.setModel(productData);

    }

    private void addElements() {
        productsTable.getSelectionModel().addListSelectionListener(this);
        add(panelSearchProducts, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

    }

    public void presentTableProducts(String[][] productsDataTable) {
        //TODO fixa så den faktiskt presenterar data, kanske ändra formatet om det finns nått lättare sätt att skicka datan än som en matris.

    }

    public SearchProductPanel getSearchProductPanel() {
        return panelSearchProducts;
    }

    public void setProductData(DefaultTableModel updatedProductData) {
        productData = updatedProductData;
        //productData.setColumnIdentifiers(columnNames);
        productsTable.setModel(productData);
        productData.setColumnIdentifiers(columnNames);
    }

    public int getSelectedProduct() {
        System.out.println((String) productsTable.getValueAt(productsTable.getSelectedRow(), 0));
        return Integer.parseInt((String) productsTable.getValueAt(productsTable.getSelectedRow(), 0));

//        return selectedProduct;
    }


    // TODO: i mainpanel.getSelectedProduct så anropas adminpanel, det ger fel. Adminpanel är null om customer
    // loggats in.
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {

            mainPanel.getSelectedProduct(
                    (String) productsTable.getValueAt(productsTable.getSelectedRow(), 0),
                    (String) productsTable.getValueAt(productsTable.getSelectedRow(), 1),
                    (String) productsTable.getValueAt(productsTable.getSelectedRow(), 4)
            );
        }
    }


}
