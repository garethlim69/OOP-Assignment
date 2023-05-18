package Public;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class QuizDetails implements ActionListener
{
    // Declare all components needed to design the frame
    JFrame frame = new JFrame();
    JButton homeButton;
    JButton returnButton;
    ImageIcon returnIcon;
    ImageIcon homeIcon;
    ImageIcon chatIcon;
    JLabel chatLabel;
    JLabel chatIconLabel = new JLabel();
    JPanel detailPanel = new JPanel();
    JLabel quizNumber;
    JLabel noOfQuesLabel;
    JLabel quizLevelLabel;
    JLabel noOfQues;
    JLabel quizLevel;
    JButton startButton;
    JButton cancelButton;


    // Initialize of the username and quiz section
    String thisUser = "";
    int quizSecNum;
    

    // Constructor (To load the Quiz Detail Page)
    // The username of the current user and the Quiz section chosen are passed into this constructot
    public QuizDetails(String username, int chosenQuizNumber)
    {
        /*
           -- The quiz section always minus by one
           -- This is because the quiz is stored in array
           -- The initial index of any Array is always 0
           -- Since the chosenQuizNumber started by 1, we need to minus 1 to gain the Quiz section
        */
        quizSecNum = chosenQuizNumber-1;
        thisUser = username;


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



        // Icon
        chatIcon = new ImageIcon("Image/chat.png");
        chatIconLabel.setBounds(40,10,380,230);
        Image imageChat = chatIcon.getImage().getScaledInstance(chatIconLabel.getWidth(),chatIconLabel.getHeight(), Image.SCALE_SMOOTH);
        chatIcon = new ImageIcon(imageChat);
        chatIconLabel.setIcon(chatIcon);


        // Text inside the Icon
        chatLabel = new JLabel("Let's Play!");
        chatLabel.setBounds(75,12,400,200);
        chatLabel.setFont(new Font("Comic Sans MS",Font.BOLD,55));
        chatLabel.setForeground(Color.BLACK);


        // Quiz Number Label
        quizNumber = new JLabel("Quiz " + chosenQuizNumber);
        quizNumber.setBounds(155,190,400,200);
        quizNumber.setFont(new Font("Canva Sans",Font.BOLD,40));
        quizNumber.setForeground(Color.WHITE);


        // No of Question label (To show the total number of questions in the Quiz)
        noOfQuesLabel = new JLabel("Number of questions: ");
        noOfQuesLabel.setBounds(45,260,400,200);
        noOfQuesLabel.setFont(new Font("Canva Sans",Font.PLAIN,25));
        noOfQuesLabel.setForeground(Color.WHITE);


        // Actual no of question (We set that all Quiz section only have 5 questions)
        noOfQues = new JLabel("5");
        noOfQues.setBounds(300,260,400,200);
        noOfQues.setFont(new Font("Canva Sans",Font.PLAIN,25));
        noOfQues.setForeground(Color.WHITE);

        // Difficulty level label
        quizLevelLabel = new JLabel("Difficulty level: ");
        quizLevelLabel.setBounds(45,300,400,200);
        quizLevelLabel.setFont(new Font("Canva Sans",Font.PLAIN,25));
        quizLevelLabel.setForeground(Color.WHITE);

        // Display the difficulty level (We set the difficulty level for all Quiz section to "Easy")
        quizLevel = new JLabel("Easy");
        quizLevel.setBounds(240,300,400,200);
        quizLevel.setFont(new Font("Canva Sans",Font.PLAIN,25));
        quizLevel.setForeground(Color.WHITE);


        // Detail Panel (Used to hold other components)
        detailPanel.setBounds(70,90,450,430);
        detailPanel.setBackground(new Color(64,99,70));
        detailPanel.setLayout(null);
        detailPanel.add(chatLabel);
        detailPanel.add(chatIconLabel);
        detailPanel.add(quizNumber);
        detailPanel.add(noOfQuesLabel);
        detailPanel.add(quizLevelLabel);
        detailPanel.add(noOfQues);
        detailPanel.add(quizLevel);


        // Start button
        startButton = new JButton("Start");
        startButton.setFocusable(false);
        startButton.setBounds(190, 580, 180, 55);
        startButton.setForeground(Color.WHITE);
        startButton.setFont(new Font("Canva Sans",Font.BOLD,20));
        startButton.setBackground(new Color(79,71,51));
        startButton.addActionListener(this);


        // Cancel button
        cancelButton = new JButton("Cancel");
        cancelButton.setFocusable(false);
        cancelButton.setBounds(190, 660, 180, 55);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFont(new Font("Canva Sans",Font.BOLD,20));
        cancelButton.setBackground(new Color(79,71,51));
        cancelButton.addActionListener(this);

        // Set up of frame
        frame.add(homeButton);
        frame.add(returnButton);
        frame.add(detailPanel);
        frame.add(startButton);
        frame.add(cancelButton);
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
        // Redirect the user to the Home Page
        if(e.getSource() == homeButton)
        {
            new HomePage(thisUser);
            frame.dispose();
        }


        // Redirect to the Quiz Main Page (where the user can choose the Quiz section)
        if(e.getSource() == returnButton)
        {
            new QuizMainPage(thisUser);
            frame.dispose();
        }

        // Redirect to Quiz Main Page as well
        if(e.getSource() == cancelButton)
        {
            new QuizMainPage(thisUser);
            frame.dispose();
        }

        
        /*
        When the user confirmed to play the quiz, he will click on the startButton
        --- The user will be directed to different quiz set based on the Quiz Section he chose before
        */
        if(e.getSource() == startButton)
        {
            switch(quizSecNum)
            {
                case 0 : 
                    new Quiz(thisUser,0);
                    frame.dispose();
                    break;
                case 1 : 
                    new Quiz(thisUser,1);
                    frame.dispose();
                    break;
                case 2 : 
                    new Quiz(thisUser,2);
                    frame.dispose();
                    break;
                case 3 : 
                    new Quiz(thisUser,3);
                    frame.dispose();
                    break;
                case 4 : 
                    new Quiz(thisUser,4);
                    frame.dispose();
                    break;
            }
        }
    }
}
