package edu.cpp.cs356.assignment1;

/**
 * Created by Xinyuan Wang on 6/30/2017.
 * This is the interface for question which is used to config the {@link IVoteService} and
 * can generate a {@link Messager} and a {@link ReportPrinter}
 * When new {@link Messager} is generated, specific rules will be applied
 */
public interface Question {

    public Messager getNewMessager();

    public ReportPrinter getReportPrinter();

}
