package Public;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Administrator.ProgramDesc;

public class AwarenessProgram implements ActionListener
{
    // Declare all components needed to design frame
    JFrame frame = new JFrame();
    JPanel panel;
    JButton homeButton;
    JButton profileButton;
    JButton notifyButton;
    JButton settingButton;
    JButton transportButton;
    JButton foodButton;
    JButton treeButton;
    JButton electricButton;
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
        desc.setBounds(90,160,400,70);
        desc.setEditable(false);
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


        // All 4 buttons of each program
        transportButton = new JButton("Public Transport");
		transportButton.setFocusable(false);
        transportButton.setBounds(70, 390, 160, 40);
        transportButton.setBackground(new Color(180,98,152));
        transportButton.setForeground(Color.WHITE);
        transportButton.setFont(new Font("Canva Sans",Font.BOLD,15));
		transportButton.addActionListener(this);

        foodButton = new JButton("Food Waste");
		foodButton.setFocusable(false);
        foodButton.setBounds(340, 390, 160, 40);
        foodButton.setBackground(new Color(180,98,152));
        foodButton.setForeground(Color.WHITE);
        foodButton.setFont(new Font("Canva Sans",Font.BOLD,15));
		foodButton.addActionListener(this);

        electricButton = new JButton("Save Energy");
		electricButton.setFocusable(false);
        electricButton.setBounds(70, 610, 160, 40);
        electricButton.setBackground(new Color(180,98,152));
        electricButton.setForeground(Color.WHITE);
        electricButton.setFont(new Font("Canva Sans",Font.BOLD,15));
		electricButton.addActionListener(this);

        treeButton = new JButton("Plant Trees");
		treeButton.setFocusable(false);
        treeButton.setBounds(340, 610, 160, 40);
        treeButton.setBackground(new Color(180,98,152));
        treeButton.setForeground(Color.WHITE);
        treeButton.setFont(new Font("Canva Sans",Font.BOLD,15));
		treeButton.addActionListener(this);
        

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
        frame.add(transportButton);
        frame.add(foodButton);
        frame.add(electricButton);
        frame.add(treeButton);
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
        if(e.getSource() == transportButton)
        {
            ProgramDesc program1 = new ProgramDesc();
            programDetail = program1.getPublicTransportDesc();

            ImageIcon icon = new ImageIcon("Image/transport.png");
            Image img = icon.getImage();
            Image image = img.getScaledInstance(400, 300, Image.SCALE_SMOOTH);
            ImageIcon newIcon = new ImageIcon(image);

            int answer = JOptionPane.showOptionDialog(null,
                                        programDetail,
                                        "Use Public Transport",
                                        JOptionPane.DEFAULT_OPTION,
                                        0,
                                        newIcon,
                                        options,
                                        options[0]);
            
            if(answer == 0){
                JOptionPane.showMessageDialog(null, "Thank you for joining the program! You can redeem a prize in this app.", "Thank you for your support", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        if(e.getSource() == foodButton)
        {
            ProgramDesc program2 = new ProgramDesc();
            programDetail = program2.getFoodWasteDesc();

            ImageIcon icon = new ImageIcon("Image/food.jpg");
            Image img = icon.getImage();
            Image image = img.getScaledInstance(400, 300, Image.SCALE_SMOOTH);
            ImageIcon newIcon = new ImageIcon(image);

            int answer = JOptionPane.showOptionDialog(null,
                                        programDetail,
                                        "Reduce food waste",
                                        JOptionPane.DEFAULT_OPTION,
                                        0,
                                        newIcon,
                                        options,
                                        options[0]);
            
            if(answer == 0){
                JOptionPane.showMessageDialog(null, "Thank you for joining the program! You can redeem a prize in this app.", "Thank you for your support", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        if(e.getSource() == electricButton)
        {
            ProgramDesc program3 = new ProgramDesc();
            programDetail = program3.getEnergyDesc();

            ImageIcon icon = new ImageIcon("Image/energy.jpg");
            Image img = icon.getImage();
            Image image = img.getScaledInstance(400, 300, Image.SCALE_SMOOTH);
            ImageIcon newIcon = new ImageIcon(image);

            int answer = JOptionPane.showOptionDialog(null,
                                        programDetail,
                                        "Energy-Efficient Technology",
                                        JOptionPane.DEFAULT_OPTION,
                                        0,
                                        newIcon,
                                        options,
                                        options[0]);
            
            if(answer == 0){
                JOptionPane.showMessageDialog(null, "Thank you for joining the program! You can redeem a prize in this app.", "Thank you for your support", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        if(e.getSource() == treeButton)
        {
            ProgramDesc program4 = new ProgramDesc();
            programDetail = program4.getPlantTreeDesc();

            ImageIcon icon = new ImageIcon("Image/plantTree.jpg");
            Image img = icon.getImage();
            Image image = img.getScaledInstance(400, 300, Image.SCALE_SMOOTH);
            ImageIcon newIcon = new ImageIcon(image);

            int answer = JOptionPane.showOptionDialog(null,
                                        programDetail,
                                        "Plant Trees and Reforestation",
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
