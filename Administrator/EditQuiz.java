package Administrator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import Objects.Quiz;

public class EditQuiz {

    String fileName = "Text Files/quiz.txt";


    public EditQuiz(){
        
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

        //     // String q11 = "Which of the following is the main cause of global warming?";
        //     // String q12 ="Which of the following greenhouse gases is most responsible for trapping heat in the Earth's atmosphere?";
        //     // String q13 = "Which of the following actions can individuals take to reduce their carbon footprint?";
        //     // String q14 = "Which of the following is an effect of climate change on the world's oceans?";
        //     // String q15 = "Which of the following renewable energy sources has the potential to provide the most energy globally?";

        //     // String q21 = "Which sector contributes the most to global greenhouse gas emissions?";
        //     // String q22 = "What is the primary cause of sea level rise?";
        //     // String q23 = "Which of the following countries is currently the largest emitter of greenhouse gases?";
        //     // String q24 = "Which of the following is a potential consequence of global warming on agriculture?";
        //     // String q25 = "What is the main purpose of the Paris Agreement?";

        //     // String q31 = "Which of the following is a renewable energy source?";
        //     // String q32 = "What is the greenhouse gas that is released when livestock is raised for food production?";
        //     // String q33 = "Which of the following is an example of an extreme weather event?";
        //     // String q34 ="What is the name of the international treaty that aims to address climate change?";
        //     // String q35 = "What is the term used to describe the amount of carbon emissions produced by an individual, organization, or country?";

        //     // String q41 = "What is the process by which heat is trapped in the Earth's atmosphere and warms the planet?";
        //     // String q42 = "What is the process by which ice sheets and glaciers melt, contributing to sea level rise?";
        //     // String q43 = "What is the term used to describe the release of greenhouse gases from human activities, such as burning fossil fuels?";
        //     // String q44 = "Which of the following actions can help reduce carbon emissions from transportation?";
        //     // String q45 = "What is the term used to describe the long-term average of weather patterns in a particular area?";

        //     // String q51 = "Which of the following is a major contributor to deforestation?";
        //     // String q52 = "Which of the following is a key consequence of climate change on the world's oceans?";
        //     // String q53 = "What is the term used to describe the process of capturing and storing carbon emissions to prevent them from entering the atmosphere?";
        //     // String q54 = "Which of the following is a natural sink for carbon dioxide?";
        //     // String q55 = "What is the term used to describe the natural process by which greenhouse gases trap heat in the Earth's atmosphere?";

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
        // ArrayList<Quiz> quizRead = new ArrayList<Quiz>();
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
        //                 quizRead.add(quiz);
        //                 flag ++;
        //                 if (flag == 5) {
        //                     flag = 0;
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

