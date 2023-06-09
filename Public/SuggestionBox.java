package Public;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

import javax.swing.*;

import Objects.Message;

public class SuggestionBox implements ActionListener {
    // Declare of components needed to design the frame
    JFrame frame = new JFrame();
    JTextArea inputArea;
    JButton sendButton;
    JButton resetButton;
    JButton homeButton;
    JButton profileButton;
    JButton notifyButton;
    JButton settingButton;
    ImageIcon returnIcon;
    ImageIcon homeIcon;
    ImageIcon profileIcon;
    ImageIcon notifyIcon;
    ImageIcon settingIcon;
    ImageIcon adminIcon;
    JLabel adminIconLabel = new JLabel();
    JLabel adminLabel;
    JTextArea messageToUser;
    JLabel toAdminLabel;
    JLabel sendSuccess;
    JPanel bottomRibbon;
    JPanel toAdminPanel;
    ImageIcon bgImage;
    JLabel bgLabel = new JLabel();

    String username;
    String message;
    String fileName;
    String filePath;

    ArrayList<Message> messageList;

    // Constructor (to load the Suggestion Box Page)
    // The username of the current user is passed into the constructor
    public SuggestionBox(String thisUser) {
        // To store/rememeber the username which sent the message
        username = thisUser;

        // Top ribbon
        bgImage = new ImageIcon("Image/feedbackTR.png");
        bgLabel.setBounds(0, 0, 600, 120);
        Image image = bgImage.getImage().getScaledInstance(bgLabel.getWidth(), bgLabel.getHeight(), Image.SCALE_SMOOTH);
        bgImage = new ImageIcon(image);
        bgLabel.setIcon(bgImage);

        // Admin icon
        adminIcon = new ImageIcon("Image/admin.png");
        adminIconLabel.setBounds(80, 130, 70, 75);
        Image imageAdmin = adminIcon.getImage().getScaledInstance(adminIconLabel.getWidth(), adminIconLabel.getHeight(),
                Image.SCALE_SMOOTH);
        adminIcon = new ImageIcon(imageAdmin);
        adminIconLabel.setIcon(adminIcon);

        // Admin label besides the admin icon
        adminLabel = new JLabel("Admin");
        adminLabel.setBounds(170, 160, 300, 30);
        adminLabel.setFont(new Font("Canva Sans", Font.PLAIN, 25));

        // Message to be displayed to user
        messageToUser = new JTextArea();
        messageToUser.setBounds(50, 210, 480, 100);
        messageToUser.setLineWrap(true);
        messageToUser.setWrapStyleWord(true);
        messageToUser.setBackground(new Color(246, 201, 231));
        messageToUser.setForeground(Color.BLACK);
        messageToUser.setFont(new Font("Arial", Font.PLAIN, 20));
        messageToUser.setBorder(BorderFactory.createBevelBorder(1));
        messageToUser.setEditable(false);
        messageToUser.setText("The responsibility for addressing climate change falls on us all, and your input and suggestions can have a significant impact towards progress.");

        // All Button (this button consists of a Home Icon with no text)
        homeButton = new JButton();
        homeButton.setFocusable(false);
        homeButton.setBounds(10, 10, 50, 50);
        homeButton.setOpaque(false);
        homeButton.setContentAreaFilled(false);
        homeButton.setBorderPainted(false);
        homeButton.addActionListener(this);
        homeIcon = new ImageIcon("Image/homeIcon.png");
        Image imageHome = homeIcon.getImage().getScaledInstance(homeButton.getWidth(), homeButton.getHeight(), Image.SCALE_SMOOTH);
        homeIcon = new ImageIcon(imageHome);
        homeButton.setIcon(homeIcon);

        profileButton = new JButton();
        profileButton.setFocusable(false);
        profileButton.setBounds(10, 10, 50, 50);
        profileButton.setOpaque(false);
        profileButton.setContentAreaFilled(false);
        profileButton.setBorderPainted(false);
        profileIcon = new ImageIcon("Image/profileIcon.png");
        Image imageProfile = profileIcon.getImage().getScaledInstance(profileButton.getWidth(), profileButton.getHeight(), Image.SCALE_SMOOTH);
        profileIcon = new ImageIcon(imageProfile);
        profileButton.setIcon(profileIcon);

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
        settingButton.addActionListener(this);
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
        bottomRibbon.add(profileButton);
        bottomRibbon.add(notifyButton);
        bottomRibbon.add(settingButton);

        // Area which allow user to type in message
        inputArea = new JTextArea();
        inputArea = new JTextArea();
        inputArea.setLineWrap(true);
        inputArea.setWrapStyleWord(true);
        inputArea.setFont(new Font("Arial", Font.PLAIN, 20));
        inputArea.setBounds(50, 390, 480, 200);

        // Small title of the textArea (This label is then placed into the panel)
        toAdminLabel = new JLabel("Write your suggestion here");
        toAdminLabel.setForeground(Color.WHITE);
        toAdminLabel.setFont(new Font("Canva Sans", Font.PLAIN, 20));
        toAdminLabel.setBounds(10, 2, 440, 40);
        toAdminPanel = new JPanel();
        toAdminPanel.setBounds(50, 350, 480, 40);
        toAdminPanel.setBackground(new Color(180, 98, 152));
        toAdminPanel.setLayout(null);
        toAdminPanel.add(toAdminLabel);

        // Send button
        sendButton = new JButton("Send");
        sendButton.setBounds(310, 620, 150, 50);
        sendButton.setForeground(Color.WHITE);
        sendButton.setFont(new Font("Canva Sans", Font.BOLD, 20));
        sendButton.setBackground(new Color(254, 124, 151));
        sendButton.addActionListener(this);

        // Reset button
        resetButton = new JButton("Reset Text");
        resetButton.setBounds(100, 620, 150, 50);
        resetButton.setForeground(Color.WHITE);
        resetButton.setFont(new Font("Canva Sans", Font.BOLD, 20));
        resetButton.setBackground(new Color(254, 124, 151));
        resetButton.addActionListener(this);

        // Set up of the frame
        frame.add(bgLabel);
        frame.add(adminIconLabel);
        frame.add(adminLabel);
        frame.add(messageToUser);
        frame.add(toAdminPanel);
        frame.add(inputArea);
        frame.add(sendButton);
        frame.add(resetButton);
        frame.add(bottomRibbon);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(255, 251, 230));
        frame.setSize(600, 800);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    // List of event activated when the button is clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        /*
         * As sendButton is clicked
         * a. the text bring written inside the textArea is read
         * b. a userMessage.txt file is created in the Administrator Package
         * c. the text is then copy and paste into the userMessage.txt file
         */
        if (e.getSource() == sendButton) {
            fileName = "Text Files/messages.txt";
            ObjectInputStream is;
            try {
                is = new ObjectInputStream(new FileInputStream(fileName));

                try {
                    messageList = (ArrayList) is.readObject();
                    Message newMessage = new Message(this.username, inputArea.getText());
                    messageList.add(newMessage);
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

            try {
                ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName, false));
                os.writeObject(messageList);
                os.close();
                new MessageSentPage(username);
                frame.dispose();
            } catch (IOException e1) {
                System.out.println("IOException");
            }

        }

        // To clear the textArea
        if (e.getSource() == resetButton) {
            inputArea.setText("");
        }

        // Redirect user to the Home Page
        if (e.getSource() == homeButton) {
            new HomePage(username);
            frame.dispose();
        }

        // Redirect to Profile Page
        if (e.getSource() == profileButton) {
            new Profile(username);
            frame.dispose();
        }
    }
}
