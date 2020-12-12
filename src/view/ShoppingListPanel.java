package view;
import control.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ShoppingListPanel extends JPanel {

    private JPanel panelSouth;
    private DefaultTableModel shoppingListData;
    private JTable shoppingListTable;
    private JScrollPane scrollPane;
    private String[] columnNames = {"Produktkod", "Namn", "Antal", "Pris" };

    private JButton btnRemove;
    private JButton btnCreateOrder;

    public ShoppingListPanel(){
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Shopplinglista"));
        createElements();
        addElements();
    }

    public void createElements(){
        panelSouth = new JPanel();
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
        panelSouth.add(btnRemove);
        panelSouth.add(btnCreateOrder);

        add(scrollPane, BorderLayout.CENTER);
        add(panelSouth, BorderLayout.SOUTH);
    }

}
