package com.epam.javaacademy.bookrobot;

import static com.epam.javaacademy.bookrobot.SearchingLogger.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;
import java.util.Map.Entry;

public class BooksToFileWriter {
	private BufferedWriter writer;
	
	public BooksToFileWriter() {
		File file = new File("../FoundBooks.txt");
		try {
			writer = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
		} catch (FileNotFoundException e) {
			logForImpossibilityToFindTheFileToWriteIn();
		} catch (IOException e){
			logForIOException();
		}
	}
	
	public void write(Map<String, String> map) throws IOException{
		
		Calendar calendar = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd HH:mm:ss");
		writer.write(dateFormat.format(calendar.getTime()) + "\n");
		
		for(Entry<String, String> entry : map.entrySet()){
			writer.write(entry.getKey() + "\t\t\t" + entry.getValue() + "\n");
		}
		
		writer.close();
		
	}
	
}
