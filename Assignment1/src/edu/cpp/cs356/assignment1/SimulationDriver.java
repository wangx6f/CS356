package edu.cpp.cs356.assignment1;

import java.util.*;

/**
 * Created by Xinyuan Wang on 7/1/2017.
 */
public class SimulationDriver {

    public static void main(String[] args)
    {
        new SimulationDriver().run();
    }

    private IVoteService iVoteService;



    public void run(){
        iVoteService = new ConsoleIVoteService();
        generateQuestion();
        iVoteService.configureQuestion(generateQuestion());
        generateStudent();
        iVoteService.printReport();
    }

    private Question generateQuestion()
    {
        String[] choice = new String[] {"A","B","C","D","E"};
        String title = "What is your grade?";
        return new SingleChoiceQuestion(title,new HashSet<>((Arrays.asList(choice))));
        //return new MultipleChoiceQuestion(title,new HashSet<>((Arrays.asList(choice))));

    }

    private void generateStudent()
    {
        int studentNum = new Random().nextInt(20)+1;
        for(int i=0;i<studentNum;i++)
        {
            Student newStudent = iVoteService.connectNewStudent();
            generateAnswer(newStudent);
            generateAnswer(newStudent);
            newStudent.sendNewSubmission();

        }
    }

    private void generateAnswer(Student student)
    {
        ChoiceMessager messager = (ChoiceMessager) student.getMessager();
        Set possibleChoice = messager.getPossibleChoices();
        Set<String> randomAnswer = new HashSet<>();
        List<String> temp = new ArrayList<>(possibleChoice);
        Collections.shuffle(temp);
        randomAnswer.addAll(temp.subList(0,new Random().nextInt(temp.size())));
        boolean valid = messager.setMessage(randomAnswer);

        String isValid = valid? "valid":"invalid";
        System.out.println("Student "+student.getID()+" answers "+randomAnswer+" "+isValid);

    }


}
