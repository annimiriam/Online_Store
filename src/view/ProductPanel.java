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
    private String[] columnNames = {"Produktkod", "Namn", "Baspris", "Leverantör", "Antal i lager" };

    private JButton btnAllProducts;
    private JButton btnSaleProducts;

    public ProductPanel () {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(500,500));
        createElements();
        addElements();
    }

    public void createElements(){
        panelSearchProducts = new SearchProductPanel();
        panelSouth = new JPanel();

        productData = new DefaultTableModel();
        productsTable = new JTable();
        productsTable.setFillsViewportHeight(true);
        scrollPane = new JScrollPane(productsTable);
        productData.setColumnIdentifiers(columnNames);
        productsTable.setModel(productData);

        btnAllProducts = new JButton("Alla produkter");
        btnSaleProducts = new JButton("Reaprodukter");
    }

    public void addElements(){
        panelSouth.add(btnAllProducts);
        panelSouth.add(btnSaleProducts);

        add(panelSearchProducts, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panelSouth, BorderLayout.SOUTH);
    }

    // Metod eller metoder för att skicka meddelande från knapptrycken till controllern. Via MainPanel?

}
