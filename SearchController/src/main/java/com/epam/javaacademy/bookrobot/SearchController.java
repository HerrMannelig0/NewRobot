package com.epam.javaacademy.bookrobot;
import java.io.IOException;

import org.apache.log4j.Appender;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import static com.epam.javaacademy.bookrobot.SearchingLogger.*;

public class SearchController 
{
    public static void main( String[] args ) throws IOException
    {
    	logForProgramStart();
	    SiteContentSearcher searcher = new SiteContentSearcher();
	    
	    searcher.searchAllSitesForBooks(new CompleteListOfURLs());
    }

}

