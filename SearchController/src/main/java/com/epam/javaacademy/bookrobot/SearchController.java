package com.epam.javaacademy.bookrobot;
import org.apache.log4j.Appender;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;


public class SearchController 
{
    public static void main( String[] args )
    {
    	logForStart();
	    SiteContentSearcher searcher = new SiteContentSearcher();
	    searcher.searchOnSite();
    }

	private static void logForStart() {
		Layout layout = new PatternLayout("[%p] %c - %m - Data wpisu: %d %n");
		Appender appender = new ConsoleAppender(layout);
		BasicConfigurator.configure(appender);
		Logger logger = Logger.getRootLogger();
		logger.debug("Hello world");
	}
}

