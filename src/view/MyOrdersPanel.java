package view;
import control.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class MyOrdersPanel extends JPanel {
    private DefaultTableModel myOrdersData;
    private JTable myOrdersTable;
    private JScrollPane scrollPane;
    private String[] columnNames = {"Ordernr", "Datum", "Pris" };


    public MyOrdersPanel(){
        setBorder(new EmptyBorder(10,10,10,10));
        createElements();
        addElements();
    }

    public void createElements(){
        myOrdersData = new DefaultTableModel();
        myOrdersTable = new JTable();
        myOrdersTable.setFillsViewportHeight(true);
        scrollPane = new JScrollPane(myOrdersTable);
        myOrdersData.setColumnIdentifiers(columnNames);
        myOrdersTable.setModel(myOrdersData);

    };

    public void addElements(){
        add(scrollPane);
    }

}
