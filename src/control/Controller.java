package control;
import view.*;
import java.awt.*;

public class Controller {

    private MainFrame mainFrame;
    private MainPanel mainPanel;

    public Controller() {
        mainPanel = new MainPanel(this);
        mainFrame = new MainFrame(mainPanel);
    }

    // Kontrollerar angivet användarnamn och lösenord om admin eller kund
    public void checkLogin(String user, String password) {
        if (user.equals("admin") && password.equals("admin")) {
            System.out.println("admin inloggad");
            showAdminPanel();
        } else if (user.equals("kund") && password.equals("kund")) {
            System.out.println("kund inloggad");
            showCustomerPanel();
        }
        mainFrame.setExtendedState(mainFrame.MAXIMIZED_BOTH); // maximerar fönsterstorlek för att ge plats åt paneler
    }

    // Visar registrera-kund-panelen
    public void showRegisterCustomerPanel(){
        mainPanel.add(new RegisterPanel(this), BorderLayout.SOUTH);
        mainPanel.repaint();
        mainPanel.revalidate();
        mainFrame.pack();
    }

    // Ritar upp kundpanelen
    public void showCustomerPanel(){
        mainPanel.removeAll();
        mainPanel.add(new CustomerPanel(), BorderLayout.CENTER);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    // Ritar upp adminpanelen
    public void showAdminPanel(){
        mainPanel.removeAll();
        mainPanel.add(new AdminPanel(), BorderLayout.CENTER);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

}
