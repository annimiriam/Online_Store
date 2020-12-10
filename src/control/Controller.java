package control;
import view.*;
import java.awt.*;

public class Controller {

    private MainFrame mainFrame;
    private MainPanel mainPanel;

    public Controller() {
        mainPanel = new MainPanel(this);
        mainFrame = new MainFrame(this, mainPanel);
    }

    public void checkLogin(String user, String password) {
        if (user.equals("admin") && password.equals("admin")) {
            System.out.println("admin inloggad");
            setupAdminPanel();
        } else if (user.equals("kund") && password.equals("kund")) {
            System.out.println("kund inloggad");
            setupCustomerPanel();
        }
    }

    public void setupAdminPanel(){
        mainPanel.add(new SearchPanel(), BorderLayout.NORTH);
        mainPanel.add(new SuppliersPanel(), BorderLayout.CENTER);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    public void setupCustomerPanel(){
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        mainPanel.add(new SearchPanel(), BorderLayout.NORTH);
        mainPanel.add(new ProductPanel(), BorderLayout.CENTER);
        mainPanel.add(new ShoppingListPanel(), BorderLayout.EAST);
        mainPanel.repaint();
        mainPanel.revalidate();

    }

    public void registerCustomer(){
        mainPanel.add(new RegisterPanel(this), BorderLayout.EAST);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

}
