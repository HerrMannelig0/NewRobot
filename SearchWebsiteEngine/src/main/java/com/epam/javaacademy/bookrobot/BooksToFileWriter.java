package com.epam.javaacademy.bookrobot;

import static com.epam.javaacademy.bookrobot.SearchingLogger.logForImpossibilityToFindTheFileToWriteIn;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.SimpleFormatter;

public class BooksToFileWriter {
	private PrintWriter writer;
	
	public BooksToFileWriter() {
		try {
			writer = new PrintWriter("../FoundBooks.txt");
		} catch (FileNotFoundException e) {
			logForImpossibilityToFindTheFileToWriteIn();
		}
	}
	
	public void write(Map<String, String> map){
		
		Calendar calendar = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd HH:mm:ss");
		System.out.println(dateFormat.format(calendar.getTime()));
		
		for(Entry<String, String> entry : map.entrySet()){
			writer.write(entry.getKey() + "\t\t\t" + entry.getValue());
		}
		System.out.println();
	}
	
}
