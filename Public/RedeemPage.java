package Public;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RedeemPage implements ActionListener
{
    // Declare all components needed to design frame
    JFrame frame = new JFrame();
    JPanel panel;
    JButton homeButton;
    JButton profileButton;
    JButton notifyButton;
    JButton settingButton;
    JButton secretRButton;
    JButton starbucksButton;
    JButton subwayButton;
    JButton BRButton;
    JButton searchButton;
    ImageIcon homeIcon;
    ImageIcon profileIcon;
    ImageIcon notifyIcon;
    ImageIcon settingIcon;
    ImageIcon secretRIcon;
    ImageIcon starbucksIcon;
    ImageIcon subwayIcon;
    ImageIcon BRIcon;
    ImageIcon leafIcon1;
    ImageIcon leafIcon2;
    JLabel imageLabel1 = new JLabel();
    JLabel imageLabel2 = new JLabel();
    JLabel imageLabel3 = new JLabel();
    JLabel imageLabel4 = new JLabel();
    JLabel secretRLabel;
    JLabel starbucksLabel;
    JLabel subwayLabel;
    JLabel BRLabel;
    JLabel questionimageLabel1 = new JLabel();
    JPanel bottomRibbon;
    JTextField searchBar;
    ImageIcon searchIcon;

    ImageIcon bgImage;
    JLabel bgLabel = new JLabel();
    

    String thisUser = "";

    // Constructor 
    // The username of current user is passed into this constructor
    public RedeemPage(String currentUser)
    {
        thisUser = currentUser;

        // Top ribbon
        bgImage = new ImageIcon("Image/redeemTopRibbon.png");
        bgLabel.setBounds(0, 0, 600, 180);
        Image image = bgImage.getImage().getScaledInstance(bgLabel.getWidth(),bgLabel.getHeight(), Image.SCALE_SMOOTH);
        bgImage = new ImageIcon(image);
        bgLabel.setIcon(bgImage);

        
        // Searching bar
        searchBar = new JTextField("What award you are looking for?");
        searchBar.setBounds(100, 190, 330, 40);
        searchBar.setFont(new Font("Canva Sans",Font.PLAIN,20));

        // Search icon besides the search bar
        searchButton = new JButton();
        searchButton.setFocusable(false);
        searchButton.setBounds(440, 195, 30, 30);
        searchButton.setOpaque(false);
        searchButton.setContentAreaFilled(false);
        searchButton.setBorderPainted(false);
        searchIcon = new ImageIcon("Image/searchIcon.png");
        Image imageSearch = searchIcon.getImage().getScaledInstance(searchButton.getWidth(),searchButton.getHeight(), Image.SCALE_SMOOTH);
        searchIcon = new ImageIcon(imageSearch);
        searchButton.setIcon(searchIcon);
        searchButton.addActionListener(this);


        // Icons for the award (these icons are button)
        secretRButton = new JButton();
        secretRButton.setFocusable(false);
        secretRButton.setBounds(10, 10, 100, 100);
        secretRButton.setBackground(Color.WHITE);
        secretRIcon = new ImageIcon("Image/secretRecipe.png");
        Image imageSR = secretRIcon.getImage().getScaledInstance(secretRButton.getWidth(),secretRButton.getHeight(), Image.SCALE_SMOOTH);
        secretRIcon = new ImageIcon(imageSR);
        secretRButton.setIcon(secretRIcon);
        secretRButton.addActionListener(this);

        starbucksButton = new JButton();
        starbucksButton.setFocusable(false);
        starbucksButton.setBounds(10, 10, 100, 100);
        starbucksButton.setBackground(Color.WHITE);
        starbucksIcon = new ImageIcon("Image/starBucks.png");
        Image imageSB = starbucksIcon.getImage().getScaledInstance(starbucksButton.getWidth(),starbucksButton.getHeight(), Image.SCALE_SMOOTH);
        starbucksIcon = new ImageIcon(imageSB);
        starbucksButton.setIcon(starbucksIcon);
        starbucksButton.addActionListener(this);

        subwayButton = new JButton();
        subwayButton.setFocusable(false);
        subwayButton.setBounds(10, 10, 150, 80);
        subwayButton.setBackground(Color.WHITE);
        subwayIcon = new ImageIcon("Image/subway.png");
        Image imageSW = subwayIcon.getImage().getScaledInstance(subwayButton.getWidth(),subwayButton.getHeight(), Image.SCALE_SMOOTH);
        subwayIcon = new ImageIcon(imageSW);
        subwayButton.setIcon(subwayIcon);
        subwayButton.addActionListener(this);

        BRButton = new JButton();
        BRButton.setFocusable(false);
        BRButton.setBounds(10, 10, 140, 100);
        BRButton.setBackground(Color.WHITE);
        BRIcon = new ImageIcon("Image/BR.png");
        Image imageBR = BRIcon.getImage().getScaledInstance(BRButton.getWidth(),BRButton.getHeight(), Image.SCALE_SMOOTH);
        BRIcon = new ImageIcon(imageBR);
        BRButton.setIcon(BRIcon);
        BRButton.addActionListener(this);


        // Redeem Panel to hold all the award buttons
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(40, 250, 500, 400);
        panel.setBackground(new Color(255,251,230));
        panel.setOpaque(true);
        panel.setLayout(new GridLayout(2,2,20,50));
        panel.add(secretRButton);
        panel.add(starbucksButton);
        panel.add(subwayButton);
        panel.add(BRButton);


        // Label or desc of each gift
        secretRLabel = new JLabel("1 slice of cake");
        secretRLabel.setBounds(90,425,400,30);
        secretRLabel.setFont(new Font("Cnava Sans",Font.BOLD,20));
        secretRLabel.setForeground(Color.BLACK);

        starbucksLabel = new JLabel("RM 10 off");
        starbucksLabel.setBounds(380,425,300,30);
        starbucksLabel.setFont(new Font("Cnava Sans",Font.BOLD,20));
        starbucksLabel.setForeground(Color.BLACK);

        subwayLabel = new JLabel("1 6-inch sub");
        subwayLabel.setBounds(100,650,300,30);
        subwayLabel.setFont(new Font("Cnava Sans",Font.BOLD,20));
        subwayLabel.setForeground(Color.BLACK);

        BRLabel = new JLabel("1 Regular Scoop");
        BRLabel.setBounds(350,650,300,30);
        BRLabel.setFont(new Font("Cnava Sans",Font.BOLD,20));
        BRLabel.setForeground(Color.BLACK);


        // All buttons on bottom ribbon
        homeButton = new JButton();
        homeButton.setFocusable(false);
        homeButton.setBounds(10, 10, 50, 50);
        homeButton.setOpaque(false);
        homeButton.setContentAreaFilled(false);
        homeButton.setBorderPainted(false);
        homeIcon = new ImageIcon("Image/homeIcon.png");
        Image imageHome = homeIcon.getImage().getScaledInstance(homeButton.getWidth(),homeButton.getHeight(), Image.SCALE_SMOOTH);
        homeIcon = new ImageIcon(imageHome);
        homeButton.setIcon(homeIcon);
        homeButton.addActionListener(this);

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
        profileButton.addActionListener(this);

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
        
        // Set up of frame
        frame.add(bgLabel);
        frame.add(searchBar);
        frame.add(searchButton);
        frame.add(bottomRibbon);
        frame.add(secretRLabel);
        frame.add(subwayLabel);
        frame.add(starbucksLabel);
        frame.add(BRLabel);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(255,251,230));
        frame.setSize(600,800);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }


    // List of events activated when the button is clicked
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == homeButton)
        {
            new HomePage(thisUser);
            frame.dispose();
        }
        if(e.getSource() == profileButton)
        {
            new Profile(thisUser);
            frame.dispose();
        }

        /*
         --- User will input the name of the shop
         --- The awards which do not match the requirement will be disabled
         */
        if(e.getSource() == searchButton)
        {
            String content = searchBar.getText();

            switch(content)
            {
                case "Secret Recipe" :
                    starbucksButton.setEnabled(false);
                    subwayButton.setEnabled(false);
                    BRButton.setEnabled(false);
                    break;

                case "Starbucks" :
                    secretRButton.setEnabled(false);
                    subwayButton.setEnabled(false);
                    BRButton.setEnabled(false);
                    break;

                case "Subway" :
                    secretRButton.setEnabled(false);
                    starbucksButton.setEnabled(false);
                    BRButton.setEnabled(false);
                    break;

                case "Baskin Robbins" :
                    secretRButton.setEnabled(false);
                    starbucksButton.setEnabled(false);
                    subwayButton.setEnabled(false);
                    break;
                
                default:
                    BRButton.setEnabled(true);
                    secretRButton.setEnabled(true);
                    starbucksButton.setEnabled(true);
                    subwayButton.setEnabled(true);
                    break;
            }
        }


        // User will receive the award after clicking on the award button
        if(e.getSource() == secretRButton)
        {
            JOptionPane.showMessageDialog(null, "You had received " + secretRLabel.getText() , "Redeem award",JOptionPane.INFORMATION_MESSAGE);
        }

        if(e.getSource() == starbucksButton)
        {
            JOptionPane.showMessageDialog(null, "You had received " + starbucksLabel.getText() , "Redeem award",JOptionPane.INFORMATION_MESSAGE);
        }

        if(e.getSource() == subwayButton)
        {
            JOptionPane.showMessageDialog(null, "You had received " + subwayLabel.getText() , "Redeem award",JOptionPane.INFORMATION_MESSAGE);
        }

        if(e.getSource() == BRButton)
        {
            JOptionPane.showMessageDialog(null, "You had received " + BRLabel.getText() , "Redeem award",JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
}
