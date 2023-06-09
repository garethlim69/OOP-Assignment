package Public;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import javax.swing.*;

import Administrator.A_HomePage;

public class LoginPage implements ActionListener {
    // Declare of all components needed to design the frame
    JFrame frame = new JFrame();
    JTextField usernameField = new JTextField();
    JTextField passwordField = new JTextField();
    JButton loginButton;
    JButton signupButton;
    JLabel noAccountText;
    JLabel messageLabel = new JLabel();
    JPanel messagePanel = new JPanel();
    ImageIcon background;
    ImageIcon appIcon;
    JLabel iconLabel = new JLabel();
    JLabel slogan;
    ImageIcon sloganIcon;
    JLabel sloganLabel = new JLabel();

    /*
     * ---HashMap is used to store username and password
     * ---Both username and password are String type
     */
    HashMap<String, String> userInfo = new HashMap<String, String>();

    // CONSTRUCTOR (Use to load the login page)
    // The HashMap is passed into the LoginPage constructor as an argument
    public LoginPage(HashMap<String, String> thisUserInfo) {
        userInfo = thisUserInfo;

        // Background image of the frame
        background = new ImageIcon("Image/forest4.jpg");
        JLabel backgroundPanel = new JLabel(background);

        // Icon of the Page
        appIcon = new ImageIcon("Image/appLogo.png");
        iconLabel.setBounds(230, 100, 160, 160);
        Image image = appIcon.getImage().getScaledInstance(iconLabel.getWidth(), iconLabel.getHeight(),
                Image.SCALE_SMOOTH);
        appIcon = new ImageIcon(image);
        iconLabel.setIcon(appIcon);

        // slogan
        sloganIcon = new ImageIcon("Image/appSlogan.png");
        sloganLabel.setBounds(150, 540, 300, 280);
        Image image1 = sloganIcon.getImage().getScaledInstance(sloganLabel.getWidth(), sloganLabel.getHeight(),
                Image.SCALE_SMOOTH);
        sloganIcon = new ImageIcon(image1);
        sloganLabel.setIcon(sloganIcon);

        /*
         * --- Message being displayed to user when:
         * a. username does not exist in the HashMap
         * b. the password is incorrect
         */
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        messageLabel.setFont(new Font("Helvetica", Font.BOLD, 30));
        messageLabel.setForeground(Color.RED);

        // This panel is used to hold the messageLabel
        messagePanel.add(messageLabel);
        messagePanel.setBounds(40, 720, 500, 50);
        messagePanel.setOpaque(false);

        /*
         * --- All these components below will be placed in the panel
         */

        usernameField.setBounds(100, 310, 400, 60);
        usernameField.setFont(new Font("Arial", Font.PLAIN, 20));
        usernameField.setText("Username");
        usernameField.setForeground(Color.WHITE);
        usernameField.setBackground(new Color(29, 39, 42));

        passwordField.setBounds(100, 380, 400, 60);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 20));
        passwordField.setText("Password");
        passwordField.setForeground(Color.WHITE);
        passwordField.setBackground(new Color(29, 39, 42));

        // Login button to direct user to respective home page
        loginButton = new JButton("Login");
        loginButton.setFocusable(false);
        loginButton.setBounds(170, 480, 250, 40);
        loginButton.setBackground(new Color(63, 57, 56));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Canva Sans", Font.BOLD, 20));
        loginButton.addActionListener(this);

        // A user without account will click on this Sign Up button
        noAccountText = new JLabel("Don't have an account?");
        noAccountText.setHorizontalAlignment(JLabel.CENTER);
        noAccountText.setBounds(50, 550, 400, 30);
        noAccountText.setFont(new Font("Canva Sans", Font.PLAIN, 20));
        noAccountText.setForeground(Color.WHITE);

        signupButton = new JButton("Sign up");
        signupButton.setFocusable(false);
        signupButton.setBounds(330, 550, 150, 30);
        signupButton.setOpaque(false);
        signupButton.setContentAreaFilled(false);
        signupButton.setBorderPainted(false);
        signupButton.setForeground(Color.WHITE);
        signupButton.setFont(new Font("Canva Sans", Font.BOLD, 20));
        signupButton.addActionListener(this);

        /*
         * // Slogan
         * slogan = new JLabel("tagline/slogan");
         * slogan.setBounds(220, 680, 400, 50);
         * slogan.setFont(new Font("Arial",Font.BOLD,20));
         * slogan.setForeground(Color.WHITE);
         */

        // Once the panel is set up, the panel will then be added to the backgroundPanel
        // backgroundPanel.add(slogan);
        backgroundPanel.add(iconLabel);
        backgroundPanel.add(noAccountText);
        backgroundPanel.add(signupButton);
        backgroundPanel.add(usernameField);
        backgroundPanel.add(passwordField);
        backgroundPanel.add(loginButton);
        // backgroundPanel.add(appName);
        backgroundPanel.add(sloganLabel);
        backgroundPanel.add(messagePanel);

        // Set up of frame
        frame.add(backgroundPanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 800);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    // List of event being activated when each button is clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        // If the user has no account, they will click the signupButton and go to
        // register page
        if (e.getSource() == signupButton) {
            new RegisterPage();
            frame.dispose();
        }

        // After login successfully, the user will be directed to their respective home
        // page
        // Either Public User Home Page or Admin Home Page
        if (e.getSource() == loginButton) {
            String username = usernameField.getText();
            String password = passwordField.getText();

            /*
             * -- Administrator info is being set in advance:
             * username = admin, password = 1111
             * -- If the user is an adminitrator, they will be direct to admin home page
             */
            if (username.equals("admin") && password.equals("1111")) {
                new A_HomePage();
                frame.dispose();
            }

            /*
             * -- For public user
             */
            else {
                // If the username of the user is available in HashMap
                if (userInfo.containsKey(username)) {
                    // Check if the password is correspond to the username in HashMap
                    if (userInfo.get(username).equals(password)) {
                        new HomePage(username);
                        frame.dispose();
                    } else {
                        messageLabel.setText("Wrong password");
                    }
                }

                else {
                    messageLabel.setText("Username does not exist");
                }
            }

        }
    }

}