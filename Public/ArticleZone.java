package Public;

import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.swing.*;

import Objects.Article;

public class ArticleZone implements ActionListener
{
    // Declare all components needed to design frame
    JFrame frame = new JFrame();
    JButton homeButton;
    JButton profileButton;
    JButton notifyButton;
    JButton settingButton;
    JButton searchButton;
    ImageIcon homeIcon;
    ImageIcon profileIcon;
    ImageIcon notifyIcon;
    ImageIcon settingIcon;
    JPanel bottomRibbon;
    JPanel articlePanel = new JPanel();
    JButton[] articleButton = new JButton[10];  //
    ImageIcon articleIcon;
    ImageIcon searchIcon;
    JLabel searchIconLabel = new JLabel();
    JLabel articleIconLabel = new JLabel();
    JTextField searchBar;
    ImageIcon bgImage;
    JLabel bgLabel = new JLabel();

    String thisUser = "";
    int search;
    
    ArrayList<Article> articleList = new ArrayList<Article>();
    String fileName = "Text Files/articles.txt";

    // Constructor 
    // The username of current user is passed into this constructor
    public ArticleZone(String currentUser)
    {
        thisUser = currentUser;

        // Top ribbon
        bgImage = new ImageIcon("Image/ArticleTR.png");
        bgLabel.setBounds(0, 0, 600, 190);
        Image image = bgImage.getImage().getScaledInstance(bgLabel.getWidth(),bgLabel.getHeight(), Image.SCALE_SMOOTH);
        bgImage = new ImageIcon(image);
        bgLabel.setIcon(bgImage);

        // Searching bar
        searchBar = new JTextField("Enter the number of topic ");
        searchBar.setBounds(100, 200, 330, 50);
        searchBar.setFont(new Font("Canva Sans",Font.PLAIN,20));

        // Search icon
        searchButton = new JButton();
        searchButton.setFocusable(false);
        searchButton.setBounds(450, 200, 50, 50);
        searchButton.setOpaque(false);
        searchButton.setContentAreaFilled(false);
        searchButton.setBorderPainted(false);
        searchIcon = new ImageIcon("Image/searchIcon.png");
        Image imageSearch = searchIcon.getImage().getScaledInstance(searchButton.getWidth(),searchButton.getHeight(), Image.SCALE_SMOOTH);
        searchIcon = new ImageIcon(imageSearch);
        searchButton.setIcon(searchIcon);
        searchButton.addActionListener(this);

        ObjectInputStream is;
        try {
            is = new ObjectInputStream(new FileInputStream(fileName));
            
            try {
                articleList = (ArrayList)is.readObject();
            } catch (ClassNotFoundException e1) {
                System.out.println("Class Not Found");
                e1.printStackTrace();
            }
            is.close();
        } catch (FileNotFoundException e1) {
            System.out.println("File Not Found");
            e1.printStackTrace();
        } catch (IOException e1) {
            System.out.println("IO Exception");
            e1.printStackTrace();
        }

        // Set up of Article Icon and Button (Only 4 articles available currently)
        for (int i = 0; i < articleList.size(); i++)
        {
            articleButton[i] = new JButton();
            articleButton[i].setText(articleList.get(i).getTitle());
            articleButton[i].setBounds(0, 0, 50, 50);
            articleButton[i].setFont(new Font("Canva Sans", Font.BOLD,30));
            articleButton[i].setBackground(new Color(40,101,132));
            articleButton[i].setFocusable(false);
            articleButton[i].setForeground(Color.WHITE);
            articleIcon = new ImageIcon("Image/articleIcon.png");
            Image imageArticle = articleIcon.getImage().getScaledInstance(articleButton[i].getWidth(),articleButton[i].getHeight(), Image.SCALE_SMOOTH);
            articleIcon = new ImageIcon(imageArticle);
            articleButton[i].setIcon(articleIcon);
            articleButton[i].addActionListener(this);
            articlePanel.add(articleButton[i]);
        }

        // Panel to hold all article buttons
        articlePanel.setBounds(150, 280, 300, 450);
        articlePanel.setBackground(new Color(255,251,230));
        articlePanel.setOpaque(true);
        articlePanel.setLayout(new GridLayout(5,1,30,30));
        

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
        frame.add(bottomRibbon);
        frame.add(bgLabel);
        frame.add(searchBar);
        frame.add(searchButton);
        frame.add(articlePanel);
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

        // Redirect to profile page
        if(e.getSource() == profileButton)
        {
            new Profile(thisUser);
            frame.dispose();
        }

        // Insert any article number to search for that particular article
        // When a topic is searched, the other topics which are not related will be disabled
        if(e.getSource() == searchButton)
        {
            String number = searchBar.getText();

            switch(number)
            {
                case "1" :
                    articleButton[2].setEnabled(false);
                    articleButton[3].setEnabled(false);
                    articleButton[4].setEnabled(false);
                    break;

                case "2" :
                    articleButton[1].setEnabled(false);
                    articleButton[3].setEnabled(false);
                    articleButton[4].setEnabled(false);
                    break;

                case "3" :
                    articleButton[1].setEnabled(false);
                    articleButton[2].setEnabled(false);
                    articleButton[4].setEnabled(false);
                    break;

                case "4" :
                    articleButton[1].setEnabled(false);
                    articleButton[2].setEnabled(false);
                    articleButton[3].setEnabled(false);
                    break;
                
                default:
                    int i = 1;
                    do{
                        articleButton[i].setEnabled(true);
                        i++;
                    } while(i<=4);
                    break;
            }
        }



        
        
        // Direct to respective article webpage 
        // for(int i=1 ; i<=4 ; i++)
        // {
        //     if(e.getSource() == articleButton[i])
        //     {
        //         switch(i)
        //         {
        //             case 1 : 
        //                 try {
        //                     Desktop.getDesktop().browse(new URI("https://www.globalgoals.org/goals/13-climate-action/"));
        //                 } catch (IOException | URISyntaxException e1) {
        //                     e1.printStackTrace();
        //                 }
        //                 break;

        //             case 2 : 
        //                 try {
        //                     Desktop.getDesktop().browse(new URI("https://www.nytimes.com/article/climate-change-global-warming-faq.html"));
        //                 } catch (IOException | URISyntaxException e1) {
        //                     e1.printStackTrace();
        //                 }
        //                 break;

        //             case 3 : 
        //                 try {
        //                     Desktop.getDesktop().browse(new URI("https://news.un.org/en/story/2022/01/1110722?gclid=Cj0KCQjwsIejBhDOARIsANYqkD3dKeygHF3fpMChsmkwcvP1Xz1EVXCe33y9iTJsaIGWhIJBi2FXaIsaAscvEALw_wcB"));
        //                 } catch (IOException | URISyntaxException e1) {
        //                     e1.printStackTrace();
        //                 }
        //                 break;

        //             case 4 : 
        //                 try {
        //                     Desktop.getDesktop().browse(new URI("https://seagrant.psu.edu/node/1081"));
        //                 } catch (IOException | URISyntaxException e1) {
        //                     e1.printStackTrace();
        //                 }
        //                 break;
        //             }
        //         }
        //     }
        for(int i = 0 ; i <= 4 ; i++)
        {   
            if(e.getSource()==articleButton[i])
            {    
                try {
                    Desktop.getDesktop().browse(new URI(articleList.get(i).getUrl()));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
                break;
            }
        }
    }
}
