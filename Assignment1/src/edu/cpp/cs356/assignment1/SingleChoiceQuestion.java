package edu.cpp.cs356.assignment1;

import java.util.Set;

/**
 * Created by Xinyuan Wang on 6/30/2017.
 */
public class SingleChoiceQuestion extends AbstractChoiceQuestion {
    public SingleChoiceQuestion(String title, Set<String> possibleChoices) {
        super("(single choice) "+title, possibleChoices, 1);
    }
}
