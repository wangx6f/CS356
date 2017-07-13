package edu.cpp.cs356.assignment1;

import java.util.Set;

/**
 * Created by Xinyuan Wang on 6/30/2017.
 * This is an abstract class that represents a choice type question
 */
public abstract class AbstractChoiceQuestion implements Question{

    private String title;

    private Set<String> possibleChoices;

    private int numOfChoice;

    public AbstractChoiceQuestion(String title, Set<String> possibleChoices, int numOfChoice)
    {
        this.title = title;
        this.possibleChoices = possibleChoices;
        this.numOfChoice = numOfChoice;
    }


    @Override
    public Messager getNewMessager() {
            return new ChoiceMessager(possibleChoices,numOfChoice,title);
    }

    @Override
    public ReportPrinter getReportPrinter() {
        return new ChoiceReportPrinter(possibleChoices,title);
    }
}
