package Public;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class QuizMainPage implements ActionListener
{
    // Declare all components needed to design frame
    JFrame frame = new JFrame();
    JButton homeButton;
    JButton returnButton;
    ImageIcon homeIcon;
    ImageIcon returnIcon;
    JLabel bgLabel = new JLabel();
    ImageIcon bgImage;
    JLabel title;
    JPanel instructionPanel = new JPanel();
    JLabel instruction1;
    JLabel instruction2;
    ImageIcon trophyIcon;
    JLabel trophyLabel = new JLabel();
    JPanel quizPanel = new JPanel();
    JButton[] quizButton = new JButton[30];  // The max amount of Quiz Section is 30
    ImageIcon questionIcon;
    JLabel questionIconLabel = new JLabel();

    String thisUser = "";

    // Constructor (To load the Quiz Main Page)
    // The username of current user is passed into this constructor
    public QuizMainPage(String currentUser)
    {
        thisUser = currentUser;


        // Background image
        bgImage = new ImageIcon("Image/green.jpg");
        bgLabel.setBounds(0, 0, 600, 100);
        Image image = bgImage.getImage().getScaledInstance(bgLabel.getWidth(),bgLabel.getHeight(), Image.SCALE_SMOOTH);
        bgImage = new ImageIcon(image);
        bgLabel.setIcon(bgImage);


        // Title of Quiz Zone Page
        title = new JLabel("Quiz Zone");
        title.setBounds(190, 20, 400, 100);
        title.setFont(new Font("Canva Sans",Font.BOLD,45));
        title.setForeground(Color.BLACK);


        // Return Button (Only has Icon and no text in this button)
        returnButton = new JButton();
        returnButton.setFocusable(false);
        returnButton.setBounds(75, 15, 40, 40);
        returnButton.setOpaque(false);
        returnButton.setContentAreaFilled(false);
        returnButton.setBorderPainted(false);
        returnButton.setForeground(Color.BLACK);
        returnButton.setFont(new Font("Canva Sans",Font.PLAIN,20));
        returnButton.addActionListener(this);

        returnIcon = new ImageIcon("Image/returnIcon.png");
        Image imageReturn = returnIcon.getImage().getScaledInstance(returnButton.getWidth(),returnButton.getHeight(), Image.SCALE_SMOOTH);
        returnIcon = new ImageIcon(imageReturn);
        returnButton.setIcon(returnIcon);

        // Home button (Only has Icon and no text in this button)
        homeButton = new JButton();
        homeButton.setFocusable(false);
        homeButton.setBounds(10, 10, 50, 50);
        homeButton.setOpaque(false);
        homeButton.setContentAreaFilled(false);
        homeButton.setBorderPainted(false);
        homeButton.setForeground(Color.BLACK);
        homeButton.setFont(new Font("Canva Sans",Font.PLAIN,20));
        homeButton.addActionListener(this);

        homeIcon = new ImageIcon("Image/homeIcon.png");
        Image imageHome = homeIcon.getImage().getScaledInstance(homeButton.getWidth(),homeButton.getHeight(), Image.SCALE_SMOOTH);
        homeIcon = new ImageIcon(imageHome);
        homeButton.setIcon(homeIcon);


        // TrophyIcon
        trophyIcon = new ImageIcon("Image/trophy.png");
        trophyLabel.setBounds(25,10,70,70);
        Image imageTrophy = trophyIcon.getImage().getScaledInstance(trophyLabel.getWidth(),trophyLabel.getHeight(), Image.SCALE_SMOOTH);
        trophyIcon = new ImageIcon(imageTrophy);
        trophyLabel.setIcon(trophyIcon);


        // Instruction1 
        instruction1 = new JLabel("Attend any quiz to gain points.");
        instruction1.setBounds(120, 15, 400, 30);
        instruction1.setFont(new Font("Arial",Font.PLAIN,20));
        instruction1.setForeground(Color.BLACK);


        // Instruction2 
        instruction2 = new JLabel("Click on the Quiz number.");
        instruction2.setBounds(120, 45, 400, 30);
        instruction2.setFont(new Font("Arial",Font.PLAIN,20));
        instruction2.setForeground(Color.BLACK);


        // Instruction Panel (to hold the instructions)
        instructionPanel.add(trophyLabel);
        instructionPanel.add(instruction1);
        instructionPanel.add(instruction2);
        instructionPanel.setLayout(null);
        instructionPanel.setBounds(45, 120, 500, 100);
        instructionPanel.setBackground(Color.WHITE);



        // Set up of Quiz Icon and Button (Only 5 Quiz section available currently)
        for (int i=1 ; i<=5 ; i++)
        {
            quizButton[i] = new JButton("  Quiz " + i);

            quizButton[i].setBounds(0, 0, 50, 50);
            quizButton[i].setFont(new Font("Canva Sans", Font.BOLD,30));
            quizButton[i].setBackground(new Color(221,215,183));
            quizButton[i].setFocusable(false);
            quizButton[i].setForeground(Color.BLACK);

            questionIcon = new ImageIcon("Image/questionIcon.png");
            Image imageQuestion = questionIcon.getImage().getScaledInstance(quizButton[i].getWidth(),quizButton[i].getHeight(), Image.SCALE_SMOOTH);
            questionIcon = new ImageIcon(imageQuestion);
            quizButton[i].setIcon(questionIcon);

            quizButton[i].addActionListener(this);

            quizPanel.add(quizButton[i]);
        }


        // Quiz Panel  
        quizPanel.setLayout(null);
        quizPanel.setBounds(100, 250, 380, 450);
        quizPanel.setBackground(new Color(255,251,230));
        quizPanel.setOpaque(true);
        quizPanel.setLayout(new GridLayout(5,1,30,30));
        

        // Set up of frame
        frame.add(homeButton);
        frame.add(returnButton);
        frame.add(title);
        frame.add(bgLabel);
        frame.add(instructionPanel);
        frame.add(quizPanel);
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
        // Redirect to the Home Page
        if(e.getSource() == homeButton)
        {
            new HomePage(thisUser);
            frame.dispose();
        }
        if(e.getSource() == returnButton)
        {
            new EducationPage(thisUser);
            frame.dispose();
        }


        /*
        User can choose any Quiz section they plan to attend
        ----- Quiz 1 - Quiz 5
        ----- After choosing the Quiz Section they want to play, they will be directed to the respective Quiz Detail Page
         */
        for(int i=1 ; i<=5 ; i++)
        {
            if(e.getSource() == quizButton[i])
            {

                new QuizDetails(thisUser, i);
                frame.dispose();

        
            }
        }
    }
}
