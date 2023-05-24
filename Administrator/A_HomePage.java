/*
              This Home Page is not well-designed yet
              It only consists of the main buttons to direct us to other important page
 */


 package Administrator;

 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;
 
 import Public.LoginPage;
 
 
 public class A_HomePage implements ActionListener
 {
     // Declare all components needed to design the frame
     JFrame frame = new JFrame();
     JLabel title;
     JButton seeInboxButton;
     JButton loginButton;
     JButton editProgramButton;
     JButton editArticleButton;
     JButton editVideoButton;
     JButton homeButton;
     JButton notifyButton;
     JButton settingButton;
     JPanel panel;
     JPanel topRibbon;
     JPanel bottomRibbon;
     ImageIcon homeIcon;
     ImageIcon notifyIcon;
     ImageIcon settingIcon;
 
 
 
     //Constructor 
     public A_HomePage()
     {
         // Top ribbon
         topRibbon = new JPanel();
         topRibbon.setBounds(0, 1, 600, 200);
         topRibbon.setBackground(new Color(40,101,132));
 
         // Title 
         title = new JLabel("Administrator Site");
         title.setBounds(110, 50, 400, 100);
         title.setFont(new Font("Canva Sans",Font.BOLD,45));
         title.setForeground(Color.BLACK);
 
         // See User Suggestion Button
         seeInboxButton = new JButton("Inbox");
         seeInboxButton.setBounds(300, 500, 200, 200);
         seeInboxButton.setFont(new Font("Canva Sans",Font.BOLD,35));
         seeInboxButton.setFocusable(false);
         seeInboxButton.setForeground(Color.WHITE);
         seeInboxButton.setBackground(new Color(67,125,178));
         seeInboxButton.addActionListener(this);
 
 
         // Return to login page
         loginButton = new JButton("Login Page");
         loginButton.setBounds(300, 100, 200, 200);
         loginButton.setFont(new Font("Canva Sans",Font.BOLD,35));
         loginButton.setFocusable(false);
         loginButton.setBackground(new Color(67,125,178));
         loginButton.setForeground(Color.WHITE);
         loginButton.addActionListener(this);
 
 
         // Edit self-awareness program details
         editProgramButton = new JButton("Edit Program");
         editProgramButton.setBounds(300, 100, 200, 200);
         editProgramButton.setFont(new Font("Canva Sans",Font.BOLD,35));
         editProgramButton.setFocusable(false);
         editProgramButton.setBackground(new Color(67,125,178));
         editProgramButton.setForeground(Color.WHITE);
         editProgramButton.addActionListener(this);
 
         // Edit Article Button
         editArticleButton = new JButton("Edit Article");
         editArticleButton.setBounds(300, 500, 200, 200);
         editArticleButton.setFont(new Font("Canva Sans",Font.BOLD,35));
         editArticleButton.setFocusable(false);
         editArticleButton.setBackground(new Color(67,125,178));
         editArticleButton.setForeground(Color.WHITE);
         editArticleButton.addActionListener(this);

         // Edit Video Button
         editVideoButton = new JButton("Edit Video");
         editVideoButton.setBounds(300, 500, 200, 200);
         editVideoButton.setFont(new Font("Canva Sans",Font.BOLD,35));
         editVideoButton.setFocusable(false);
         editVideoButton.setBackground(new Color(67,125,178));
         editVideoButton.setForeground(Color.WHITE);
         editVideoButton.addActionListener(this);
 
         // Panel to hold all buttons
         panel = new JPanel();
         panel.setBounds(70, 280, 450, 300);
         panel.setBackground(new Color(255,251,230));
         panel.setOpaque(true);
         panel.setLayout(new GridLayout(4,1,10,40));
         panel.add(loginButton);
         panel.add(seeInboxButton);
         panel.add(editProgramButton);
         panel.add(editArticleButton);
 
         // Buttons on bottom panel
         homeButton = new JButton();
         homeButton.setFocusable(false);
         homeButton.setBounds(10, 10, 50, 50);
         homeButton.setOpaque(false);
         homeButton.setContentAreaFilled(false);
         homeButton.setBorderPainted(false);
         homeButton.addActionListener(this);
         homeIcon = new ImageIcon("Image/homeIcon.png");
         Image imageHome = homeIcon.getImage().getScaledInstance(homeButton.getWidth(),homeButton.getHeight(), Image.SCALE_SMOOTH);
         homeIcon = new ImageIcon(imageHome);
         homeButton.setIcon(homeIcon);
 
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
         settingButton.addActionListener(this);
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
 
 
         // Set up of the frame
         frame.add(title);
         frame.add(topRibbon);
         frame.add(panel);
         frame.add(bottomRibbon);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.getContentPane().setBackground(new Color(255,255,238));
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
         // By clicking this button, the admin will direct to Inbox Page to view the user's message
         if (e.getSource() == seeInboxButton)
         {
             new InboxPage();
             frame.dispose();
         }
 
         // Redirect to the login page
         if(e.getSource() == loginButton)
         {
             new LoginPage(null);
             frame.dispose();
         }
 
         // To edit self-awareness program
         if(e.getSource() == editProgramButton)
         {
             new EditProgramDesc();
             frame.dispose();
         }
         
         if(e.getSource() == editArticleButton)
         {
            new EditArticle();
            frame.dispose();
         }

         if(e.getSource() == editVideoButton)
         {
            new EditVideo();
            frame.dispose();
         }
     }
 }
 
