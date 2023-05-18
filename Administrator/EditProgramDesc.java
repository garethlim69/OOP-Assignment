package Administrator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EditProgramDesc implements ActionListener
{
    // Declare all components needed to design frame
    JFrame frame = new JFrame();
    JLabel title;
    JPanel topRibbon;
    JButton homeButton;
    JButton notifyButton;
    JButton settingButton;
    ImageIcon homeIcon;
    ImageIcon notifyIcon;
    ImageIcon settingIcon;
    JPanel bottomRibbon;
    JPanel programPanel = new JPanel();
    JButton[] programButton = new JButton[10];
    JTextField searchBar;

  

    // Constructor 
    public EditProgramDesc()
    {

        // Top ribbon
        topRibbon = new JPanel();
        topRibbon.setBounds(0, 0, 600, 150);
        topRibbon.setBackground(new Color(248,207,137));


        // Title 
        title = new JLabel("Edit Program Description");
        title.setBounds(60, 20, 500, 100);
        title.setFont(new Font("Canva Sans",Font.BOLD,40));
        title.setForeground(Color.BLACK);


        // All programs button
        // Set up all 4 program buttons using for loop
        for (int i=1 ; i<=4 ; i++)
        {
            programButton[i] = new JButton();

            switch(i){
                case 1: programButton[1].setText("Program 1: Use Public Transport");
                        break;
                case 2: programButton[2].setText("Program 2: Reduce Food Waste");
                        break;
                case 3: programButton[3].setText("Program 3: Energy-Efficient Technology");
                        break;
                case 4: programButton[4].setText("Program 4: Plant Trees and Reforestation");
                        break;
            }

            programButton[i].setBounds(0, 0, 50, 50);
            programButton[i].setFont(new Font("Canva Sans", Font.BOLD,20));
            programButton[i].setBackground(new Color(241,171,80));
            programButton[i].setFocusable(false);
            programButton[i].setForeground(Color.WHITE);

            programButton[i].addActionListener(this);

            programPanel.add(programButton[i]);
        }


        // Panel to hold all program buttons
        programPanel.setLayout(null);
        programPanel.setBounds(60, 200, 480, 450);
        programPanel.setBackground(new Color(255,251,230));
        programPanel.setOpaque(true);
        programPanel.setLayout(new GridLayout(5,1,30,30));
        

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
        bottomRibbon.add(notifyButton);
        bottomRibbon.add(settingButton);

        // Set up of frame
        frame.add(bottomRibbon);
        frame.add(title);
        frame.add(topRibbon);
        frame.add(programPanel);
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
        // Redirect to admin home page
        if(e.getSource() == homeButton)
        {
            new A_HomePage();
            frame.dispose();
        }


        // To edit program detail
        for(int i =1 ; i<= 4 ; i++)
        {
            if(e.getSource()==programButton[i])
            {
                switch(i)
                {
                    // To edit the program detaial, the method "setDetail()" is called from class ProgramDesc
                    case 1:
                        ProgramDesc p1 = new ProgramDesc();
                        p1.setDetail(1);
                        break;
                    
                    case 2:
                        ProgramDesc p2 = new ProgramDesc();
                        p2.setDetail(2);
                        break;
                    
                    case 3:
                        ProgramDesc p3 = new ProgramDesc();
                        p3.setDetail(3);
                        break;
                    
                    case 4:
                        ProgramDesc p4 = new ProgramDesc();
                        p4.setDetail(4);
                        break;
                        
                }
            }
        }
    }
}

