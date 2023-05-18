package Public;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class MessageSentPage implements ActionListener
{
    // Declare of all componenets needed for frame design
    JFrame frame = new JFrame();
    JLabel title;
    JLabel thankYouText;
    JButton returnButton;
    JButton homeButton;
    JButton profileButton;
    JButton notifyButton;
    JButton settingButton;
    ImageIcon icon;
    ImageIcon homeIcon;
    ImageIcon profileIcon;
    ImageIcon settingIcon;
    ImageIcon notifyIcon;
    JLabel iconLabel = new JLabel();
    JLabel homeLabel;
    JLabel profileLabel;
    JLabel notifyLabel;
    JLabel settingLabel;
    JPanel bottomRibbon;

    String username;

    // Constrcutor 
    public MessageSentPage(String currentUsername)
    {
        username = currentUsername;

        // Icon of the Page
        icon = new ImageIcon("Image/sent.png");
        iconLabel.setBounds(160, 140, 250, 250);
        Image image = icon.getImage().getScaledInstance(iconLabel.getWidth(),iconLabel.getHeight(), Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);
        iconLabel.setIcon(icon);

        // Account created title
        title = new JLabel("Message is sent!");
        title.setBounds(120,50,600,60);
        title.setFont(new Font("Canva Sans",Font.BOLD,40));
        title.setForeground(Color.BLACK);

        // Thanky you Text
        thankYouText = new JLabel("Thank you for your suggestion");
        thankYouText.setHorizontalAlignment(JLabel.CENTER);
        thankYouText.setBounds(90, 450, 400, 30);
        thankYouText.setFont(new Font("Canva Sans",Font.PLAIN,25));
        thankYouText.setForeground(Color.BLACK);

        // Return button
        returnButton = new JButton("Return");
        returnButton.setFocusable(false);
        returnButton.setBounds(140, 530, 300, 60);
        returnButton.setBackground(new Color(166,197,134));
        returnButton.setForeground(Color.BLACK);
        returnButton.setFont(new Font("Canva Sans",Font.BOLD,20));
        returnButton.addActionListener(this);

        // All Buttons on the bottom ribbon
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


        // Set up of the frame
        frame.add(iconLabel);
        frame.add(title);
        frame.add(thankYouText);
        frame.add(returnButton);
        frame.add(bottomRibbon);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(255,251,230));
        frame.setSize(600,800);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }


    // List of event activated when the button is clicked
    @Override
    public void actionPerformed(ActionEvent e) 
    {

        // After showing to the user that the message is sent successfully, allow the user to return to the Suggestion Box Page
        if(e.getSource()== returnButton)
        {
            new SuggestionBox(username);
            frame.dispose();
        }

        if(e.getSource() == homeButton)
        {
            new HomePage(username);
            frame.dispose();
        }

        if(e.getSource() == profileButton)
        {
            new Profile(username);
            frame.dispose();
        }
    }
}
