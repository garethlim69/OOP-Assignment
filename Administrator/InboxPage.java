package Administrator;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

import Objects.Message;

public class InboxPage implements ActionListener {
    // Declare of all components needed to design the frame
    JFrame frame = new JFrame();
    JTextArea displayedMessage;
    ImageIcon bgImage;
    JLabel bgLabel = new JLabel();
    JLabel title;
    JLabel fromUserLabel;
    JPanel fromUserPanel;
    ImageIcon returnIcon;
    JButton homeButton;
    JButton notifyButton;
    JButton settingButton;
    ImageIcon homeIcon;
    ImageIcon notifyIcon;
    ImageIcon settingIcon;
    JPanel bottomRibbon;

    ArrayList<Message> messageList = new ArrayList<Message>();

    // Constructor
    public InboxPage() {
        // Background image
        bgImage = new ImageIcon("Image/green.jpg");
        bgLabel.setBounds(0, 0, 600, 120);
        Image image = bgImage.getImage().getScaledInstance(bgLabel.getWidth(), bgLabel.getHeight(), Image.SCALE_SMOOTH);
        bgImage = new ImageIcon(image);
        bgLabel.setIcon(bgImage);

        // Title of Inbox Page
        title = new JLabel("Inbox");
        title.setBounds(220, 20, 400, 100);
        title.setFont(new Font("Canva Sans", Font.BOLD, 50));
        title.setForeground(Color.BLACK);

        // Set up the title of the textArea (the label is then put inside the panel)
        fromUserLabel = new JLabel("User Suggestion");
        fromUserLabel.setForeground(Color.WHITE);
        fromUserLabel.setFont(new Font("Canva Sans", Font.BOLD, 30));
        fromUserLabel.setBounds(100, 10, 440, 40);

        fromUserPanel = new JPanel();
        fromUserPanel.setBounds(50, 170, 480, 60);
        fromUserPanel.setBackground(new Color(64, 99, 70));
        fromUserPanel.setLayout(null);
        fromUserPanel.add(fromUserLabel);

        // Display user message in the JTextArea
        JScrollPane scroll = new JScrollPane(displayedMessage, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        frame.add(scroll);
        displayedMessage = new JTextArea();
        displayedMessage.setLineWrap(true);
        displayedMessage.setWrapStyleWord(true);
        displayedMessage.setFont(new Font("Arial", Font.PLAIN, 30));
        displayedMessage.setBounds(50, 230, 480, 450);
        displayedMessage.setEditable(false);
        displayedMessage.setEnabled(false);
        displayedMessage.setDisabledTextColor(Color.black);

        String fileName = "Text Files/messages.txt";
        // ADD SERIALIZED INFO TO TEXT (TO REMOVE)
        // String message1Username = "user 1";
        // String message1Message = "hello";
        // String message2Username = "user 2";
        // String message2Message = "hi";

        // Message message1 = new Message(message1Username, message1Message);
        // Message message2 = new Message(message2Username, message2Message);

        // ArrayList<Message> articleListRead = new ArrayList<Message>();
        // articleListRead.add(message1);
        // articleListRead.add(message2);
        // System.out.println("article list before printing: " + articleListRead);

        // try {
        // ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName,
        // false));
        // os.writeObject(articleListRead);
        // os.close();
        // System.out.println("done writing");
        // } catch (IOException e1){
        // System.out.println("IOException");
        // }

        // END TO REMOVE

        // Deserialize Content of messages.txt
        ObjectInputStream is;
        try {
            is = new ObjectInputStream(new FileInputStream(fileName));
            try {
                messageList = (ArrayList) is.readObject();
                StringBuilder sb = new StringBuilder();
                // For Loop to Take the 4 Latest Messages
                for (int i = (messageList.size() - 1); i > messageList.size() - 5; i--) {
                    sb.append("Message: " + messageList.get(i).getMessage() + "\nUser: "
                            + messageList.get(i).getUsername() + "\n\n");
                }
                displayedMessage.setText(sb.toString());
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

        // Set up of the frame
        frame.add(bottomRibbon);
        frame.add(title);
        frame.add(bgLabel);
        frame.add(displayedMessage);
        frame.add(fromUserPanel);
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
        // Return to Admin Home Page
        if (e.getSource() == homeButton) {
            new A_HomePage();
            frame.dispose();
        }
    }
}
