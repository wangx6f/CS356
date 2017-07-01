package edu.cpp.cs356.assignment1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Xinyuan Wang on 6/30/2017.
 */
public class ConsoleIVoteService implements IVoteService {

    private Question question;

    private ReportPrinter reportPrinter;

    private Map<String,Messager> submittedData;

    private static int latestID = 0;

    @Override
    public void configureQuestion(Question question) {
        this.question = question;
        this.reportPrinter = question.getReportPrinter();
        submittedData = new HashMap<>();
    }

    @Override
    public Student connectNewStudent() {

        String ID = getNextID();
        Student student = new SimulatedStudent(ID,question.getNewMessager(),this);
        return student;
    }

    @Override
    public void printReport() {
            reportPrinter.printReport(submittedData.values());
    }

    @Override
    public void getNewSubmission(String ID,Messager messager) {
        submittedData.put(ID,messager);
    }

    private String getNextID()
    {
        latestID++;
        return "SID"+String.format("%04d",latestID);
    }
}
