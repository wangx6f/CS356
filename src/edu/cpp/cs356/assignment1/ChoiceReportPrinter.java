package edu.cpp.cs356.assignment1;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Xinyuan Wang on 7/1/2017.
 * This class is for print the report regarding of {@link AbstractChoiceQuestion} and will
 * read data compose of {@link ChoiceMessager}
 */
public class ChoiceReportPrinter implements ReportPrinter {


    private String title;

    private Map<String,Integer> report;

    private Set<String> possibleChoice;


    public ChoiceReportPrinter(Set<String> possibleChoice, String title)
    {
            this.possibleChoice = possibleChoice;
            this.title = title;
    }

    @Override
    public void printReport(Collection<Messager> data) {
        initReport();
        dataProcess(data);
        System.out.println("----Report----");
        System.out.println("Question:"+title);
        for(Map.Entry<String,Integer> entry: report.entrySet())
        {
                System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }

    private void initReport()
    {
        report = new HashMap<>();
        for(String choice:possibleChoice)
        {
            report.put(choice,0);
        }
    }

    private void dataProcess(Collection<Messager> data)
    {

        for(Messager entry:data)
        {
            Set<String> answer = entry.getMessage();
            if(answer!=null)
            {
                for(String singleAnswer: answer)
                {
                    report.put(singleAnswer,report.get(singleAnswer)+1);
                }
            }
        }
    }
}
