package Administrator;

import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.*;
import Objects.Program;

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

    ArrayList<Program> programList = new ArrayList<Program>();
    String fileName = "Text Files/programs.txt";
  

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

        // ADD SERIALIZED INFO TO TEXT (TO REMOVE)
        // String program1Title = "Program 1: Use Public Transport";
        // String program1Desc = "Use Public Transport More Often";
        // String program2Title = "Program 2: Reduce Food Waste";
        // String program2Desc = "Reduce Food Waste by Composting";
        // String program3Title = "Program 3: Energy-Efficient Technology";
        // String program3Desc = "Use Energy-Efficient Technology Such As Solar Panels";
        // String program4Title = "Program 4: Plant Trees and Reforestation";
        // String program4Desc = "Participate in Tree Planting Activities Nearby";

        // Program program1 = new Program(program1Title, program1Desc);
        // Program program2 = new Program(program2Title, program2Desc);
        // Program program3 = new Program(program3Title, program3Desc);
        // Program program4 = new Program(program4Title, program4Desc);

        // ArrayList<Program> programListRead = new ArrayList<Program>();
        // programListRead.add(program1);
        // programListRead.add(program2);
        // programListRead.add(program3);
        // programListRead.add(program4);

        // try {
        //     ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName, false));
        //     os.writeObject(programListRead);
        //     os.close();
        //     System.out.println("done writing");
        // } catch (IOException e1){
        //     System.out.println("IOException");
        // }
        
// END TO REMOVE

            //Deserializing component
        
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


        // Set up all 4 program buttons using for loop
        for (int i = 0; i < programList.size(); i++)
        {
            programButton[i] = new JButton();
            programButton[i].setText(programList.get(i).getTitle());
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
        for(int i = 0; i < programList.size(); i++)
        {   
            if(e.getSource()==programButton[i])
            {   
                String title = JOptionPane.showInputDialog("Edit the program's title", programList.get(i).getTitle());
                String description = JOptionPane.showInputDialog("Edit the program's description", programList.get(i).getDescription());
                if (title == null || description == null || title.equals("") || description.equals("") ) {
                    JOptionPane.showMessageDialog(null, "Blank Entry Detected. No Changes Were Made");
                }else {
                    programList.get(i).setTitle(title);
                    programList.get(i).setDescription(description);
                    try {
                        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName, false));
                        os.writeObject(programList);
                        os.close();
                        System.out.println("done writing");
                        new EditProgramDesc();
                        frame.dispose();
                    } catch (IOException e1){
                        System.out.println("IOException");
                    }
                }
            }
        }
    }
}

