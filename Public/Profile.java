package Public;

import UserData.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Profile implements ActionListener
{
    // Declare all components needed to build and design the frame
    JFrame frame = new JFrame();
    ImageIcon iconImage;
    ImageIcon homeIcon;
    JLabel iconLabel = new JLabel();
    JPanel infoPanel;
    JLabel title;
    JButton homeButton;
    JButton profileButton;
    JButton notifyButton;
    JButton settingButton;
    JButton editButton;
    JLabel usernameLabel;
    JLabel IDLabel;
    JLabel emailLabel;
    JPanel topRibbon;
    JLabel name;
    JPanel bottomRibbon;
    ImageIcon profileIcon;
    ImageIcon notifyIcon;
    ImageIcon settingIcon;
    ImageIcon birdIcon;
    JLabel birdLabel = new JLabel();

    // To display current user information
    JLabel username = new JLabel();
    JLabel ID = new JLabel();
    JLabel email = new JLabel();

    // Initialize current user information
    String thisUsername = "";
    int currentPoint = 0;
    String newName = "DisplayName";
    String userEmail = "ldjs@gmail.com";


    // Constructor
    public Profile(String currentUsername)
    {

        // The username of the current user will be loaded into Profile Page
        thisUsername = currentUsername;

        // Top ribbon
        topRibbon = new JPanel();
        topRibbon.setBounds(0, 1, 600, 200);
        topRibbon.setBackground(new Color(40,101,132));

        // Icon of the profile page
        iconImage = new ImageIcon("Image/icon4.png");
        iconLabel.setBounds(200,100,170,170);
        Image image_i = iconImage.getImage().getScaledInstance(iconLabel.getWidth(),iconLabel.getHeight(), Image.SCALE_SMOOTH);
        iconImage = new ImageIcon(image_i);
        iconLabel.setIcon(iconImage);

        // Bird Icon for the top ribbon
        birdIcon = new ImageIcon("Image/bird.png");
        birdLabel.setBounds(50,0,550,250);
        Image imageBird = birdIcon.getImage().getScaledInstance(birdLabel.getWidth(),birdLabel.getHeight(), Image.SCALE_SMOOTH);
        birdIcon = new ImageIcon(imageBird);
        birdLabel.setIcon(birdIcon);

        // Name display
        name = new JLabel();
        name.setText(newName);
        name.setBounds(170, 250, 300, 100);
        name.setFont(new Font("Canva Sans",Font.BOLD,35));
        name.setForeground(new Color(57,55,55));

        // Title of Profile Page
        title = new JLabel("My Profile");
        title.setBounds(170, 20, 400, 100);
        title.setFont(new Font("Canva Sans",Font.BOLD,45));
        title.setForeground(Color.BLACK);

        // Buttons on bottom panel
        homeButton = new JButton();
        homeButton.setFocusable(false);
        homeButton.setBounds(10, 10, 50, 50);
        homeButton.setOpaque(false);
        homeButton.setContentAreaFilled(false);
        homeButton.setBorderPainted(false);
        homeButton.addActionListener(this);
        homeIcon = new ImageIcon("Image/homeIcon.png");
        Image imageHome = homeIcon.getImage().getScaledInstance(homeButton.getWidth(),homeButton.getHeight(), Image.SCALE_SMOOTH);
        homeIcon = new ImageIcon(imageHome);
        homeButton.setIcon(homeIcon);

        profileButton = new JButton();
        profileButton.setFocusable(false);
        profileButton.setBounds(10, 10, 50, 50);
        profileButton.setOpaque(false);
        profileButton.setContentAreaFilled(false);
        profileButton.setBorderPainted(false);
        profileIcon = new ImageIcon("Image/profileIcon.png");
        Image imageProfile = profileIcon.getImage().getScaledInstance(profileButton.getWidth(),profileButton.getHeight(), Image.SCALE_SMOOTH);
        profileIcon = new ImageIcon(imageProfile);
        profileButton.setIcon(profileIcon);

        notifyButton = new JButton();
        notifyButton.setFocusable(false);
        notifyButton.setBounds(10, 10, 50, 50);
        notifyButton.setOpaque(false);
        notifyButton.setContentAreaFilled(false);
        notifyButton.setBorderPainted(false);
        notifyIcon = new ImageIcon("Image/notifyIcon.png");
        Image imageNotify = notifyIcon.getImage().getScaledInstance(notifyButton.getWidth(),notifyButton.getHeight(), Image.SCALE_SMOOTH);
        notifyIcon = new ImageIcon(imageNotify);
        notifyButton.setIcon(notifyIcon);

        settingButton = new JButton();
        settingButton.setFocusable(false);
        settingButton.setBounds(10, 10, 50, 50);
        settingButton.setOpaque(false);
        settingButton.setContentAreaFilled(false);
        settingButton.setBorderPainted(false);
        settingButton.addActionListener(this);
        settingIcon = new ImageIcon("Image/settingIcon.png");
        Image imageSetting = settingIcon.getImage().getScaledInstance(settingButton.getWidth(),settingButton.getHeight(), Image.SCALE_SMOOTH);
        settingIcon = new ImageIcon(imageSetting);
        settingButton.setIcon(settingIcon);

        // Bottom ribbon
        bottomRibbon = new JPanel();
        bottomRibbon.setLayout(new GridLayout(1, 4, 10, 0));
        bottomRibbon.setBounds(0, 700, 600, 80);
        bottomRibbon.setBackground(new Color(102,66,40));
        bottomRibbon.add(homeButton);
        bottomRibbon.add(profileButton);
        bottomRibbon.add(notifyButton);
        bottomRibbon.add(settingButton);


        //All Components to be arranged in User Info Panel 
        usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(Color.BLACK);
        usernameLabel.setFont(new Font("Canve Sans",Font.BOLD,25));
        usernameLabel.setBounds(20, 20, 300, 40);

        IDLabel= new JLabel("User ID:");
        IDLabel.setForeground(Color.BLACK);
        IDLabel.setFont(new Font("Canve Sans",Font.BOLD,25));
        IDLabel.setBounds(20, 75, 300, 40);

        emailLabel = new JLabel("Email:");
        emailLabel.setForeground(Color.BLACK);
        emailLabel.setFont(new Font("Canve Sans",Font.BOLD,25));
        emailLabel.setBounds(20, 125, 300, 40);


        // Display of current user data
        username.setText(thisUsername);
        username.setForeground(Color.BLACK);
        username.setFont(new Font("Canve Sans",Font.PLAIN,25));
        username.setBounds(180, 20, 300, 40);

        UserID userData = new UserID();
        ID.setText(userData.getID());
        ID.setForeground(Color.BLACK);
        ID.setFont(new Font("Canve Sans",Font.PLAIN,25));
        ID.setBounds(180, 75, 300, 40);

        email.setText(userEmail);
        email.setForeground(Color.BLACK);
        email.setFont(new Font("Canve Sans",Font.PLAIN,25));
        email.setBounds(180, 125, 300, 40);


        // User info panel
        // This panel will hold the all the components related to the current user
        infoPanel = new JPanel();
        infoPanel.setBounds(60,340,470,200);
        infoPanel.setLayout(null);
        infoPanel.setBackground(new Color(223,215,184));
        infoPanel.add(usernameLabel);
        infoPanel.add(IDLabel);
        infoPanel.add(emailLabel);
        infoPanel.add(username);
        infoPanel.add(ID);
        infoPanel.add(email);


        // Edit profile button
        editButton = new JButton("Edit Profile");
		editButton.setFocusable(false);
        editButton.setBounds(150, 570, 250, 55);
        editButton.setBackground(new Color(57,55,55));
        editButton.setForeground(Color.WHITE);
        editButton.setFont(new Font("Canva Sans",Font.BOLD,15));
		editButton.addActionListener(this);


        // Set up of frame
        frame.add(title);
        frame.add(iconLabel);
        frame.add(birdLabel);
        frame.add(topRibbon);
        frame.add(name);
        frame.add(infoPanel);
        frame.add(editButton);
        frame.add(bottomRibbon);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(255,251,230));
        frame.setSize(600,800);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }


    // List of event that activated when each button is clicked
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        // When user click on this button, redirect back to home page
        if(e.getSource() == homeButton)
        {
            new HomePage(thisUsername);
            frame.dispose();
        }


        // The user can change the name and email by inserting the input into the JOptionPanel
        if(e.getSource() == editButton)
        {
            newName = JOptionPane.showInputDialog("Type in new name");

            userEmail = JOptionPane.showInputDialog("Type in new email");


            name.setText(newName);
            email.setText(userEmail);

        }
    }

}
