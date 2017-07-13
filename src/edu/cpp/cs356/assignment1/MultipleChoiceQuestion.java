package edu.cpp.cs356.assignment1;

import java.util.Set;

/**
 * Created by Xinyuan Wang on 6/30/2017.
 */
public class MultipleChoiceQuestion extends AbstractChoiceQuestion {

    public MultipleChoiceQuestion(String title, Set<String> possibleChoices) {
        super("(multiple choice) "+title, possibleChoices,possibleChoices.size());
    }
}
