package com.epam.javaacademy.bookrobot;
import java.io.IOException;

import org.apache.log4j.Appender;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;


public class SearchController 
{
    public static void main( String[] args ) throws IOException
    {
    	logForStart();
	    SiteContentSearcher searcher = new SiteContentSearcher();
	    
	    searcher.searchAllSitesForBooks(new CompleteListOfURLs());
    }

	private static void logForStart() {
		Layout layout = new PatternLayout("[%p] %c - %m - Data wpisu: %d %n");
		Appender appender = createAppender(layout);
		
		BasicConfigurator.configure(appender);
		Logger logger = Logger.getRootLogger();
		logger.debug("Hello world");
	}

	private static Appender createAppender(Layout layout) {
		Appender appender = null;
		
		try {
			appender = new FileAppender(layout, "../LogDiary.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return appender;
	}
}

