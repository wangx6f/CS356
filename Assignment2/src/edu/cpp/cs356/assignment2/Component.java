package edu.cpp.cs356.assignment2;

import java.util.List;


/**
 * Created by Xinyuan Wang on 7/9/2017.
 */
public interface Component  {

    public String getID();

    public void addComponent(Component child) throws ServerException;

    public List<Component> getChildren();


}
