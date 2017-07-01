package edu.cpp.cs356.assignment1;

import java.util.Collection;

/**
 * Created by Xinyuan Wang on 6/30/2017.
 * A general interface for print report that base some data of {@link Messager}
 */
public interface ReportPrinter {

    public void printReport(Collection<Messager> data);
}
