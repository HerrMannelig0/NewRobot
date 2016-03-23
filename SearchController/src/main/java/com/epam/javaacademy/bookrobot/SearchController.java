package com.epam.javaacademy.bookrobot;
import static com.epam.javaacademy.bookrobot.SearchingLogger.logForProgramStart;

import java.io.IOException;

public class SearchController 
{
    public static void main( String[] args ) throws IOException
    {
    	logForProgramStart();
	    SiteContentSearcher searcher = new SiteContentSearcher();
	    searcher.searchAllSitesForBooks(new CompleteListOfURLs());
    }

}

