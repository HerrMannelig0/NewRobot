package com.epam.javaacademy.bookrobot;

import static com.epam.javaacademy.bookrobot.SearchingLogger.logForIOException;
import static com.epam.javaacademy.bookrobot.SearchingLogger.logForImpossibilityToFindTheFileToWriteIn;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;
import java.util.Map.Entry;

public class BooksToFileWriter {
	private PrintWriter writer;
	
	public BooksToFileWriter() {
		File file = new File("../FoundBooks.txt");
		try {
			writer = new PrintWriter(new BufferedWriter(new FileWriter(file.getAbsoluteFile(), true)));
		} catch (FileNotFoundException e) {
			logForImpossibilityToFindTheFileToWriteIn();
		} catch (IOException e){
			logForIOException("Problems with writing books in file");
		}
	}
	
	public void write(Map<String, String> map) throws IOException{
		
		Calendar calendar = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd HH:mm:ss");
		writer.write(dateFormat.format(calendar.getTime()) + "\n");
		
		for(Entry<String, String> entry : map.entrySet()){
			writer.write(entry.getKey() + "\t\t\t" + entry.getValue() + "\n");
		}
		
		writer.write("#################################################################");
		
		writer.close();
		
	}
	
}
