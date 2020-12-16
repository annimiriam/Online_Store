package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainPanel extends JPanel {

    private LoginPanel loginPanel;
    private RegisterPanel registerPanel;

    private AdminPanel adminPanel;
    private CustomerPanel customerPanel;

    public MainPanel(LoginPanel loginPanel) {
        this.loginPanel = loginPanel;
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new BorderLayout());
        add(loginPanel, BorderLayout.NORTH);
    }

    // Get-metoder för textinput från LoginPanelen

    public String getUsernameFromLoginPanel(){
        return loginPanel.getTxtUsername();
    }

    public String getPasswordFromLoginPanel(){
        return loginPanel.getTxtPassword();
    }

    //Get-metoder för textinput från RegisterPanelen

    public String getTxtFirstNameFromRegisterPanel(){
        return registerPanel.getTxtFirstName();
    }

    public String getTxtLastNameFromRegisterPanel(){
        return registerPanel.getTxtLastName();
    }

    public String getTxtEmailFromRegisterPanel(){
        return registerPanel.getTxtEmail();
    }

    public String getTxtPasswordFromRegisterPanel(){
        return registerPanel.getTxtPassword();
    }

    public String getTxtAddressFromRegisterPanel(){
        return registerPanel.getTxtAddress();
    }

    public String getTxtCityFromRegisterPanel(){
        return registerPanel.getTxtCity();
    }

    public String getTxtCountryFromRegisterPanel(){
        return registerPanel.getTxtCountry();
    }

    public String getTxtPhonenumberFromRegisterPanel(){
        return registerPanel.getTxtPhonenumber();
    }

    public void test(){
        adminPanel.getPanelSuppliers().getPnlAddSupplier().getTxtName();
        adminPanel.getPanelDiscount().getPnlAddDiscount().getTxtName();
        adminPanel.getPanelProducts().getSearchProductPanel().getTxtProductName();



    }



}
