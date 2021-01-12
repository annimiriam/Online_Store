package view.admin;

import view.MainPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MostSoldProductsPanel extends JPanel {
    private DefaultTableModel mostSoldData;
    private JTable mostSoldTable;
    private JScrollPane scrollPane;
    private String[] columnNames = {"År", "Månad", "Produkt-id", "Antal sålda"};
    private MainPanel mainPanel;

    public MostSoldProductsPanel(MainPanel mainpanel)
    {
        this.mainPanel = mainpanel;

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Mest sålda vara"));
        createElements();
        addElements();
    }

    public void createElements() {

        mostSoldTable = new JTable();
        mostSoldTable.setFillsViewportHeight(true);
        scrollPane = new JScrollPane(mostSoldTable);
    }

    public void addElements() {
        add(scrollPane, BorderLayout.CENTER);
    }

    public void setMostSoldData(DefaultTableModel updatedMostSOldData) {
        mostSoldData = updatedMostSOldData;
        mostSoldTable.setModel(mostSoldData);
        mostSoldData.setColumnIdentifiers(columnNames);    }
}
