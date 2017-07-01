package edu.cpp.cs356.assignment1;

/**
 * Created by Xinyuan Wang on 6/30/2017.
 */
public interface IVoteService {

    public void configureQuestion(Question question);

    public Student connectNewStudent();

    public void printReport();

    public void getNewSubmission(String ID,Messager messager);
}
