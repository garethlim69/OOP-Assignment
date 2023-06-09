package Public;

import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.*;

public class Quiz implements ActionListener {

	// Initialize of variable
	int secNum = 0;
	int answer; // actual answer of the question
	int index = 0; // question number
	int correct_guesses = 0; // to record the total correct guess of user
	int total_questions = 5; // total number of question in the quiz
	int result; // the percentage acquired by the user
	int points; // points earned by the user
	int seconds = 10; // time length for each question
	String message; // message to be displayed to user based on their percentage/result
	String currentUser;

	// Components needed to design the frame
	JFrame frame = new JFrame();
	JLabel quesNumberDisplay = new JLabel();
	JTextArea questionAsked = new JTextArea();   
	JButton buttonA;
	JButton buttonB;
	JButton buttonC;
	JLabel answer_labelA = new JLabel(); 
	JLabel answer_labelB = new JLabel(); 
	JLabel answer_labelC = new JLabel(); 
	JLabel number_right = new JLabel(); 
	JLabel percentage = new JLabel();  
	JLabel pointsEarned = new JLabel(); 
	JPanel resultPanel = new JPanel(); 
	JLabel time_label;
	JLabel time_left = new JLabel();
	JPanel time_leftPanel = new JPanel(); 
	JButton returnButton;
	ImageIcon returnIcon;

	// Anonymous inner class for ActionListener
	// Timer will count down from 10s
	Timer timer = new Timer(1000, new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// The timer will count down from 10s
			// The time will be displayed in the time_left (JLabel)
			seconds--;
			time_left.setText(String.valueOf(seconds));

			// when the time is up, the answer of the question is displayed to the user
			if (seconds <= 0) {
				displayAnswer();
			}
		}
	});

	String fileName = "Text Files/quiz.txt";
	ArrayList<ArrayList<Objects.Quiz>> quizList = new ArrayList<ArrayList<Objects.Quiz>>();
	ArrayList<Objects.Quiz> quiz = new ArrayList<Objects.Quiz>();

	// Constructor (To load the quiz page)
	// The username of the current user and the Quiz section chosen is passed into
	// the constructor
	public Quiz(String username, int thisSecNum) {
		ObjectInputStream is;
		try {
			is = new ObjectInputStream(new FileInputStream(fileName));
			try {
				quizList = (ArrayList) is.readObject();
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

		secNum = thisSecNum;
		quiz = quizList.get(secNum - 1);
		total_questions = quiz.size();
		currentUser = username;

		// To display question number on the top of page
		quesNumberDisplay.setBounds(0, 20, 600, 50);
		quesNumberDisplay.setBackground(new Color(255, 251, 230));
		quesNumberDisplay.setOpaque(true);
		quesNumberDisplay.setForeground(Color.BLACK);
		quesNumberDisplay.setFont(new Font("Canva Sans", Font.BOLD, 50));
		quesNumberDisplay.setHorizontalAlignment(JTextField.CENTER);

		// To display the question stored in the Array
		questionAsked.setBounds(40, 130, 500, 200);
		questionAsked.setLineWrap(true);
		questionAsked.setWrapStyleWord(true);
		questionAsked.setBackground(new Color(64, 99, 70));
		questionAsked.setForeground(Color.WHITE);
		questionAsked.setFont(new Font("Canva Sans", Font.BOLD, 25));
		questionAsked.setBorder(BorderFactory.createBevelBorder(1));
		questionAsked.setEditable(false);

		// Buttons
		buttonA = new JButton("A");
		buttonA.setBounds(40, 350, 80, 80);
		buttonA.setFont(new Font("MV Boli", Font.BOLD, 35));
		buttonA.setFocusable(false);
		buttonA.setBackground(Color.WHITE);
		buttonA.addActionListener(this);

		buttonB = new JButton("B");
		buttonB.setBounds(40, 450, 80, 80);
		buttonB.setFont(new Font("MV Boli", Font.BOLD, 35));
		buttonB.setFocusable(false);
		buttonB.setBackground(Color.WHITE);
		buttonB.addActionListener(this);

		buttonC = new JButton("C");
		buttonC.setBounds(40, 550, 80, 80);
		buttonC.setFont(new Font("MV Boli", Font.BOLD, 35));
		buttonC.setFocusable(false);
		buttonC.setBackground(Color.WHITE);
		buttonC.addActionListener(this);

		// Option for Button A
		answer_labelA.setBounds(135, 350, 500, 100);
		answer_labelA.setForeground(Color.BLACK);
		answer_labelA.setFont(new Font("MV Boli", Font.PLAIN, 25));

		// Option for Button B
		answer_labelB.setBounds(135, 450, 500, 100);
		answer_labelB.setForeground(Color.BLACK);
		answer_labelB.setFont(new Font("MV Boli", Font.PLAIN, 25));

		// Option for Button C
		answer_labelC.setBounds(135, 550, 500, 100);
		answer_labelC.setForeground(Color.BLACK);
		answer_labelC.setFont(new Font("MV Boli", Font.PLAIN, 23));

		// Display of the time left
		time_left.setBackground(Color.ORANGE);
		time_left.setForeground(Color.WHITE);
		time_left.setFont(new Font("Canva Sans", Font.BOLD, 50));
		time_left.setHorizontalAlignment(JTextField.CENTER);
		time_left.setText(String.valueOf(seconds));

		// This panel is used to hold time_left label
		time_leftPanel.setBounds(475, 680, 70, 70);
		time_leftPanel.setBackground(Color.ORANGE);
		time_leftPanel.add(time_left);

		// Title of the timer
		time_label = new JLabel("Timer");
		time_label.setBounds(460, 655, 100, 25);
		time_label.setBackground(new Color(50, 50, 50));
		time_label.setForeground(Color.BLACK);
		time_label.setFont(new Font("MV Boli", Font.PLAIN, 16));
		time_label.setHorizontalAlignment(JTextField.CENTER);

		// Return button (only consists of icon and no text in this button)
		returnButton = new JButton();
		returnButton.setFocusable(false);
		returnButton.setBounds(260, 680, 50, 50);
		returnButton.setOpaque(false);
		returnButton.setContentAreaFilled(false);
		returnButton.setBorderPainted(false);
		returnButton.addActionListener(this);

		returnIcon = new ImageIcon("Image/returnIcon.png");
		Image imageReturn = returnIcon.getImage().getScaledInstance(returnButton.getWidth(), returnButton.getHeight(),
				Image.SCALE_SMOOTH);
		returnIcon = new ImageIcon(imageReturn);
		returnButton.setIcon(returnIcon);

		// ------------------------------This part is only used when user completed the
		// quiz--------------------------------//
		// ------------------------------ It is used to design the frame to show quiz
		// result to the user --------------------------//

		// To show how many question do the user answered correctly
		number_right.setBounds(225, 425, 200, 70);
		number_right.setForeground(Color.BLACK);
		number_right.setFont(new Font("Canva Sans", Font.BOLD, 40));
		number_right.setHorizontalAlignment(JTextField.CENTER);

		// To show the percentage acquired by the user
		percentage.setBounds(225, 525, 200, 70);
		percentage.setForeground(Color.BLACK);
		percentage.setFont(new Font("Canva Sans", Font.BOLD, 40));
		percentage.setHorizontalAlignment(JTextField.CENTER);

		// To show the point earned by the user
		pointsEarned.setBounds(225, 625, 200, 70);
		pointsEarned.setForeground(Color.BLACK);
		pointsEarned.setFont(new Font("Canva Sans", Font.BOLD, 40));
		pointsEarned.setHorizontalAlignment(JTextField.CENTER);

		// Result panel used to hold number_right, percentage, pointsEarned
		resultPanel.setBounds(40, 310, 500, 300);
		resultPanel.setLayout(new GridLayout(3, 1, 10, 10));
		resultPanel.setBackground(new Color(218, 238, 219));

		// Set up of frame
		frame.add(time_label);
		frame.add(time_leftPanel);
		frame.add(answer_labelA);
		frame.add(answer_labelB);
		frame.add(answer_labelC);
		frame.add(buttonA);
		frame.add(buttonB);
		frame.add(buttonC);
		frame.add(questionAsked);
		frame.add(quesNumberDisplay);
		frame.add(returnButton);
		frame.setSize(600, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(255, 251, 230));
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);

		// As the user load to this Quiz Page, the quiz will start instantly and the
		// question will be displayed directed to the user
		nextQuestion(secNum, total_questions);
	}

	// Method to proceed to the next Question whenever the user completed the
	// previous question or the time is up
	private void nextQuestion(int thisSecNum, int thisTotal_questions) {
		// As all the questions in the Quiz set are being asked, the result will be
		// displayed to the user
		if (index >= thisTotal_questions) {
			results();
		}

		// If not all questions are asked, always proceed to the next question
		else {
			quesNumberDisplay.setText("Question " + (index + 1) + "/" + thisTotal_questions);

			// Acquire the questions and its options from Arrays and placed them in
			// respective panel
			questionAsked.setText(quiz.get(index).getQuestion());
			answer_labelA.setText(quiz.get(index).getAnswer1());
			answer_labelB.setText(quiz.get(index).getAnswer2());
			answer_labelC.setText(quiz.get(index).getAnswer3());

			// Start the timer whenever the new question is displayed
			timer.start();
		}
	}

	// As the user clicked on any button (A, B, or C), the timer will stop and will
	// display the correct answer of the current question
	@Override
	public void actionPerformed(ActionEvent e) {
		// Stop the timer when the user chooses his answer by clicking the button
		// (A/B/C)
		timer.stop();

		// All the buttons cannot be clicked when displaying the correct answer
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);

		// If the user's guess is correct, increment the correct_guesses
		if (e.getSource() == buttonA) {
			answer = 1;
			if (answer == quiz.get(index).getCorrectAnswer()) {
				correct_guesses++;
			}
		}
		if (e.getSource() == buttonB) {
			answer = 2;
			if (answer == quiz.get(index).getCorrectAnswer()) {
				correct_guesses++;
			}
		}
		if (e.getSource() == buttonC) {
			answer = 3;
			if (answer == quiz.get(index).getCorrectAnswer()) {
				correct_guesses++;
			}
		}

		// If the user want to stop the quiz halfway, he will click this Return Button
		if (e.getSource() == returnButton) {
			new QuizMainPage(currentUser);
			frame.dispose();
		}

		// When any button is clicked, display the correct answer
		displayAnswer();

	}

	// Method to display the answer of the current question to the user
	private void displayAnswer() {
		// Timer will stop
		timer.stop();

		// When display answer, all buttons cannot be clicked
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);

		// All the wrong options will be colored in red
		if (quiz.get(index).getCorrectAnswer() != 1)
			answer_labelA.setForeground(Color.RED);
		if (quiz.get(index).getCorrectAnswer() != 2)
			answer_labelB.setForeground(Color.RED);
		if (quiz.get(index).getCorrectAnswer() != 3)
			answer_labelC.setForeground(Color.RED);

		// The only correct answer will be colored in green
		if (quiz.get(index).getCorrectAnswer() == 1)
			answer_labelA.setForeground(Color.GREEN);
		if (quiz.get(index).getCorrectAnswer() == 2)
			answer_labelB.setForeground(Color.GREEN);
		if (quiz.get(index).getCorrectAnswer() == 3)
			answer_labelC.setForeground(Color.GREEN);

		/*
		 * --- Eveytime the answer is displayed, stop the timer for 2s
		 * --- This 2s is used to reverse the Quiz to its original/initial state
		 */
		Timer pause = new Timer(2000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// The options of A,B and C buttons are colored in black again
				answer_labelA.setForeground(Color.BLACK);
				answer_labelB.setForeground(Color.BLACK);
				answer_labelC.setForeground(Color.BLACK);

				// Reset the timer to 10s again
				// Initialize the answer as NULL
				answer = ' ';
				seconds = 10;
				time_left.setText(String.valueOf(seconds));

				// All buttons can be clicked again
				buttonA.setEnabled(true);
				buttonB.setEnabled(true);
				buttonC.setEnabled(true);

				// The index is increase by 1 so that Java can proceed to the next question
				// stored in Array
				index++;

				// Always proceed to the next question
				nextQuestion(secNum, total_questions);
			}
		});

		pause.setRepeats(false);
		pause.start();
	}

	// This method is called when all questions are answered by user
	private void results() {
		// To make the button disappear from the frame
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonA.setBounds(500, 500, 0, 0);
		buttonB.setBounds(500, 500, 0, 0);
		buttonC.setBounds(500, 500, 0, 0);

		// All components related to the result of the quiz
		result = (int) ((correct_guesses / (double) total_questions) * 100);
		points = correct_guesses * 10;
		String pointGet = Integer.toString(points);

		// Title of the Result Page
		quesNumberDisplay.setText("Quiz Completed !");

		// All labels set as empty
		questionAsked.setText("");
		answer_labelA.setText("");
		answer_labelB.setText("");
		answer_labelC.setText("");

		// Display the result to the user
		number_right.setText("Correct:  " + "(" + correct_guesses + "/" + total_questions + ")");
		percentage.setText("Percentage:  " + result + "%");
		pointsEarned.setText("Points earned:  " + pointGet);

		// Based on the result acquired by the user, the message is passed into the
		// method
		messageDisplay(result);

		// Lastly, the result is displayed at the center of the frame
		resultPanel.add(number_right);
		resultPanel.add(percentage);
		resultPanel.add(pointsEarned);

		frame.add(resultPanel);
	}

	// Collection of message to be displayed to the users based on their percentage
	public void messageDisplay(int percentageGet) {
		if (percentageGet >= 0 && percentageGet <= 40)
			message = "Don't be discouraged! Try harder next time";
		if (percentageGet > 40 && percentageGet <= 60)
			message = "You're doing well! You're making steady progress.";
		if (percentageGet > 60 && percentageGet <= 80)
			message = " Great job! You're making great progress. You'll soon reach the next level.  ";
		if (percentageGet > 80 && percentageGet <= 100)
			message = "Congratulations! Keep up the excellent work and keep challenging yourself to go even further!";

		questionAsked.setBounds(40, 130, 500, 100);
		questionAsked.setText(message);
	}
}
