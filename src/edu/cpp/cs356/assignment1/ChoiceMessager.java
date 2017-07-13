package edu.cpp.cs356.assignment1;

import java.util.Set;

/**
 * Created by Xinyuan Wang on 6/30/2017.
 * This a Messager that used for {@link Student} to send answer regarding {@link AbstractChoiceQuestion}
 * When the message is being written, the data will be checked by rules that defined by {@link Question}
 * The info could be read by {@link ChoiceReportPrinter}
 */
public class ChoiceMessager implements Messager {

    private Set<String> possibleChoices;

    private int numOfChoice;

    private Set<String> answer;

    private String title;

    public ChoiceMessager(Set<String> possibleChoices, int numOfChoice,String title)
    {
        this.possibleChoices = possibleChoices;
        this.numOfChoice = numOfChoice;
        this.title = title;
    }

    public Set<String> getPossibleChoices()
    {
        return possibleChoices;
    }

    private boolean validateAnswer(Set<String> answer)
    {
        if(answer.size()<=numOfChoice) {
          return possibleChoices.containsAll(answer);
        }
        else {
            return false;
        }
    }

    @Override
    public boolean setMessage(Set<String> answer)
    {
        if(validateAnswer(answer))
        {
            this.answer = answer;
            return true;
        }
        else
            return false;

    }

    @Override
    public Set<String> getMessage()
    {
        return answer;
    }

}
