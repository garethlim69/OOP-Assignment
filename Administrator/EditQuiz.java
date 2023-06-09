package Administrator;

import java.awt.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Objects.Quiz;

public class EditQuiz implements ActionListener {

    JFrame frame = new JFrame();
    JButton homeButton;
    JButton notifyButton;
    JButton settingButton;
    ImageIcon homeIcon;
    JLabel title;
    JPanel topRibbon;
    ImageIcon notifyIcon;
    ImageIcon settingIcon;
    JPanel bottomRibbon;
    JPanel quizPanel = new JPanel();
    JButton[] quizButton = new JButton[30]; // The max amount of Quiz Section is 30
    JLabel questionIconLabel = new JLabel();

    String fileName = "Text Files/quiz.txt";
    ArrayList<ArrayList<Quiz>> quizList = new ArrayList<ArrayList<Quiz>>();
    int qnaSet = 0;

    public EditQuiz(ArrayList<ArrayList<Quiz>> quiz, int qns) {

        quizList = quiz;
        qnaSet = qns - 1;

        // Top ribbon
        topRibbon = new JPanel();
        topRibbon.setBounds(0, 0, 600, 150);
        topRibbon.setBackground(new Color(248, 207, 137));

        // Title
        title = new JLabel("Edit Question");
        title.setBounds(180, 20, 400, 100);
        title.setFont(new Font("Canva Sans", Font.BOLD, 40));
        title.setForeground(Color.BLACK);

        // Quiz Buttons
        for (int i = 1; i <= 5; i++) {
            quizButton[i] = new JButton(" Question " + i);
            quizButton[i].setBounds(0, 0, 50, 50);
            quizButton[i].setFont(new Font("Canva Sans", Font.BOLD, 30));
            quizButton[i].setBackground(new Color(241, 171, 80));
            quizButton[i].setFocusable(false);
            quizButton[i].setForeground(Color.WHITE);
            quizButton[i].addActionListener(this);
            quizPanel.add(quizButton[i]);
        }

        // Quiz Panel
        quizPanel.setLayout(null);
        quizPanel.setBounds(60, 200, 480, 450);
        quizPanel.setBackground(new Color(255, 251, 230));
        quizPanel.setOpaque(true);
        quizPanel.setLayout(new GridLayout(5, 1, 30, 30));

        // All buttons on bottom ribbon
        homeButton = new JButton();
        homeButton.setFocusable(false);
        homeButton.setBounds(10, 10, 50, 50);
        homeButton.setOpaque(false);
        homeButton.setContentAreaFilled(false);
        homeButton.setBorderPainted(false);
        homeIcon = new ImageIcon("Image/homeIcon.png");
        Image imageHome = homeIcon.getImage().getScaledInstance(homeButton.getWidth(), homeButton.getHeight(), Image.SCALE_SMOOTH);
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
        Image imageNotify = notifyIcon.getImage().getScaledInstance(notifyButton.getWidth(), notifyButton.getHeight(), Image.SCALE_SMOOTH);
        notifyIcon = new ImageIcon(imageNotify);
        notifyButton.setIcon(notifyIcon);

        settingButton = new JButton();
        settingButton.setFocusable(false);
        settingButton.setBounds(10, 10, 50, 50);
        settingButton.setOpaque(false);
        settingButton.setContentAreaFilled(false);
        settingButton.setBorderPainted(false);
        settingIcon = new ImageIcon("Image/settingIcon.png");
        Image imageSetting = settingIcon.getImage().getScaledInstance(settingButton.getWidth(), settingButton.getHeight(), Image.SCALE_SMOOTH);
        settingIcon = new ImageIcon(imageSetting);
        settingButton.setIcon(settingIcon);

        // Bottom ribbon
        bottomRibbon = new JPanel();
        bottomRibbon.setLayout(new GridLayout(1, 4, 10, 0));
        bottomRibbon.setBounds(0, 700, 600, 80);
        bottomRibbon.setBackground(new Color(102, 66, 40));
        bottomRibbon.add(homeButton);
        bottomRibbon.add(notifyButton);
        bottomRibbon.add(settingButton);

        // Set up of frame
        frame.add(bottomRibbon);
        frame.add(title);
        frame.add(quizPanel);
        frame.add(topRibbon);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(255, 251, 230));
        frame.setSize(600, 800);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Return to Admin Home Page
        if (e.getSource() == homeButton) {
            new A_HomePage();
            frame.dispose();
        }

        // Edit Quiz Question Component
        for (int i = 1; i <= quizList.get(qnaSet).size(); i++) {

            if (e.getSource() == quizButton[i]) {
                String question = JOptionPane.showInputDialog("Edit question",
                        quizList.get(qnaSet).get(i - 1).getQuestion());
                String ans1 = JOptionPane.showInputDialog("Edit option 1",
                        quizList.get(qnaSet).get(i - 1).getAnswer1());
                String ans2 = JOptionPane.showInputDialog("Edit option 2",
                        quizList.get(qnaSet).get(i - 1).getAnswer2());
                String ans3 = JOptionPane.showInputDialog("Edit option 3",
                        quizList.get(qnaSet).get(i - 1).getAnswer3());
                int correctAnswer = Integer.parseInt(JOptionPane.showInputDialog("Enter correct answer",
                        quizList.get(qnaSet).get(i - 1).getCorrectAnswer()));
                quizList.get(qnaSet).get(i - 1).setQuestion(question);
                quizList.get(qnaSet).get(i - 1).setAnswer1(ans1);
                quizList.get(qnaSet).get(i - 1).setAnswer2(ans2);
                quizList.get(qnaSet).get(i - 1).setAnswer3(ans3);
                quizList.get(qnaSet).get(i - 1).setCorrectAnswer(correctAnswer);

                try {
                    ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName, false));
                    os.writeObject(quizList);
                    os.close();
                } catch (IOException e1) {
                    System.out.println("IOException");
                }
            }
        }

    }

}
