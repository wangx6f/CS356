package edu.cpp.cs356.assignment1;

import java.util.Set;

/**
 * Created by Xinyuan Wang on 6/30/2017.
 * This is the interface for trasmission between {@link Student} and {@link IVoteService}
 */
public interface Messager {

    boolean setMessage(Set<String> answer);

    Set<String> getMessage();
}
