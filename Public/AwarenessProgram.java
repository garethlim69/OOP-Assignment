package Public;

import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Objects;

import javax.swing.*;

import Objects.Program;

public class AwarenessProgram implements ActionListener
{
    // Declare all components needed to design frame
    JFrame frame = new JFrame();
    JPanel panel;
    JButton homeButton;
    JButton profileButton;
    JButton notifyButton;
    JButton settingButton;
    JButton[] programButton = new JButton[10];
    ImageIcon homeIcon;
    ImageIcon profileIcon;
    ImageIcon notifyIcon;
    ImageIcon settingIcon;
    ImageIcon transportIcon;
    ImageIcon foodIcon;
    ImageIcon electricIcon;
    ImageIcon treeIcon;
    JLabel imageLabel1 = new JLabel();
    JLabel imageLabel2 = new JLabel();
    JLabel imageLabel3 = new JLabel();
    JLabel imageLabel4 = new JLabel();
    JPanel bottomRibbon;
    JTextArea desc;
    ImageIcon bgImage;
    JLabel bgLabel = new JLabel();
    
    // Initialize of variable
    String thisUser = "";
    String programDetail;

    // The only option of the JOptionPanel
    String[] options = {"Join"};

    ArrayList<Program> programList = new ArrayList<Program>();
    String fileName = "Text Files/programs.txt";

    // Constructor 
    // The username of current user is passed into this constructor
    public AwarenessProgram(String currentUser)
    {
        thisUser = currentUser;

        // Top ribbon
        bgImage = new ImageIcon("Image/awareTR.png");
        bgLabel.setBounds(0, 0, 600, 190);
        Image image = bgImage.getImage().getScaledInstance(bgLabel.getWidth(),bgLabel.getHeight(), Image.SCALE_SMOOTH);
        bgImage = new ImageIcon(image);
        bgLabel.setIcon(bgImage);


        // Description of self-awareness program
        desc = new JTextArea("Reducing climate change starts at home. Here are some steps you can teke to do your part in saving the Earth!");
        desc.setLineWrap(true);
        desc.setWrapStyleWord(true);   
        desc.setFont(new Font("Arial",Font.PLAIN,18)); 
        desc.setDisabledTextColor(Color.black);
        desc.setBounds(90,160,400,70);
        desc.setEditable(false);
        desc.setEnabled(false);
        desc.setBackground(new Color(246,181,232));
        desc.setForeground(new Color(102,66,40));


        // Icons for the program activities
        transportIcon = new ImageIcon("Image/transportW.png");
        imageLabel1.setBounds(200,100,160,150);
        Image image1 = transportIcon.getImage().getScaledInstance(imageLabel1.getWidth(),imageLabel1.getHeight(), Image.SCALE_SMOOTH);
        transportIcon = new ImageIcon(image1);
        imageLabel1.setIcon(transportIcon);

        foodIcon = new ImageIcon("Image/foodW.png");
        imageLabel2.setBounds(200,100,160,150);
        Image image2 = foodIcon.getImage().getScaledInstance(imageLabel2.getWidth(),imageLabel2.getHeight(), Image.SCALE_SMOOTH);
        foodIcon = new ImageIcon(image2);
        imageLabel2.setIcon(foodIcon);

        electricIcon = new ImageIcon("Image/electricW.png");
        imageLabel3.setBounds(200,100,160,150);
        Image image3 = electricIcon.getImage().getScaledInstance(imageLabel3.getWidth(),imageLabel3.getHeight(), Image.SCALE_SMOOTH);
        electricIcon = new ImageIcon(image3);
        imageLabel3.setIcon(electricIcon);

        treeIcon = new ImageIcon("Image/treeW.png");
        imageLabel4.setBounds(200,100,160,150);
        Image image4 = treeIcon.getImage().getScaledInstance(imageLabel4.getWidth(),imageLabel4.getHeight(), Image.SCALE_SMOOTH);
        treeIcon = new ImageIcon(image4);
        imageLabel4.setIcon(treeIcon);

        // Panel to hold all the program images 
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(70, 230, 530, 400);
        panel.setBackground(new Color(255,251,230));
        panel.setOpaque(true);
        panel.setLayout(new GridLayout(2,2,10,15));
        panel.add(imageLabel1);
        panel.add(imageLabel2);
        panel.add(imageLabel3);
        panel.add(imageLabel4);

        ObjectInputStream is;
        try {
            is = new ObjectInputStream(new FileInputStream(fileName));
            try {
                programList = (ArrayList)is.readObject();
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

        for (int i = 0; i < programList.size(); i++)
        {
            programButton[i] = new JButton();
            programButton[i].setText(programList.get(i).getTitle());
            programButton[i].setFocusable(false);
            switch (i) {
                case 0:
                    programButton[i].setBounds(50, 390, 200, 40);
                    break;
                case 1:
                    programButton[i].setBounds(320, 390, 200, 40);
                    break;
                case 2:
                    programButton[i].setBounds(25, 610, 250, 40);
                    break;
                case 3:
                    programButton[i].setBounds(295, 610, 250, 40);
                    break;
            }
            programButton[i].setBackground(new Color(180,98,152));
            programButton[i].setForeground(Color.WHITE);
            programButton[i].setFont(new Font("Canva Sans",Font.BOLD,15));
            programButton[i].addActionListener(this);
            frame.add(programButton[i]);
        }

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
        frame.add(desc);
        frame.add(bgLabel);
        frame.add(bottomRibbon);
        frame.add(panel);
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

        // Direct to profile page
        if(e.getSource() == profileButton)
        {
            new Profile(thisUser);
            frame.dispose();
        }


        /*
        --- User will click on any program
        --- A JOptionPane which contains the program images and details will appear
        --- If the user clicks on the "Join" button, they can get award
         */
        for(int i = 0; i < programList.size(); i++)
        {   
            if(e.getSource()==programButton[i])
            {
                String imagePath = "";
                System.out.println(i);
                switch (i) {
                    case 0:
                        imagePath = "Image/transport.png";
                        break;
                    case 1:
                        imagePath = "Image/food.jpg";
                        break;
                    case 2:
                        imagePath = "Image/energy.jpg";
                        break;
                    case 3:
                        imagePath = "Image/plantTree.jpg";
                        break;
                }
                ImageIcon icon = new ImageIcon(imagePath);
                Image img = icon.getImage();
                Image image = img.getScaledInstance(400, 300, Image.SCALE_SMOOTH);
                ImageIcon newIcon = new ImageIcon(image);

                int answer = JOptionPane.showOptionDialog(
                    null,
                    programList.get(i).getDescription(),
                    programList.get(i).getTitle(),
                    JOptionPane.DEFAULT_OPTION,
                    0,
                    newIcon,
                    options,
                    options[0]);
                if(answer == 0){
                    JOptionPane.showMessageDialog(null, "Thank you for joining the program! You can redeem a prize in this app.", "Thank you for your support", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }
}
