package Administrator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import javax.sound.sampled.SourceDataLine;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Objects.Quiz;

public class EditQuizPage implements ActionListener {

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
    JButton[] quizButton = new JButton[30];  // The max amount of Quiz Section is 30
    JLabel questionIconLabel = new JLabel();

    String fileName = "Text Files/quiz.txt";
    ArrayList<ArrayList<Quiz>> quizList = new ArrayList<ArrayList<Quiz>>();


    public EditQuizPage() {


        // Top ribbon
        topRibbon = new JPanel();
        topRibbon.setBounds(0, 0, 600, 150);
        topRibbon.setBackground(new Color(248,207,137));

        // Title 
        title = new JLabel("Edit Quiz");
        title.setBounds(210, 20, 400, 100);
        title.setFont(new Font("Canva Sans",Font.BOLD,40));
        title.setForeground(Color.BLACK);

        ObjectInputStream is;
        try {
            is = new ObjectInputStream(new FileInputStream(fileName));
            try {
                quizList = (ArrayList)is.readObject();
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


        // Set up of Quiz Icon and Button (Only 5 Quiz section available currently)
        for (int i=1 ; i<=5 ; i++)
        {
            quizButton[i] = new JButton(" Quiz " + i);

            quizButton[i].setBounds(0, 0, 50, 50);
            quizButton[i].setFont(new Font("Canva Sans", Font.BOLD,30));
            quizButton[i].setBackground(new Color(241,171,80));
            quizButton[i].setFocusable(false);
            quizButton[i].setForeground(Color.WHITE);

            quizButton[i].addActionListener(this);

            quizPanel.add(quizButton[i]);
        }
        // Quiz Panel  
        quizPanel.setLayout(null);
        quizPanel.setBounds(60, 200, 480, 450);
        quizPanel.setBackground(new Color(255,251,230));
        quizPanel.setOpaque(true);
        quizPanel.setLayout(new GridLayout(5,1,30,30));
        
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
        frame.add(quizPanel);
        frame.add(topRibbon);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(255,251,230));
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
        if(e.getSource() == homeButton)
        {
            new A_HomePage();
            frame.dispose();
        }


        for (int i = 1; i <= quizList.size(); i++) {
            
            if (e.getSource() == quizButton[i]) {
                new EditQuiz(quizList, i);
                frame.dispose();
            }

        }


    }


    public void Serialize(){
        
        // String[][] questions = 
        // {
        //     {
        // 		"Which of the following is the main cause of global warming?",
        //     	"Which of the following greenhouse gases is most responsible for trapping heat in the Earth's atmosphere?",
        //     	"Which of the following actions can individuals take to reduce their carbon footprint?",
        //     	"Which of the following is an effect of climate change on the world's oceans?",
        //     	"Which of the following renewable energy sources has the potential to provide the most energy globally?"
        // 	},
        // 	{
        // 		"Which sector contributes the most to global greenhouse gas emissions?",
        // 		"What is the primary cause of sea level rise?",
        // 		"Which of the following countries is currently the largest emitter of greenhouse gases?",
        // 		"Which of the following is a potential consequence of global warming on agriculture?",
        // 		"What is the main purpose of the Paris Agreement?"
        // 	},
        // 	{
        // 		"Which of the following is a renewable energy source?",
        // 		"What is the greenhouse gas that is released when livestock is raised for food production?",
        // 		"Which of the following is an example of an extreme weather event?",
        // 		"What is the name of the international treaty that aims to address climate change?",
        // 		"What is the term used to describe the amount of carbon emissions produced by an individual, organization, or country?"
        // 	},
        // 	{
        // 		"What is the process by which heat is trapped in the Earth's atmosphere and warms the planet?",
        // 		"What is the process by which ice sheets and glaciers melt, contributing to sea level rise?",
        // 		"What is the term used to describe the release of greenhouse gases from human activities, such as burning fossil fuels?",
        // 		"Which of the following actions can help reduce carbon emissions from transportation?",
        // 		"What is the term used to describe the long-term average of weather patterns in a particular area?"
        // 	},
        // 	{
        // 		"Which of the following is a major contributor to deforestation?",
        // 		"Which of the following is a key consequence of climate change on the world's oceans?",
        // 		"What is the term used to describe the process of capturing and storing carbon emissions to prevent them from entering the atmosphere?",
        // 		"Which of the following is a natural sink for carbon dioxide?",
        // 		"What is the term used to describe the natural process by which greenhouse gases trap heat in the Earth's atmosphere?"
        // 	}
        // };

        // String[][][] options = 
        // {
        //     {
        // 		{"Deforestation","Burning of fossil fuels","Natural climate cycles"},
        //     	{"Carbon dioxide","Methane","Water vapor"},
        //     	{"Recycling","Waste more energy","Waste food"},
        //     	{"Ocean acidification","Rising sea levels","Increased frequency of hurricanes"},
        //     	{"Wind power","Solar power","Hydroelectric power"}
        // 	},
        // 	{
        // 		{"Agriculture","Transportation","Energy"},
        // 		{"Melting of glaciers and ice caps","Thermal expansions of ocean water","Increased rainfall and runoff"},
        // 		{"China","United States","India"},
        // 		{"Increased crop yields","Decreased soil erosion","Crop failures"},
        // 		{"To reduce greenhouse gas emissions","To promote economic development","To regulate international trade"}
        // 	},
        // 	{
        // 		{"Coal","Oil","Solar"},
        // 		{"Carbon dioxide","Methane","Nitrous oxide"},
        // 		{"A sunny day","A hurricane","A light rain shower"},
        // 		{"The Paris Agreement","The Kyoto Protocol","The Montreal Protocol"},
        // 		{"Carbon capture","Carbon offset","Carbon footprint"}
        // 	},
        // 	{
        // 		{"Global cooling","Global warming","Climate stabilization"},
        // 		{"Ocean acidification","Permafrost thawing","Glacial melting"},
        // 		{"Anthropogenic emissions","Natural emissions","Non-anthropogenic emissions"},
        // 		{"Walking instead of driving","Driving an electric car","Flying frequently for travel"},
        // 		{"Climate","Weather","Temperature"}
        // 	},
        // 	{
        // 		{"Planting new trees","Building new infrastructure","Clearing land for agriculture"},
        // 		{"Increased fish populations","Increased ocean acidity","Decreased sea surface temperatures"},
        // 		{"Carbon capture and storage","Carbon offsetting","Carbon footprinting"},
        // 		{"Oceans","Fossil fuels","Deforested land"},
        // 		{"Climate adaptation","Climate mitigation","The greenhouse effect"}
        // 	}
        // };

        // int[][] answers = 	
        // {
        //     {2,3,1,1,2},
        // 	{3,2,1,3,1},
        // 	{3,2,2,1,3},
        // 	{2,3,1,1,1},
        // 	{3,2,1,1,3}
        // };

        // int flag = 0;
        // int flag2 = 0;
        // int flag3 = 0;
        // int flag4 = 0;
        // String answer1 = null;
        // String answer2 = null;
        // String answer3 = null;
        // int correctAnswer = 0;
        // ArrayList<Quiz> quizListByCat = new ArrayList<Quiz>();
        // ArrayList<ArrayList<Quiz>> quizRead = new ArrayList<ArrayList<Quiz>>();
        // for (int i = 0; i < questions.length; i++) {
        //     for (int i2 = 0; i2 < questions[i].length; i2++) {
        //         String question = questions[i][i2];
        //         for (int j = 0; j < options.length; j++) {
        //             for (int j2 = 0; j2 < options[j].length; j2++) {
        //                 for (int j3 = 0; j3 < options[j][j2].length; j3++) {
        //                     answer1 = options[flag2][flag][0];
        //                     answer2 = options[flag2][flag][1];
        //                     answer3 = options[flag2][flag][2];
        //                 }
        //                 for (int k = 0; k < answers.length; k++) {
        //                     for (int k2 = 0; k2 < answers[k].length; k2++) {
        //                         correctAnswer = answers[flag4][flag3];
        //                         flag3 ++;
        //                         if (flag3 == 5) {
        //                             flag3 = 0;
        //                         }
        //                         break;
        //                     }
        //                     break;
                            
        //                 }
        //                 Quiz quiz = new Quiz(question, answer1, answer2, answer3, correctAnswer);
        //                 quizListByCat.add(quiz);
        //                 flag ++;
        //                 if (flag == 5) {
        //                     quizRead.add(new ArrayList<Quiz>(quizListByCat)); 
        //                     flag = 0;
        //                     quizListByCat.clear();
        //                 }
        //                 break;
        //             }
        //             break;
        //         }
        //     }
        //     flag2 ++;
        //     flag4 ++;
        // }

        // try {
        //     ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName, false));
        //     os.writeObject(quizRead);
        //     os.close();
        //     System.out.println("done writing");
        // } catch (IOException e1){
        //     System.out.println("IOException");
        // }


    }
   


}    

