package edu.cpp.cs356.assignment1;

/**
 * Created by Xinyuan Wang on 6/30/2017.
 * This is the interface that represent the student user that could submit the answer
 * using {@link Messager}
 */
public interface Student {

    public String getID();

    public Messager getMessager();

    public void sendNewSubmission();
}
