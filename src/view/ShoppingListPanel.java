package view;
import control.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ShoppingListPanel extends JPanel {
    private DefaultTableModel shoppingListData;
    private JTable shoppingListTable;
    private JScrollPane scrollPane;
    private String[] columnNames = {"Produktkod", "Namn", "Antal", "Pris" };

    private JButton btnRemove;
    private JButton btnCreateOrder;

    public ShoppingListPanel(){
        setPreferredSize(new Dimension(200,500));
        setBorder(new EmptyBorder(10,10,10,10));
        createElements();
        addElements();
    }

    public void createElements(){
        shoppingListData = new DefaultTableModel();
        shoppingListTable = new JTable();
        shoppingListTable.setFillsViewportHeight(true);
        scrollPane = new JScrollPane(shoppingListTable);
        shoppingListData.setColumnIdentifiers(columnNames);
        shoppingListTable.setModel(shoppingListData);
        btnCreateOrder = new JButton("Beställ");
        btnRemove = new JButton("Ta bort");
    };

    public void addElements(){

        add(scrollPane);
        add(btnRemove);
        add(btnCreateOrder);
    }

}
