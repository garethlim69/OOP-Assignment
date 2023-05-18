package Public;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import javax.swing.*;

public class AccountCreated implements ActionListener
{
    // Declare the components needed to design the frame
    JFrame frame = new JFrame();
    JLabel title;
    JButton nextButton;
    ImageIcon appIcon;
    JLabel appLabel = new JLabel();
    ImageIcon background;
    JPanel backgroundPanel;
    JPanel welcomePanel;
    JLabel welcomeText;
    JLabel instructionText;
    ImageIcon sloganIcon;
    JLabel sloganLabel = new JLabel();

    // HashMap is used to store the username of password of the current user
    HashMap<String,String> userInfo = new HashMap<String,String>();  



    /*
    --- Constructor 
    --- This constructor will accept the HashMap as argument
     */
    public AccountCreated(HashMap<String,String> thisUserInfo)
    {
        userInfo = thisUserInfo;

        // Background image of the frame
        background = new ImageIcon("Image/forest4.jpg");
        JLabel backgroundPanel = new JLabel(background);


        // Icon of the Page
        appIcon = new ImageIcon("Image/appLogo.png");
        appLabel.setBounds(210, 90, 160, 160);
        Image image = appIcon.getImage().getScaledInstance(appLabel.getWidth(),appLabel.getHeight(), Image.SCALE_SMOOTH);
        appIcon = new ImageIcon(image);
        appLabel.setIcon(appIcon);

        // Title of the page
        title = new JLabel("ACCOUNT CREATED!");
        title.setBounds(90,270,600,60);
        title.setFont(new Font("Canva Sans",Font.BOLD,40));
        title.setForeground(new Color(63,57,56));

        // Instruction and welcome text
        welcomeText = new JLabel("Welcome to app name!");
        welcomeText.setFont(new Font("Arial",Font.PLAIN,25));
        welcomeText.setForeground(Color.WHITE);
        

        instructionText = new JLabel("Sign in now to start your journey!");
        instructionText.setFont(new Font("Arial",Font.PLAIN,25));
        instructionText.setForeground(Color.WHITE);
       

        // Add the text into panel
        welcomePanel = new JPanel();
        welcomePanel.setBounds(40, 370, 500, 80);
        welcomePanel.setBackground(new Color(63,57,56,200));
        welcomePanel.add(welcomeText);
        welcomePanel.add(instructionText);


        // Next button
        nextButton = new JButton("Proceed to Login");
        nextButton.setFocusable(false);
        nextButton.setBounds(140, 530, 300, 60);
        nextButton.setBackground(new Color(147,217,194));
        nextButton.setForeground(Color.WHITE);
        nextButton.setFont(new Font("Canva Sans",Font.BOLD,20));
        nextButton.addActionListener(this);


        // Slogan
        sloganIcon = new ImageIcon("Image/appSlogan.png");
        sloganLabel.setBounds(150, 540, 300, 280);
        Image image1 = sloganIcon.getImage().getScaledInstance(sloganLabel.getWidth(),sloganLabel.getHeight(), Image.SCALE_SMOOTH);
        sloganIcon = new ImageIcon(image1);
        sloganLabel.setIcon(sloganIcon);


        //Add all components into background panel
        backgroundPanel.add(appLabel);
        backgroundPanel.add(title);
        backgroundPanel.add(welcomePanel);
        backgroundPanel.add(nextButton);
        backgroundPanel.add(sloganLabel);

        
        // Set up of the frame
        frame.add(backgroundPanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(145,180,150));
        frame.setSize(600,800);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }


    // List of event that activated when button is clicked
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        // When the registration of new account success, direct user to the Login Page
        if(e.getSource()==nextButton)
        {
            new LoginPage(userInfo);
            frame.dispose();
        }
    }
    
}
