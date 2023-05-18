package Public;
import UserData.*;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

import javax.swing.*;

public class RegisterPage implements ActionListener
{
    // Delare of components needed to design the Frame
    JFrame frame = new JFrame();
    JLabel title;
    JTextField usernameField;
    JTextField passwordField;
    JTextField emailField;
    JButton registerButton;
    JButton signinButton;
    JLabel hasAccountText;
    ImageIcon sloganIcon;
    JLabel sloganLabel = new JLabel();
    ImageIcon background;
    JLabel backgroundPanel;

    // HashMap used to store the username and password in String type
    HashMap<String,String> LoginInfo = new HashMap<String,String>();

    /*
     -- Initialize of the username and password
     -- Before sign in, the username and password of a user are NULL/EMPTY
     */
    String username = "";
    String password = "";



    // Constructor (To load the register page)
    public RegisterPage()
    {
        // Background image of the frame
        background = new ImageIcon("Image/forest4.jpg");
        JLabel backgroundPanel = new JLabel(background);

        // Slogan Icon of the Page
        sloganIcon = new ImageIcon("Image/appSloganBlack.png");
        sloganLabel.setBounds(130, -30, 350, 350);
        Image image1 = sloganIcon.getImage().getScaledInstance(sloganLabel.getWidth(),sloganLabel.getHeight(), Image.SCALE_SMOOTH);
        sloganIcon = new ImageIcon(image1);
        sloganLabel.setIcon(sloganIcon);
        

        // Title of the Register Page
        title = new JLabel("CREATE AN ACCOUNT");
        title.setBounds(130,250,600,60);
        title.setFont(new Font("Canva Sans",Font.BOLD,30));
        title.setForeground(new Color(63,57,56));


        // User will write their username and password in these textfields
        emailField = new JTextField();
        emailField.setBounds(100, 330, 400, 50);
        emailField.setFont(new Font("Arial",Font.PLAIN,20));
        emailField.setText("Email");
        emailField.setBackground(new Color(230,223,209));
        
        usernameField = new JTextField();
        usernameField.setBounds(100, 430, 400, 50);
        usernameField.setFont(new Font("Arial",Font.PLAIN,20));
        usernameField.setText("Username");
        usernameField.setBackground(new Color(230,223,209));

        passwordField = new JTextField();
        passwordField.setBounds(100, 490, 400, 50);
        passwordField.setFont(new Font("Arial",Font.PLAIN,20));
        passwordField.setText("Password");
        passwordField.setBackground(new Color(230,223,209));


        // Sign up button
        registerButton = new JButton("Register");
		registerButton.setFocusable(false);
        registerButton.setBounds(200, 590, 200, 40);
        registerButton.setBackground(new Color(28,71,54));
        registerButton.setForeground(Color.WHITE);
        registerButton.setFont(new Font("Canva Sans",Font.BOLD,20));
        registerButton.addActionListener(this);

        // Small text to ask whether the user has an account
        hasAccountText = new JLabel("Has an account?");
        hasAccountText.setHorizontalAlignment(JLabel.CENTER);
        hasAccountText.setBounds(50, 660, 400, 30);
        hasAccountText.setFont(new Font("Canva Sans",Font.PLAIN,25));
        hasAccountText.setForeground(Color.BLACK);
        
       // Sign in button (direct user to login page)
        signinButton = new JButton("Sign in");
		signinButton.setFocusable(false);
        signinButton.setBounds(265, 660, 250, 30);
        signinButton.setOpaque(false);
        signinButton.setContentAreaFilled(false);
        signinButton.setBorderPainted(false);
        signinButton.setForeground(Color.BLACK);
        signinButton.setFont(new Font("Canva Sans",Font.BOLD,25));
        signinButton.addActionListener(this);


        // Add all components to background panel
        backgroundPanel.add(sloganLabel);
        backgroundPanel.add(title);
        backgroundPanel.add(emailField);
        backgroundPanel.add(usernameField);
        backgroundPanel.add(passwordField);
        backgroundPanel.add(registerButton);
        backgroundPanel.add(hasAccountText);
        backgroundPanel.add(signinButton);

        // Set up of the frame
        frame.add(backgroundPanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,800);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }


    // List of event that activated when the button is clicked
    @Override
    public void actionPerformed(ActionEvent e)
    {
        // User clicks on the "Sign in" text, then direct the user to Login Page
        if(e.getSource() == signinButton)
        {
            new LoginPage(LoginInfo);
            frame.dispose();
        }



        /*
         -- user filled in the his username and password in the textfields
         -- user clicks on sign up button
         -- username and password are collected from the textfields
         -- username and password are then stored in HashMap
         -- user is directed to Login Page
         */
        if (e.getSource() == registerButton)
        {
            username = usernameField.getText();
            password = passwordField.getText();

            // username and password are stored in HashMap
            LoginInfo u = new LoginInfo();
            u.putToMap(username,password);
            
            new AccountCreated(u.getLoginInfo());
            frame.dispose();
        }
    }
}
