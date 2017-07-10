package edu.cpp.cs356.assignment2;
import java.util.HashMap;
import java.util.Map;
import java.util.Observer;

/**
 * Created by Xinyuan Wang on 7/9/2017.
 */
public class TwitterServer extends Observable implements Server {

    private Map<String,Component> componentMap;

    private Component root;

    private static TwitterServer instance;

    private TwitterServer()
    {
        componentMap = new HashMap<>();
        String rootID = "Root";
        root = new UserGroup(rootID);
        componentMap.put(rootID,root);
    }

    public static TwitterServer getInstance()
    {
        if(instance==null)
        {
            synchronized (TwitterServer.class)
            {
                if(instance==null)
                    instance = new TwitterServer();
            }
        }
        return instance;
    }

    @Override
    public void addComponent(Component newComponent, Component parentComponent) throws ServerException {
        if(componentMap.containsKey(newComponent.getID()))
            throw new ServerException("The ID already exists.");
        else
        {
            parentComponent.addComponent(newComponent);
            componentMap.put(newComponent.getID(),newComponent);
            notifyAllObserver(new UIUpdateIntent());
        }

    }

    @Override
    public Component getRoot()
    {
        return  root;
    }

    @Override
    public void postTextTweet(String userID, String text) {


    }

    @Override
    public void attachObserverToUser(String ID, Observer observer) {


    }

    @Override
    public void detachObserverFromUser(String ID, Observer observer) {

    }

    @Override
    public void follow(String followerID, String followingTarget) {

    }






}
