package Administrator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Objects.Article;

public class EditArticle implements ActionListener{
    // Declare all components needed to design frame
    JFrame frame = new JFrame();
    JLabel title;
    JPanel topRibbon;
    JButton homeButton;
    JButton notifyButton;
    JButton settingButton;
    ImageIcon homeIcon;
    ImageIcon notifyIcon;
    ImageIcon settingIcon;
    JPanel bottomRibbon;
    JPanel programPanel = new JPanel();
    JButton[] programButton = new JButton[10];
    JTextField searchBar;

    ArrayList<Article> articleList = new ArrayList<Article>();
    String fileName = "Text Files/articles.txt";

    //Constructor
    public EditArticle(){
         // Top ribbon
        topRibbon = new JPanel();
        topRibbon.setBounds(0, 0, 600, 150);
        topRibbon.setBackground(new Color(248,207,137));


        // Title 
        title = new JLabel("Edit Article");
        title.setBounds(60, 20, 500, 100);
        title.setFont(new Font("Canva Sans",Font.BOLD,40));
        title.setForeground(Color.BLACK);

// ADD SERIALIZED INFO TO TEXT (TO REMOVE)
        // String article1Title = "Article 1";
        // String article1URL = "https://www.globalgoals.org/goals/13-climate-action/";
        // String article2Title = "Article 2";
        // String article2URL = "https://www.nytimes.com/article/climate-change-global-warming-faq.html";
        // String article3Title = "Article 3";
        // String article3URL = "https://news.un.org/en/story/2022/01/1110722?gclid=Cj0KCQjwsIejBhDOARIsANYqkD3dKeygHF3fpMChsmkwcvP1Xz1EVXCe33y9iTJsaIGWhIJBi2FXaIsaAscvEALw_wcB";
        // String article4Title = "Article 4";
        // String article4URL = "https://seagrant.psu.edu/node/1081";

        // Article article1 = new Article(article1Title, article1URL);
        // Article article2 = new Article(article2Title, article2URL);
        // Article article3 = new Article(article3Title, article3URL);
        // Article article4 = new Article(article4Title, article4URL);

        // ArrayList<Article> articleListRead = new ArrayList<Article>();
        // articleListRead.add(article1);
        // articleListRead.add(article2);
        // articleListRead.add(article3);
        // articleListRead.add(article4);
        // System.out.println("article list before printing: " + articleListRead);

        // try {
        //     ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName, false));
        //     os.writeObject(articleListRead);
        //     os.close();
        //     System.out.println("done writing");
        // } catch (IOException e1){
        //     System.out.println("IOException");
        // }
        
// END TO REMOVE


        //Deserializing component
        
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

        for (int i = 0; i < articleList.size(); i++){
            programButton[i] = new JButton();
            programButton[i].setText(articleList.get(i).getTitle());
            programButton[i].setBounds(0, 0, 50, 50);
            programButton[i].setFont(new Font("Canva Sans", Font.BOLD,20));
            programButton[i].setBackground(new Color(241,171,80));
            programButton[i].setFocusable(false);
            programButton[i].setForeground(Color.WHITE);
            programButton[i].addActionListener(this);
            programPanel.add(programButton[i]);
        }

        

        // Panel to hold all program buttons
        programPanel.setLayout(null);
        programPanel.setBounds(60, 200, 480, 450);
        programPanel.setBackground(new Color(255,251,230));
        programPanel.setOpaque(true);
        programPanel.setLayout(new GridLayout(5,1,30,30));
        

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
        bottomRibbon.add(notifyButton);
        bottomRibbon.add(settingButton);

        // Set up of frame
        frame.add(bottomRibbon);
        frame.add(title);
        frame.add(topRibbon);
        frame.add(programPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(255,251,230));
        frame.setSize(600,800);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        // Redirect to admin home page
        if(e.getSource() == homeButton)
        {
            System.out.println(articleList);
            new A_HomePage();
            frame.dispose();
        }

        for(int i = 0 ; i <= 4 ; i++)
        {   
            if(e.getSource()==programButton[i])
            {
                String title = JOptionPane.showInputDialog("Edit the video title", articleList.get(i).getTitle());
                String url = JOptionPane.showInputDialog("Edit the video URL", articleList.get(i).getUrl());
                if (title == null || url == null || title.equals("") || url.equals("") ) {
                    JOptionPane.showMessageDialog(null, "Blank Entry Detected. No Changes Were Made");
                }else {
                    articleList.get(i).setTitle(title);
                    articleList.get(i).setUrl(url);
                    try {
                        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName, false));
                        os.writeObject(articleList);
                        os.close();
                        System.out.println("done writing");
                        new EditArticle();
                        frame.dispose();
                    } catch (IOException e1){
                        System.out.println("IOException");
                    }
                }
                //System.out.println(articleList);
                //System.out.println("button " + i + " pressed");
                
                
                // System.out.println(articleList.get(i).getTitle());
                // System.out.println(articleList.get(i).getUrl());

                
            }
        }
    }
}
