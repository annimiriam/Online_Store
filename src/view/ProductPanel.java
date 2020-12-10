package view;
import control.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ProductPanel extends JPanel {

    private DefaultTableModel productData;
    private JTable productsTable;
    private JScrollPane scrollPane;
    private String[] columnNames = {"Produktkod", "Namn", "Baspris", "Leverantör", "Antal i lager" };

    private JButton btnAllProducts;
    private JButton btnSaleProducts;

    public ProductPanel () {
        setPreferredSize(new Dimension(500,500));
        setBorder(new EmptyBorder(10,10,10,10));
        createElements();
        addElements();
    }

    public void createElements(){
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
        add(scrollPane);
        add(btnAllProducts);
        add(btnSaleProducts);
    }


}
