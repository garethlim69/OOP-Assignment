/*
              This Home Page is not well-designed yet
              It only consists of the main buttons to direct us to other important page
 */

package Public;


import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import javax.swing.*;


public class HomePage implements ActionListener
{
    // Declaration of all components needed to design the frame
    JFrame frame = new JFrame();
    JLabel label;
    JButton quizButton;
    JButton messageButton;
    JButton profileButton;
    JButton redeemButton;
    JButton loginPageButton;
    JButton homeButton;
    JButton awareButton;
    JButton eduButton;
    JButton notifyButton;
    JButton settingButton;
    ImageIcon messageIcon;
    ImageIcon quizIcon;
    ImageIcon redeemIcon;
    ImageIcon profileIcon;
    ImageIcon homeIcon;
    ImageIcon notifyIcon;
    ImageIcon settingIcon;
    ImageIcon nextIcon;
    ImageIcon climateImage;
    ImageIcon educationImage;
    JLabel imageLabel1 = new JLabel();
    JLabel imageLabel2 = new JLabel();
    JLabel title1;
    JLabel title2;
    JLabel messageButtonLabel;
    JLabel quizButtonLabel;
    JLabel redeemButtonLabel;
    JTextArea desc1;
    JTextArea desc2;
    JPanel bottomRibbon;
    JPanel mediumRibbon;
    JPanel panel1;
    JPanel panel2;
    ImageIcon bgImage;
    JLabel bgLabel = new JLabel();

    // Initialize of the username
    String thisUsername = "";

    HashMap<String,String> LoginInfo = new HashMap<String,String>();


    // Constructor
    // It accepts HashMap of LoginInfo as argument
    public HomePage(String currentUsername)
    {
        // The username is being passed as an argument of the HomePage
        thisUsername = currentUsername;

        // Top ribbon
        bgImage = new ImageIcon("Image/homeTR.png");
        bgLabel.setBounds(0, 0, 600, 190);
        Image image1 = bgImage.getImage().getScaledInstance(bgLabel.getWidth(),bgLabel.getHeight(), Image.SCALE_SMOOTH);
        bgImage = new ImageIcon(image1);
        bgLabel.setIcon(bgImage);

        /////////////////////// Login button for testing purpose/////////////////////
        loginPageButton = new JButton("Return to LoginPage");
        loginPageButton.setBounds(150,660,250,35);
        loginPageButton.setForeground(Color.WHITE);
        loginPageButton.setFont(new Font("Canva Sans",Font.BOLD,15));
        loginPageButton.setBackground(new Color(38,99,54));
        loginPageButton.addActionListener(this);

        ///////////////////////////////////////////////////////////////////////////


        // All buttons on medium ribbon
        messageButton = new JButton();
        messageButton.setFocusable(false);
        messageButton.setBounds(10, 10, 50, 50);
        messageButton.setOpaque(false);
        messageButton.setContentAreaFilled(false);
        messageButton.setBorderPainted(false);
        messageButton.addActionListener(this);
        messageIcon = new ImageIcon("Image/messageIcon.png");
        Image imageMessage = messageIcon.getImage().getScaledInstance(messageButton.getWidth(),messageButton.getHeight(), Image.SCALE_SMOOTH);
        messageIcon = new ImageIcon(imageMessage);
        messageButton.setIcon(messageIcon);

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

        quizButton = new JButton();
        quizButton.setFocusable(false);
        quizButton.setBounds(10, 10, 50, 50);
        quizButton.setOpaque(false);
        quizButton.setContentAreaFilled(false);
        quizButton.setBorderPainted(false);
        quizIcon = new ImageIcon("Image/quizIcon.png");
        Image imageQuiz = quizIcon.getImage().getScaledInstance(quizButton.getWidth(),quizButton.getHeight(), Image.SCALE_SMOOTH);
        quizIcon = new ImageIcon(imageQuiz);
        quizButton.setIcon(quizIcon);
        quizButton.addActionListener(this);

        redeemButton = new JButton();
        redeemButton.setFocusable(false);
        redeemButton.setBounds(10, 10, 70, 70);
        redeemButton.setOpaque(false);
        redeemButton.setContentAreaFilled(false);
        redeemButton.setBorderPainted(false);
        redeemButton.addActionListener(this);
        redeemIcon = new ImageIcon("Image/redeemIcon.png");
        Image imageRedeem = redeemIcon.getImage().getScaledInstance(redeemButton.getWidth(),redeemButton.getHeight(), Image.SCALE_SMOOTH);
        redeemIcon = new ImageIcon(imageRedeem);
        redeemButton.setIcon(redeemIcon);


        // medium ribbon
        mediumRibbon = new JPanel();
        mediumRibbon.setLayout(new GridLayout(1, 4, 18, 0));
        mediumRibbon.setBounds(60, 150, 450, 100);
        mediumRibbon.setBackground(new Color(133,153,112));
        mediumRibbon.add(messageButton);
        mediumRibbon.add(quizButton);
        mediumRibbon.add(redeemButton);
        mediumRibbon.add(profileButton);


        // Label
        label = new JLabel("Let's Get Started");
        label.setFont(new Font("Cnava Sans",Font.BOLD,25));
        label.setForeground(Color.BLACK);
        label.setBounds(20, 270, 300, 50);


        // Title for self-awareness program
        title1 = new JLabel("Self-awareness Program");
        title1.setFont(new Font("Canva Sans",Font.BOLD,20));
        title1.setBounds(50, 330, 250, 30);
        title1.setForeground(Color.BLACK);

        // Title for education program
        title2 = new JLabel("Education Program");
        title2.setFont(new Font("Canva Sans",Font.BOLD,20));
        title2.setBounds(50, 510, 200, 30);
        title2.setForeground(Color.BLACK);

        // Description for self awareness program
        desc1 = new JTextArea("Reduce the effects of climate change together");
        desc1.setLineWrap(true);
        desc1.setWrapStyleWord(true);   
        desc1.setFont(new Font("Arial",Font.PLAIN,17)); 
        desc1.setBounds(50,370,200,100);
        desc1.setEditable(false);

        // Description for education program
        desc2 = new JTextArea("Learn more about climate change");
        desc2.setLineWrap(true);
        desc2.setWrapStyleWord(true);   
        desc2.setFont(new Font("Arial",Font.PLAIN,17)); 
        desc2.setBounds(50,560,200,100);
        desc2.setEditable(false);


        // Image of self-awareness program
        climateImage = new ImageIcon("Image/climateChange.jpg");
        imageLabel1.setBounds(290, 330, 200, 130);
        Image image = climateImage.getImage().getScaledInstance(imageLabel1.getWidth(),imageLabel1.getHeight(), Image.SCALE_SMOOTH);
        climateImage = new ImageIcon(image);
        imageLabel1.setIcon(climateImage);

        // Image of education program
        educationImage = new ImageIcon("Image/bulb.jpg");
        imageLabel2.setBounds(290, 510, 200, 130);
        Image image2 = educationImage.getImage().getScaledInstance(imageLabel2.getWidth(),imageLabel2.getHeight(), Image.SCALE_SMOOTH);
        educationImage = new ImageIcon(image2);
        imageLabel2.setIcon(educationImage);

        // Self-awareness button
        awareButton = new JButton();
        awareButton.setFocusable(false);
        awareButton.setBounds(490, 370, 50, 50);
        awareButton.setOpaque(false);
        awareButton.setContentAreaFilled(false);
        awareButton.setBorderPainted(false);
        nextIcon = new ImageIcon("Image/nextButton.png");
        Image imageNext = nextIcon.getImage().getScaledInstance(profileButton.getWidth(),profileButton.getHeight(), Image.SCALE_SMOOTH);
        nextIcon = new ImageIcon(imageNext);
        awareButton.setIcon(nextIcon);
        awareButton.addActionListener(this);

        // Education button
        eduButton = new JButton();
        eduButton.setFocusable(false);
        eduButton.setBounds(490, 550, 50, 50);
        eduButton.setOpaque(false);
        eduButton.setContentAreaFilled(false);
        eduButton.setBorderPainted(false);
        nextIcon = new ImageIcon("Image/nextButton.png");
        Image imageNext2 = nextIcon.getImage().getScaledInstance(eduButton.getWidth(),eduButton.getHeight(), Image.SCALE_SMOOTH);
        nextIcon = new ImageIcon(imageNext2);
        eduButton.setIcon(nextIcon);
        eduButton.addActionListener(this);

        // Panel 1 --- contains self-awareness program
        panel1 = new JPanel();
        panel1.setBackground(Color.WHITE);
        panel1.setBounds(40, 320, 500, 150);

        // Panel 2 --- contains education program
        panel2 = new JPanel();
        panel2.setBackground(Color.WHITE);
        panel2.setBounds(40, 500, 500, 150);


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
        frame.add(mediumRibbon);
        frame.add(bgLabel);
        frame.add(label);
        frame.add(loginPageButton);
        frame.add(imageLabel1);
        frame.add(imageLabel2);
        frame.add(title1);
        frame.add(title2);
        frame.add(desc1);
        frame.add(desc2);
        frame.add(awareButton);
        frame.add(eduButton);
        frame.add(panel1);
        frame.add(panel2);
        frame.add(bottomRibbon);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(255,255,238));
        frame.setSize(600,800);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }


    // List of event or activity being activated when the button is pressed
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == profileButton)
        {
            new Profile(thisUsername);
            frame.dispose();
        }
        if(e.getSource() == quizButton)
        {
            new QuizMainPage(thisUsername);
            frame.dispose();
        }
        if(e.getSource() == messageButton)
        {
            new SuggestionBox(thisUsername);
            frame.dispose();
        }
        if(e.getSource()==loginPageButton)
        {
            new LoginPage(LoginInfo);
            frame.dispose();
        }
        if(e.getSource() == eduButton)
        {
            new EducationPage(thisUsername);
            frame.dispose();
        }
        if(e.getSource() == awareButton)
        {
            new AwarenessProgram(thisUsername);
            frame.dispose();
        }
        if(e.getSource() == redeemButton)
        {
            new RedeemPage(thisUsername);
            frame.dispose();
        }
    }
    
}
