package edu.cpp.cs356.assignment2;

import java.util.Observer;

/**
 * Created by Xinyuan Wang on 7/9/2017.
 */
public interface Server {

    public void addComponent(Component newComponent,Component parentComponent) throws ServerException;

    public Component getRoot();

    public void postTextTweet(String userID,String text);

    public void attachObserverToUser (String ID,Observer observer);

    public void detachObserverFromUser(String ID,Observer observer);

    public void follow(String followerID,String followingTarget);

}
