package Public;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.*;


public class EducationPage implements ActionListener 
{
    // Declare all components needed to design frame
    JFrame frame = new JFrame();
    JPanel panel;
    JButton homeButton;
    JButton profileButton;
    JButton notifyButton;
    JButton settingButton;
    JButton articleButton;
    JButton videoButton;
    JButton quizButton;
    JButton readMoreButton;
    ImageIcon homeIcon;
    ImageIcon profileIcon;
    ImageIcon notifyIcon;
    ImageIcon settingIcon;
    ImageIcon articleIcon;
    ImageIcon videoIcon;
    ImageIcon bookIcon;
    ImageIcon quizIcon;
    JLabel imageLabel1 = new JLabel();
    JLabel imageLabel2 = new JLabel();
    JLabel imageLabel3 = new JLabel();
    JLabel imageLabel4 = new JLabel();
    JPanel topRibbon;
    JPanel bottomRibbon;
    ImageIcon bgImage;
    JLabel bgLabel = new JLabel();

    String thisUser = "";

    // Constructor 
    public EducationPage(String currentUser)
    {
        thisUser = currentUser;

        // Top ribbon
        bgImage = new ImageIcon("Image/EduTR.png");
        bgLabel.setBounds(0, 0, 600, 170);
        Image image = bgImage.getImage().getScaledInstance(bgLabel.getWidth(),bgLabel.getHeight(), Image.SCALE_SMOOTH);
        bgImage = new ImageIcon(image);
        bgLabel.setIcon(bgImage);

        // Icons for the education program activities
        articleIcon = new ImageIcon("Image/articleW.png");
        imageLabel1.setBounds(200,100,170,170);
        Image image1 = articleIcon.getImage().getScaledInstance(imageLabel1.getWidth(),imageLabel1.getHeight(), Image.SCALE_SMOOTH);
        articleIcon = new ImageIcon(image1);
        imageLabel1.setIcon(articleIcon);

        videoIcon = new ImageIcon("Image/videoW.png");
        imageLabel2.setBounds(200,100,170,170);
        Image image2 = videoIcon.getImage().getScaledInstance(imageLabel2.getWidth(),imageLabel2.getHeight(), Image.SCALE_SMOOTH);
        videoIcon = new ImageIcon(image2);
        imageLabel2.setIcon(videoIcon);

        bookIcon = new ImageIcon("Image/bookW.png");
        imageLabel3.setBounds(200,100,170,170);
        Image image3 = bookIcon.getImage().getScaledInstance(imageLabel3.getWidth(),imageLabel3.getHeight(), Image.SCALE_SMOOTH);
        bookIcon = new ImageIcon(image3);
        imageLabel3.setIcon(bookIcon);

        quizIcon = new ImageIcon("Image/quizW.png");
        imageLabel4.setBounds(200,100,170,170);
        Image image4 = quizIcon.getImage().getScaledInstance(imageLabel4.getWidth(),imageLabel4.getHeight(), Image.SCALE_SMOOTH);
        quizIcon = new ImageIcon(image4);
        imageLabel4.setIcon(quizIcon);


        // Panel to hold all the activity images
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(80, 160, 450, 500);
        panel.setBackground(new Color(255,251,230));
        panel.setOpaque(true);
        panel.setLayout(new GridLayout(2,2,10,10));
        panel.add(imageLabel1);
        panel.add(imageLabel2);
        panel.add(imageLabel3);
        panel.add(imageLabel4);

        // All 4 buttons of each activity
        articleButton = new JButton("Read Articles");
		articleButton.setFocusable(false);
        articleButton.setBounds(80, 370, 170, 40);
        articleButton.setBackground(new Color(40,76,104));
        articleButton.setForeground(Color.WHITE);
        articleButton.setFont(new Font("Canva Sans",Font.BOLD,20));
		articleButton.addActionListener(this);

        videoButton = new JButton("Watch Video");
		videoButton.setFocusable(false);
        videoButton.setBounds(310, 370, 170, 40);
        videoButton.setBackground(new Color(40,76,104));
        videoButton.setForeground(Color.WHITE);
        videoButton.setFont(new Font("Canva Sans",Font.BOLD,20));
		videoButton.addActionListener(this);

        readMoreButton = new JButton("Read More");
		readMoreButton.setFocusable(false);
        readMoreButton.setBounds(80, 610, 170, 40);
        readMoreButton.setBackground(new Color(40,76,104));
        readMoreButton.setForeground(Color.WHITE);
        readMoreButton.setFont(new Font("Canva Sans",Font.BOLD,20));
		readMoreButton.addActionListener(this);

        quizButton = new JButton("Quiz");
		quizButton.setFocusable(false);
        quizButton.setBounds(310, 610, 170, 40);
        quizButton.setBackground(new Color(40,76,104));
        quizButton.setForeground(Color.WHITE);
        quizButton.setFont(new Font("Canva Sans",Font.BOLD,20));
		quizButton.addActionListener(this);


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
        frame.add(bottomRibbon);
        frame.add(articleButton);
        frame.add(videoButton);
        frame.add(readMoreButton);
        frame.add(quizButton);
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
        // Redirect to homepage
        if(e.getSource() == homeButton)
        {
            new HomePage(thisUser);
            frame.dispose();
        }

        // Direct to profile page
        if(e.getSource() == profileButton)
        {
            new Profile(thisUser);
            frame.dispose();
        }

        // Direct to Quiz Main Page
        if(e.getSource() == quizButton)
        {
            new QuizMainPage(thisUser);
            frame.dispose();
        }

        // Direct to article page
        if(e.getSource() == articleButton)
        {
            new ArticleZone(thisUser);
            frame.dispose();
        }

        // Direct to video page
        if(e.getSource() == videoButton)
        {
            new VideoZone(thisUser);
            frame.dispose();
        }

        // Direct user to the official website of SDG 13
        if(e.getSource() == readMoreButton)
        {
            try {
                Desktop.getDesktop().browse(new URI("https://sdgs.un.org/goals/goal13"));
            } catch (IOException | URISyntaxException e1) {
                e1.printStackTrace();
            }
        }
    }


}
