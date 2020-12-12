package view;
import control.*;
import javax.swing.*;
import java.awt.*;

public class SearchProductPanel extends JPanel {

    private JPanel gridPanel;
    private JLabel lblProductCode;
    private JLabel lblProductName;
    private JLabel lblSupplier;
    private JLabel lblPrice;

    private JTextField txtProductCode;
    private JTextField txtProductName;
    private JTextField txtSupplier;
    private JTextField txtPrice;

    private JButton btnSearch;

    public SearchProductPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createTitledBorder("Sök Produkt"));
        createElements();
        addElements();
    }

    public void createElements() {
        gridPanel = new JPanel(new GridLayout(2, 2));
        lblProductCode = new JLabel("Produktkod");
        lblProductName = new JLabel("Produktnamn");
        lblSupplier = new JLabel("Leverantör");
        lblPrice = new JLabel("Pris");

        txtProductCode = new JTextField();
        txtProductName = new JTextField();
        txtSupplier = new JTextField();
        txtPrice = new JTextField();

        btnSearch = new JButton("Sök");
    }

    public void addElements() {
        gridPanel.add(lblProductCode);
        gridPanel.add(txtProductCode);
        gridPanel.add(lblSupplier);
        gridPanel.add(txtSupplier);
        gridPanel.add(lblProductName);
        gridPanel.add(txtProductName);
        gridPanel.add(lblPrice);
        gridPanel.add(txtPrice);

        add(gridPanel, this);
        add(btnSearch, this);
    }

}
