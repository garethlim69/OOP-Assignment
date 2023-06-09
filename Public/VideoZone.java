package Public;

import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.JOptionPane;
import Objects.Video;

public class VideoZone implements ActionListener {
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
    JPanel videoPanel = new JPanel();
    JButton[] videoButton = new JButton[30]; // The max amount of Quiz Section is 30
    ImageIcon videoIcon;
    ImageIcon searchIcon;
    JLabel searchIconLabel = new JLabel();
    JLabel videoIconLabel = new JLabel();
    JTextField searchBar;
    ImageIcon bgImage;
    JLabel bgLabel = new JLabel();
    JPanel videoSearchPanel = new JPanel();
    String thisUser = "";
    int search;

    ArrayList<Video> videoList = new ArrayList<Video>();
    String fileName = "Text Files/videos.txt";

    // Constructor
    // The username of current user is passed into this constructor
    public VideoZone(String currentUser) {
        thisUser = currentUser;

        // Top ribbon
        bgImage = new ImageIcon("Image/videoTR.png");
        bgLabel.setBounds(0, 0, 600, 140);
        Image image = bgImage.getImage().getScaledInstance(bgLabel.getWidth(), bgLabel.getHeight(), Image.SCALE_SMOOTH);
        bgImage = new ImageIcon(image);
        bgLabel.setIcon(bgImage);

        // Searching bar
        searchBar = new JTextField("What video you are looking for?");
        searchBar.setBounds(100, 170, 330, 60);
        searchBar.setFont(new Font("Canva Sans", Font.PLAIN, 20));

        // Search icon beside the serach bar
        searchButton = new JButton();
        searchButton.setFocusable(false);
        searchButton.setBounds(450, 170, 50, 50);
        searchButton.setOpaque(false);
        searchButton.setContentAreaFilled(false);
        searchButton.setBorderPainted(false);
        searchIcon = new ImageIcon("Image/searchIcon.png");
        Image imageSearch = searchIcon.getImage().getScaledInstance(searchButton.getWidth(), searchButton.getHeight(),
                Image.SCALE_SMOOTH);
        searchIcon = new ImageIcon(imageSearch);
        searchButton.setIcon(searchIcon);
        searchButton.addActionListener(this);

        ObjectInputStream is;
        try {
            is = new ObjectInputStream(new FileInputStream(fileName));

            try {
                videoList = (ArrayList) is.readObject();
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

        for (int i = 0; i < videoList.size(); i++) {
            videoButton[i] = new JButton();
            videoButton[i].setText(videoList.get(i).getTitle());
            videoButton[i].setBounds(0, 0, 50, 50);
            videoButton[i].setFont(new Font("Canva Sans", Font.BOLD, 30));
            videoButton[i].setBackground(new Color(40, 101, 132));
            videoButton[i].setFocusable(false);
            videoButton[i].setForeground(Color.WHITE);
            videoIcon = new ImageIcon("Image/videoIcon.png");
            Image imageVideo = videoIcon.getImage().getScaledInstance(videoButton[i].getWidth(), videoButton[i].getHeight(), Image.SCALE_SMOOTH);
            videoIcon = new ImageIcon(imageVideo);
            videoButton[i].setIcon(videoIcon);
            videoButton[i].addActionListener(this);
            videoPanel.add(videoButton[i]);
        }

        // Panel to hold all video buttons
        videoPanel.setBounds(90, 280, 400, 450);
        videoPanel.setBackground(new Color(255, 251, 230));
        videoPanel.setOpaque(true);
        videoPanel.setLayout(new GridLayout(5, 1, 30, 30));

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
        profileButton.addActionListener(this);

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
        bottomRibbon.add(profileButton);
        bottomRibbon.add(notifyButton);
        bottomRibbon.add(settingButton);

        // Set up of frame
        frame.add(bottomRibbon);
        frame.add(bgLabel);
        frame.add(searchBar);
        frame.add(searchButton);
        frame.add(videoPanel);
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
        if (e.getSource() == homeButton) {
            new HomePage(thisUser);
            frame.dispose();
        }
        if (e.getSource() == profileButton) {
            new Profile(thisUser);
            frame.dispose();
        }

        // Search Component
        if (e.getSource() == searchButton) {
            try {
                String keyword = searchBar.getText().toLowerCase();
                for (int i = 0; i < videoList.size(); i++) {
                    if (videoList.get(i).getTitle().toLowerCase().contains(keyword)) {
                        videoButton[i].setEnabled(true);
                    } else {
                        videoButton[i].setEnabled(false);
                    }
                }
            } catch (NumberFormatException e1) {
                JOptionPane.showMessageDialog(frame, "Invalid Input", "Error", JOptionPane.WARNING_MESSAGE);
            }
        }

        // Open URL of Video Clicked On
        for (int i = 0; i < videoList.size(); i++) {
            if (e.getSource() == videoButton[i]) {
                try {
                    Desktop.getDesktop().browse(new URI(videoList.get(i).getUrl()));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
                break;
            }
        }
    }
}
