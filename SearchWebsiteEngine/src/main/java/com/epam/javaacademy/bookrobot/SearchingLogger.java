package com.epam.javaacademy.bookrobot;

import java.io.IOException;
import org.apache.log4j.Appender;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;


public class SearchingLogger {
	
	static Logger logger = addLoggerSettings();
	
	public static void logForHttpStatusException() {
		logger.error("HttpStatusException occured");
	}
	
	public static void logForUnsupportedMimeTypeException() {
		logger.error("UnsuportedMimeTypeException occured");
	}
	
	public static void logForIllegalArgumentException() {
		logger.error("IllegalArgumentException occured");
	}
	
	public static void logForIOException() {
		logger.error("IOException occured");
	}
	
	public static void logForOtherException() {
		logger.error("Other type of exception occured");
	}

	public static void logFoundBooksNumber(int n){
		logger.info(n + " free books have been found");
	}
	
	public static void logForProgramStart(){
		logger.info("Program started");
	}
	
	public static void logForSearchingStart(){
		logger.info("New searching started");
	}

	public static void logForImpossibilityToFindTheFileToWriteIn(){
		logger.fatal("Cannot find the file to write");
	}
	
	private static Logger addLoggerSettings() {
		Layout layout = new PatternLayout("[%p] %c - %m - Data wpisu: %d %n");
		Appender appender = createAppender(layout);
		
		BasicConfigurator.configure(appender);
		
		return Logger.getRootLogger();
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
