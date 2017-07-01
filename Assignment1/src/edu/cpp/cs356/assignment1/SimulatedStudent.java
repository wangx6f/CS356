package edu.cpp.cs356.assignment1;

/**
 * Created by Xinyuan Wang on 6/30/2017.
 */
public class SimulatedStudent implements Student {

    private String ID;

    private Messager messager;

    private IVoteService service;

    public SimulatedStudent(String ID,Messager messager,IVoteService service)
    {
        this.ID = ID;
        this.messager = messager;
        this.service = service;
    }

    @Override
    public String getID() {
        return ID;
    }

    @Override
    public Messager getMessager() {
        return this.messager;
    }

    @Override
    public void sendNewSubmission() {
        service.getNewSubmission(ID,messager);
    }
}
